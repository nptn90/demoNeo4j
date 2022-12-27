package com.example.demoneo4j.datademo;

import javax.annotation.PostConstruct;

import java.util.List;

import com.example.demoneo4j.modal.ExtendedPerson;
import com.example.demoneo4j.service.ExtendedPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExtendedPersonData {

    @Autowired
    private ExtendedPersonService extendedPersonService;

//    @PostConstruct
    public void demo2() {

        ExtendedPerson nam = new ExtendedPerson("Nam", 13);

        ExtendedPerson cuong = new ExtendedPerson("Cuong", 10, List.of(nam, new ExtendedPerson("Long", 20)));

        ExtendedPerson quoc = new ExtendedPerson("Quoc", 10, List.of(
            cuong
        ));

        ExtendedPerson lan = new ExtendedPerson("Lan", 12, List.of(
            quoc
        ));

        extendedPersonService.addPerson(lan);

        lan.knowThisPerson(nam);
        extendedPersonService.addPerson(lan);

        ExtendedPerson hoang = new ExtendedPerson("Hoang", 12, List.of(
            lan, nam
        ));

        extendedPersonService.addPerson(hoang);
    }
}
