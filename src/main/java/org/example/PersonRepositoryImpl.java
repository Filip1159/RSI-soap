package org.example;

import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {
    private List<Person> personList;

    public PersonRepositoryImpl() {
        personList = new ArrayList<>();
        personList.add(new Person(1, "Mariusz", 9));
        personList.add(new Person(2, "Andrzej", 10));
    }

    @Override
    public List<Person> getAllPersons() {
        return personList;
    }

    @Override
    public Person getPerson (int id) throws PersonNotFoundEx {
        for (Person thePerson: personList) {
            if (thePerson.getId() == id) {
                return thePerson;
            }
        }
        throw new PersonNotFoundEx();
    }

    @Override
    public Person addPerson(int id, String name, int age) throws PersonExistsEx {
        for (Person thePerson: personList) {
            if (thePerson.getId() == id) {
                throw new PersonExistsEx();
            }
        }
        Person person = new Person(id, name, age);
        personList.add(person);
        return person;
    }

    @Override
    public boolean deletePerson(int id) throws PersonNotFoundEx {
        for (Person thePerson: personList) {
            if (thePerson.getId() == id) {
                personList.remove(thePerson);
                return true;
            }
        }
        throw new PersonNotFoundEx();
    }

    @Override
    public Person updatePerson(int id, String name, int age) throws PersonNotFoundEx {
        for (Person thePerson: personList) {
            if (thePerson.getId() == id) {
                thePerson.setFirstName(name);
                thePerson.setAge(age);
                return thePerson;
            }
        }
        throw new PersonNotFoundEx();
    }

    @Override
    public int countPersons() {
        return personList.size();
    }
}
