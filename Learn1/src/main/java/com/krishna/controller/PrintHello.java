package com.krishna.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.krishna.Entity.Post;
import com.krishna.Entity.User;
import com.krishna.Exceptions.UserNotFoundException;
import com.krishna.Service.ServiceInterface;
import com.krishna.controller.model.HelloBean;
import com.krishna.repository.Postrepository;

import jakarta.validation.Valid;

@RestController
public class PrintHello {
	@Autowired
	ServiceInterface serviceInterface;
	@Autowired
	private Postrepository postrepository;
	private MessageSource messagesource;

	public PrintHello(MessageSource messagesource) {
		this.messagesource = messagesource;
	}

	@GetMapping("/internationalization")
	private String hellomessage(@RequestParam String name) {
		Locale locale = LocaleContextHolder.getLocale();
		return messagesource.getMessage("name", new Object[] { name }, "Default message", locale);
	}

	@GetMapping("/hello") // @RequestMapping(method=RequestMethod.GET, path="/hello")
	public String hello() {
		return "hello-world";
	}

	@GetMapping("/hello-bean")
	public HelloBean helloBean() {
		return new HelloBean("hellobean");
	}

	@GetMapping("/hello-bean/path-variable/{name}")
	public String hellopathVariable(@PathVariable String name) {
		return String.format("Hello Sir ," + name);
	}

	@GetMapping("/users")
	public List<User> allUsers() {
		return serviceInterface.fetchuser();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> users1(@PathVariable int id) throws UserNotFoundException {
		User user = serviceInterface.fetchuserpath(id);
		if (user == null) {
			throw new UserNotFoundException("id :" + id);
		}
		EntityModel entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).allUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;

	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) throws UserNotFoundException {
		serviceInterface.deleteUser(id);
	}

	@GetMapping("/users/posts/{id}")
	public List<Post> retriveuserPost(@PathVariable int id) throws UserNotFoundException {
		User user = serviceInterface.fetchuserpath(id);
		if (user == null) {
			throw new UserNotFoundException("id :" + id);
		}

		return user.getPost();

	}

	@PostMapping("/users/add")
	public ResponseEntity<User> adduser(@Valid @RequestBody User userdetail) {
		User user = serviceInterface.addingUser(userdetail);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping("/users/add/posts/{id}")
	public ResponseEntity<Object> createPostUser(@PathVariable int id, @Valid @RequestBody Post post)
			throws UserNotFoundException {
		User user = serviceInterface.fetchuserpath(id);
		if (user == null) {
			throw new UserNotFoundException("id :" + id);
		}
		post.setUser(user);
		Post savepost = postrepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savepost.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
