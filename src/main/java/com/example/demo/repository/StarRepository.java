package com.example.demo.repository;

import com.example.demo.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "stars", path = "stars")
public interface StarRepository extends JpaRepository<Star, Long> {
}