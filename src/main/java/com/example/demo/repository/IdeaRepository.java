package com.example.demo.repository;

import com.example.demo.entity.Idea;
import com.example.demo.projection.IdeaView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = IdeaView.class, collectionResourceRel = "ideas", path = "ideas")
public interface IdeaRepository extends JpaRepository<Idea, Long> {
}