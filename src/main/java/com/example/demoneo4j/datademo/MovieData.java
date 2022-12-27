package com.example.demoneo4j.datademo;

import javax.annotation.PostConstruct;

import java.util.List;
import java.util.Set;

import com.example.demoneo4j.modal.ExtendedPerson;
import com.example.demoneo4j.modal.Movie;
import com.example.demoneo4j.service.ExtendedPersonService;
import com.example.demoneo4j.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("extendedPersonData")
public class MovieData {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ExtendedPersonService extendedPersonService;

//    @PostConstruct
    public void demo1() {
        ExtendedPerson lan = extendedPersonService.getPersonByName("Lan").orElse(null);
        Set<ExtendedPerson> lanFriends = extendedPersonService.getKnowPersonById(lan.getId());
        lanFriends.add(lan);

        Movie movie = new Movie("Frozen", List.copyOf(lanFriends));
        movieService.save(movie);
    }
}
