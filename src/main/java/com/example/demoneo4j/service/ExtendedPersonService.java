package com.example.demoneo4j.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demoneo4j.dao.ExtendedPersonDao;
import com.example.demoneo4j.modal.ExtendedPerson;
import org.neo4j.cypherdsl.core.Cypher;
import org.neo4j.cypherdsl.core.Node;
import org.neo4j.cypherdsl.core.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Service;

@Service
public class ExtendedPersonService {

    @Autowired
    private Neo4jTemplate template;

    @Autowired
    private ExtendedPersonDao extendedPersonDao;

    public Optional<ExtendedPerson> getPerson(Long id) {
        return extendedPersonDao.findById(id);
    }

    public Optional<ExtendedPerson> getPersonByName(String name) {
        return extendedPersonDao.findByName(name);
    }

    public Set<ExtendedPerson> getPerson(Long id, int depth) {
        Node nodePerson = Cypher
            .node("ExtendedPerson")
            .named("p");

        Node nodePersonKnow = Cypher
            .node("ExtendedPerson")
            .named("knowPersons");

        Statement statement = Statement
            .builder()
            .match(nodePerson.relationshipTo(nodePersonKnow, "KnowPerson").length(1, depth))
            .where(nodePerson.internalId().eq(Cypher.literalOf(id)))
            .returning(nodePersonKnow)
            .build();

        System.out.println("Query: " + statement.getCypher());
        List<ExtendedPerson> a = template.findAll(statement, ExtendedPerson.class);
        return Set.copyOf(a);
//        return extendedPersonDao.findByIdAndDepth(id, depth);
    }

    public Set<ExtendedPerson> getKnowPersonById(Long id) {
        return extendedPersonDao.findKnowPersonById(id);
    }

    public void addPerson(ExtendedPerson person) {
        extendedPersonDao.save(person);
    }

    public List<ExtendedPerson> getAll() {
        return extendedPersonDao.findAll();
    }

}
