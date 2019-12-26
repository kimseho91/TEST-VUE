package com.test.web.person;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	public Person findByUseridAndPasswd(String userid, String passwd);
	public Person findByUserid(String userid);
	
}
