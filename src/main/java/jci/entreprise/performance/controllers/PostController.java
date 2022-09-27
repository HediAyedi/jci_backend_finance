package jci.entreprise.performance.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.PostCategory;
import jci.entreprise.performance.services.impl.PostServiceImpl;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	private final PostServiceImpl postServiceImpl ;

	public PostController(PostServiceImpl postServiceImpl) {
		this.postServiceImpl = postServiceImpl;
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> save(@RequestParam("image") MultipartFile image,
			@RequestParam("postName") String postName , 
			@RequestParam("description") String description ,
			@RequestParam("postCategory") PostCategory postCategory ,
			@RequestParam("UserId") Long userId){
		return postServiceImpl.createPost(image,postName,description,postCategory,userId);
	}
	
	@GetMapping("/getAll")
	public List<Post> getAll(){
		return postServiceImpl.getAllPosts();
	}
	

}
