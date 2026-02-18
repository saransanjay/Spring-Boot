package com.practice.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.springbootdemo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

	
}
