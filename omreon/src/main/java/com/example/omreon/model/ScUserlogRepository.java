package com.example.omreon.model;


import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface ScUserlogRepository extends CrudRepository<ScUserlog, Long>, JpaRepository<ScUserlog, Long>{

		// CRUD ve JPA implementasyonlarının yapılması
}
