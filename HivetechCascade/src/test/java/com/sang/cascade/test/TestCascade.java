package com.sang.cascade.test;

import com.sang.cascade.Entity.presist.Address;
import com.sang.cascade.Entity.presist.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Transactional
class TestCascade {
    @Autowired
    protected EntityManager session;

    @Test
    public void whenParentSavedThenMerged() {
        int addressId;
        Person person =  Person.builder().name("tét").build();
        Address address = Address.builder().houseNumber(2).city("hanoi").person(person).build();
        person.setAddresses(Arrays.asList(address));
        session.persist(person);
        session.flush();
        addressId = address.getId();
        session.clear();

        Address savedAddressEntity = session.find(Address.class, addressId);
        Person savedPersonEntity = savedAddressEntity.getPerson();
        savedPersonEntity.setName("new name");
        savedAddressEntity.setHouseNumber(25);
        session.merge(savedPersonEntity);
        session.flush();
    }

    @Test
    public void whenParentSavedThenChildSaved() {
        Person person = new Person();
        Address address = new Address();
        address.setPerson(person);
        person.setAddresses(Arrays.asList(address));
        session.persist(person);
        session.flush();
        session.clear();
    }

    @Test
    public void whenParentRemovedThenChildRemoved() {
        int personId;
        Person person = Person.builder().name("tét").build();
        Address address = Address.builder().houseNumber(2).city("hanoi").person(person).build();
        person.setAddresses(Arrays.asList(address));
        session.persist(person);
        session.flush();
        personId = person.getId();
        session.clear();

        Person savedPersonEntity = session.find(Person.class, personId);
        session.remove(savedPersonEntity);
        session.flush();
    }

}