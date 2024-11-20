package com.lecture13.SSF_lecture_13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecture13.SSF_lecture_13.model.Person;
import com.lecture13.SSF_lecture_13.repo.PersonRepo;

@Service
public class PersonService {
    
    @Autowired
    PersonRepo personRepo;

    public List<Person> findAll(){
        return personRepo.findAll();
    }
    public Boolean create(Person person){
        return personRepo.create(person);
    }
    public Boolean delete(Person person){
        return personRepo.delete(person);
    }
}
