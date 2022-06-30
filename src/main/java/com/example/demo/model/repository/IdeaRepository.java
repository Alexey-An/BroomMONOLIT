package com.example.demo.model.repository;

import com.example.demo.entity.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ideas", path = "ideas")
public interface IdeaRepository extends JpaRepository<Idea, Long> {
}