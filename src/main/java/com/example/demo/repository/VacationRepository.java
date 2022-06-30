package com.example.demo.repository;

import com.example.demo.entity.Vacation;
import com.example.demo.projection.IdeaView;
import com.example.demo.projection.VacationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = VacationView.class, collectionResourceRel = "vacations", path = "vacations")
public interface VacationRepository extends JpaRepository<Vacation, Long> {
}