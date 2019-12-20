package com.test.web.person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PersonInit implements ApplicationRunner {	
	private PersonRepository personRepository;
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public PersonInit(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = personRepository.count();
		if (count == 0) {
			Person person = null;
			String[][] mtx = {{ "hong", "1", "홍길동", "1443-01-01" }, 
					{ "you", "1", "유관순", "1902-12-16" },
					{ "son", "1", "손흥민", "1992-07-08" },
					{ "kim", "1", "김세호", "1991-10-28" } 
					};
			for (String[] arr : mtx) {
				person = new Person();
				person.setUserid(arr[0]);
				person.setPasswd(arr[1]);
				person.setName(arr[2]);
				person.setBirthday(df.parse(arr[3]));
				personRepository.save(person);
			}
			 /*
			 for (int i = 0; i < mtx.length; i++) { 
			 person = new Person(); 
			 person.setUserid(mtx[i][0]); 
			 person.setPasswd(mtx[i][1]);
			 person.setName(mtx[i][2]); 
			 person.setBirthday(df.parse(mtx[i][3]));
			 personRepository.save(person); 
			 }
			 */
		}

	}

}
