package com.ty.com.ty.springboot_hospital_eb9.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.ty.com.ty.springboot_hospital_eb9.dto.Person;
import com.ty.com.ty.springboot_hospital_eb9.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository repository;

	public Person savePeson(Person person) {
		return repository.save(person);
	}

	public Person updatePerson(int id, Person person) {
		if (repository.findById(id).isPresent()) {
			person.setId(id);
			return repository.save(person);

		} else {
			return null;
		}
	}

	public Person deletePerson(int id) {

		if (repository.findById(id).isPresent()) {
			Person person = repository.findById(id).get();

			repository.delete(person);
			return person;

		} else {
			return null;
		}
	}

	public Person getPersonById(int id) {
		if (repository.findById(id).isPresent()) {
			return repository.findById(id).get();
		} else {
			return null;
		}
	}
}
