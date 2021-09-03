package pl.sda.dao.impl;

import pl.sda.dao.PersonDao;
import pl.sda.model.Person;

//klasa atrapa - nie zawiera poprawnej implementacji
public class PersonDaoMockImpl implements PersonDao {

    @Override
    public void add(Person person) {

    }

    @Override
    public Person getById(Integer id) {
        return null;
    }
}
