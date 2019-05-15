package com.taegyun.tdl.repository;

import com.taegyun.tdl.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(String id);
}
