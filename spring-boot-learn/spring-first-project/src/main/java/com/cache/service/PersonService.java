package com.cache.service;

import com.cache.bean.Person;
import com.cache.repository.PersonRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class PersonService {

	@Resource
	private PersonRepository personRepository;
	
	@Transactional
	public void saveAll(List<Person> persons) {
		personRepository.saveAll(persons);
	}
	
	public List<Person> findPersonByName(String userName) {
		return personRepository.findPersonByName(userName);
	}
	
	public List<Person> findPersonByAddress(String address){
		return personRepository.findPersonByAddress(address);
	}
	
	public Person findPersonById(Integer id){
		return personRepository.findPersonById(id);
	}
}