package com.example.demoneo4j.dao;

import com.example.demoneo4j.modal.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieDao extends Neo4jRepository<Movie, String> {

}
