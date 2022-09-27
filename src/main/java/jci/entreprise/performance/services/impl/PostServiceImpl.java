package jci.entreprise.performance.services.impl;

import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.PostCategory;
import jci.entreprise.performance.entities.User;
import jci.entreprise.performance.repositories.PostRepository;
import jci.entreprise.performance.services.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
	
	private final PostRepository postRepository ;
		
    public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
    public ResponseEntity<String> createPost(MultipartFile image , String postName , String description ,PostCategory postCategory,Long UserId) {
    	
		String fileName = StringUtils.cleanPath(image.getOriginalFilename());

		Post post = new Post();
    	
    	post.setPostName(postName);
    	post.setDescription(description);
    	try {
			post.setPostImage(Base64.getEncoder().encodeToString(image.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	post.setPostCategory(postCategory);
    	
    	User user = new User();
    	user.setUserId(UserId);
    	post.setUser(user);
    	postRepository.save(post);
    	return ResponseEntity.status(HttpStatus.OK).body("Post saved succesfully") ;
    	
    }

    @Override
    public ResponseEntity<String> deletePost(Long id) {
		return null;

    }

    @Override
    public ResponseEntity<String> updatePost(Post post) {
		return null;

    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getPostByCategory(PostCategory category) {
        return null;
    }

    @Override
    public List<Post> getRecentPost() {
        return null;
    }

    @Override
    public List<Post> getOldestPost() {
        return null;
    }

    @Override
    public List<Post> getPostContains(String characters) {
        return null;
    }
}
