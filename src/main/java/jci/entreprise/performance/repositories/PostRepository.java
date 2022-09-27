package jci.entreprise.performance.repositories;

import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.PostCategory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    //getByCategory
    public List<Post> findByPostCategory(PostCategory category);
    public List<Post> findByPostNameContainingIgnoreCase(String postName);
    public List<Post> findAll(Sort sort); //arrow
    //public List<Post> findByOrderByCreatedDateDesc(Date date);




}
