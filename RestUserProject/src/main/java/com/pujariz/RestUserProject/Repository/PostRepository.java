package com.pujariz.RestUserProject.Repository;

import com.pujariz.RestUserProject.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Method to find posts by user ID
    List<Post> findByUser_Id(long userId);
}
