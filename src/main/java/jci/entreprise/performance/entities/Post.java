package jci.entreprise.performance.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Blob;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId ;
    @NotNull
    private String postName ;
    private Instant createdDate ;
    @Nullable
    private String postImage ;
    private Instant updatedDate ;
    @Lob
    private String description ;
    //one to one
    private PostCategory postCategory ;
    //relation POST COMMENT
    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments ;
    //user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId" , referencedColumnName = "userId")
    private  User user ;
    
    
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public Instant getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}
	public String getPostImage() {
		return postImage;
	}
	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}
	public Instant getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Instant updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PostCategory getPostCategory() {
		return postCategory;
	}
	public void setPostCategory(PostCategory postCategory) {
		this.postCategory = postCategory;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post(Long postId, String postName, Instant createdDate, String postImage, Instant updatedDate,
			String description, PostCategory postCategory, List<Comment> comments, User user) {
		super();
		this.postId = postId;
		this.postName = postName;
		this.createdDate = createdDate;
		this.postImage = postImage;
		this.updatedDate = updatedDate;
		this.description = description;
		this.postCategory = postCategory;
		this.comments = comments;
		this.user = user;
	}
	public Post() {
		super();
	}
    
    
    

}
