package com.example.demo.repository;

import com.example.demo.entity.Merch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "merch", path = "merch")
public interface MerchRepository extends JpaRepository<Merch, Long> {
}
