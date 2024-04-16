package com.learn.silverbars.repository;

import com.learn.silverbars.model.Order;
import com.learn.silverbars.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
