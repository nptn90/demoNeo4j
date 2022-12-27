package com.example.demoneo4j.dao;

import com.example.demoneo4j.modal.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonDao extends Neo4jRepository <Person, Long> {
}
