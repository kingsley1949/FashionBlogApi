package com.blaze.fashionBlog.repository;

import com.blaze.fashionBlog.entity.BlogPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogPostRepo extends JpaRepository<BlogPost, Long> {
    Optional<BlogPost> findBlogPostById(Long PostId);

}
