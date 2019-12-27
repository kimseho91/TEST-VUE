package com.test.web.person;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	public Person findByUseridAndPasswd(String userid, String passwd);
	public Person findByUserid(String userid);
	/* public Person findByRole(String role); */
	@Transactional
	public void removeByUseridAndPasswd(String userid, String passwd);
	
	@Query(value="SELECT MAX(p.score) score, p.userid, p.name,p.hak,p.id,p.ban,p.birthday,p.role,p.gender,p.passwd FROM PERSON p WHERE p.role = \"student\" GROUP BY p.HAK", nativeQuery = true)
	public List<Person> findGroupByHak();
	public List<Person> findByRole(String role);
}
