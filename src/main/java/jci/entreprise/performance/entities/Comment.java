package jci.entreprise.performance.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comId ;
    @NotNull
    @Lob
    private String text ;
    private Instant createDate ;
    //relations: user comment
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId" , referencedColumnName = "userId")
    private User user ;
    //post comment
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId" , referencedColumnName = "postId")
    private Post post ;
	public Long getComId() {
		return comId;
	}
	public void setComId(Long comId) {
		this.comId = comId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Instant getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Instant createDate) {
		this.createDate = createDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Comment(Long comId, String text, Instant createDate, User user, Post post) {
		super();
		this.comId = comId;
		this.text = text;
		this.createDate = createDate;
		this.user = user;
		this.post = post;
	}
	public Comment() {
	}
	@Override
	public String toString() {
		return "Comment [comId=" + comId + ", text=" + text + ", createDate=" + createDate + ", user=" + user
				+ ", post=" + post + "]";
	}

}
