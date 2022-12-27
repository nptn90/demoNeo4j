package com.example.demoneo4j.modal;

import java.util.List;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node(Movie.NODE_NAME)
public class Movie {
    public static final String NODE_NAME = "Movie";

    @Id
    private final String name;

    @Relationship(direction = Relationship.Direction.INCOMING)
    private final List<ExtendedPerson> watchedPersons;

    public Movie(String name, List<ExtendedPerson> watchedPersons) {
        this.name = name;
        this.watchedPersons = watchedPersons;
    }

    public String getName() {
        return name;
    }

    public List<ExtendedPerson> getWatchedPersons() {
        return watchedPersons;
    }
}
