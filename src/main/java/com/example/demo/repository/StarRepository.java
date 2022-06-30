package com.example.demo.repository;

import com.example.demo.entity.Star;
import com.example.demo.projection.IdeaView;
import com.example.demo.projection.StarView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = StarView.class, collectionResourceRel = "stars", path = "stars")
public interface StarRepository extends JpaRepository<Star, Long> {
}