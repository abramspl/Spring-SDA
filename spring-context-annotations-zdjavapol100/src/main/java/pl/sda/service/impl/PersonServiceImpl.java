package pl.sda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import pl.sda.dao.PersonDao;
import pl.sda.model.Person;
import pl.sda.service.PersonService;
import pl.sda.validator.PersonValidator;

public class PersonServiceImpl implements PersonService {

    @Qualifier("personDaoMemory") //zakwalifikuj mi tego beana do wstrzyknięcia
    //wstrzykiwanie bezpośrednio do pola
    @Autowired // zadziała jeśli pole jest typem Bean (PersonDao)
    private PersonDao personDao;

    @Autowired
    private PersonValidator validator;

    @Override
    public void add(Person person) {
        if (validator.isValid(person)) {
            personDao.add(person);
        }
    }

    @Override
    public Person getById(Integer id) {
        return personDao.getById(id);
    }

}
