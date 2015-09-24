package com.example.nonel.bootcamp;

import com.example.nonel.bootcamp.Model.Person;

import java.util.ArrayList;

public interface PersonDao {
    public boolean savePerson(ArrayList<Person> person);
    public ArrayList<Person> getPersons();
    public Person getPerson(int id);
    public boolean updatePerson(int id, Person person);
}
