package com.rest.webservice.restfulwebservice.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservice.restfulwebservice.exception.UserNotFoundException;

@RestController
public class UserJPAResource {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	
	@Autowired
	UserRepository userRepository;
	
	
	
	@Autowired
	PostRepository postRepository;


	// Retrive all the user
	@GetMapping("/jpa/users")
	public List<User> retriveAllUsers() {

		return userRepository.findAll();
	}
	
	


	// Retrive specific user
	@GetMapping("/jpa/users/{id}")

	public Resource<User> retriveUser(@PathVariable int id) {

		Optional<User> user =userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id ::" +id);
		}
		Resource<User> resource=new Resource<User>(user.get());
		ControllerLinkBuilder linkTo=  linkTo(methodOn(this.getClass()).retriveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

		User savedUser = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")

	public void deleteUser(@PathVariable int id) {

		userRepository.deleteById(id);

	}
	
	@GetMapping("/jpa/users/{id}/post")

	public List<Post> retriveUserPost(@PathVariable int id) {

		Optional<User> user =userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id ::" +id);
		}
		
		return (user.get().getPosts());
		
		
		
	}
	
	@PostMapping("/jpa/users/{id}/post")
	public ResponseEntity<Object> createUserPost(@PathVariable int id, @RequestBody Post post) {

		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id ::" + id);
		}

		User user = userOptional.get();

		post.setUser(user);

		Post postUser = postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	

}
