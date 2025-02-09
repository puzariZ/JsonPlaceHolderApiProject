package com.pujariz.RestUserProject.Repository;

import com.pujariz.RestUserProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
