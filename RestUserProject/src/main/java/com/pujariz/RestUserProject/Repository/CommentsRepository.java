package com.pujariz.RestUserProject.Repository;

import com.pujariz.RestUserProject.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository  extends JpaRepository<Comments, Long> {
}
