package com.lecture13.SSF_lecture_13.repo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.lecture13.SSF_lecture_13.model.Person;

@Repository
public class PersonRepo {
    private List<Person> persons = new ArrayList<>();
    public List<Person> findAll(){
        return persons;
    }
    public PersonRepo() throws ParseException{
        String bday = "1201-12-12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(bday);
        persons.add(new Person("jonathan","ng","jonng@gmail.com",2000,birthday));

    }
    public Boolean create(Person person){
        persons.add(person);
        return true;
    }
    public Boolean delete(Person person){
        persons.remove(person);
        return true;
    }
    public Boolean update(Person person){
        List<Person> filteredPerson = persons.stream().filter(p -> p.getId().equals(person.getId())).collect(Collectors.toList());
        if (filteredPerson.size()>0){
            persons.remove(filteredPerson.getFirst());
            persons.add(person);
            return true;
        }
        return false;
    }

}
