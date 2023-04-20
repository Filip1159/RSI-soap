package org.example;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService(serviceName = "PersonService", endpointInterface = "org.example.PersonService")
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository = new PersonRepositoryImpl();

    @Override
    @WebMethod
    public Person getPerson(int id) throws PersonNotFoundEx {
        System.out.println("...called getPerson id=" + id);
        return personRepository.getPerson(id);
    }

    @Override
    @WebMethod
    public List<Person> getAllPersons() {
        System.out.println("...called getAllPersons");
        return personRepository.getAllPersons();
    }

    @Override
    @WebMethod
    public Person addPerson(int id, String name, int age) throws PersonExistsEx {
        System.out.println("... called addPerson id=" + id + " name=" + name + " age=" + age);
        return personRepository.addPerson(id, name, age);
    }

    @Override
    @WebMethod
    public boolean deletePerson(int id) throws PersonNotFoundEx {
        System.out.println("...called deletePerson id=" + id);
        return personRepository.deletePerson(id);
    }

    @Override
    @WebMethod
    public int countPersons() {
        System.out.println("... calles countPersons");
        return personRepository.countPersons();
    }
}
