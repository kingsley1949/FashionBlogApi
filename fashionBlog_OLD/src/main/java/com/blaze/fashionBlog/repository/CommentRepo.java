package com.blaze.fashionBlog.repository;

import com.blaze.fashionBlog.entity.BlogPost;
import com.blaze.fashionBlog.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findByBlogPostId(Long id);

    @Query("SELECT c FROM Comment c WHERE LOWER(c.content) LIKE %:keyword%")
    List<Comment> searchByContent(@Param("keyword")String keyword);

    @Query("SELECT c FROM Comment c WHERE LOWER(c.content) LIKE %:keyword%")
    Page<Comment> searchByContent(String keyword, Pageable pageable);

}
