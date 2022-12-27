package com.example.demoneo4j.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demoneo4j.modal.ExtendedPerson;
import com.example.demoneo4j.modal.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface ExtendedPersonDao extends Neo4jRepository <ExtendedPerson, Long> {

    @Query("match (p:ExtendedPerson)-[ :KnowPerson* ]->(knowPerson:ExtendedPerson)\n"
        + "where id(p)=$id\n"
        + "return knowPerson")
    Set<ExtendedPerson> findKnowPersonById(Long id);

    @Query("MATCH p=(:ExtendedPerson)-[r*1..3]->()\n"
        + "RETURN nodes(p) AS nodes")
    List<ExtendedPerson> findAll();

    Optional<ExtendedPerson> findByName(String name);

    @Query("match (p:ExtendedPerson)-[ :KnowPerson*1..3 ]->(knowPerson:ExtendedPerson)\n"
        + "where id(p)=$id\n"
        + "return knowPerson")
    Set<ExtendedPerson> findByIdAndDepth(Long id, int depth);
}
