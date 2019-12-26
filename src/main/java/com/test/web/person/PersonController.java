package com.test.web.person;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.web.util.Printer;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private Printer printer;
	@Autowired
	private Person person;
	
	@RequestMapping("/")
	public String index() {
		Iterable<Person> all = personRepository.findAll();
		StringBuilder sb = new StringBuilder();
		all.forEach(p -> sb.append(p.getName()+" "));
		return sb.toString();
	}
	@PostMapping("/login")
	public HashMap<String,Object> login(@RequestBody Person param) {
		HashMap<String,Object> map = new HashMap<>();
		printer.accept("로그인 진입");
		printer.accept(String.format("USERID: %s", param.getUserid()));
		printer.accept(String.format("PASSWD: %s", param.getPasswd()));
		person = personRepository.findByUseridAndPasswd(
				param.getUserid(), 
				param.getPasswd());
		if(person != null) {
			printer.accept("로그인 성공");
			map.put("result", "SUCCESS");
			map.put("person", person);
		}else {
			printer.accept("로그인 실패");
			map.put("result", "FAIL");
			map.put("result", person);
		}
		return map;
	}
	@PostMapping("/cjoin")
	public HashMap<String,Object> Cjoin(@RequestBody Person param) {
		HashMap<String,Object> map = new HashMap<>();
		printer.accept("가입 진입");
		printer.accept(String.format("USERID: %s", param.getUserid()));
		printer.accept(String.format("PASSWD: %s", param.getPasswd()));
		printer.accept(String.format("PASSWD: %s", param.getName()));
		printer.accept(String.format("PASSWD: %s", param.getBirthday()));
		printer.accept(String.format("PASSWD: %s", param.getGender()));
		printer.accept(String.format("PASSWD: %s", param.getHak()));
		printer.accept(String.format("PASSWD: %s", param.getBan()));
		printer.accept(String.format("PASSWD: %s", param.getScore()));
		printer.accept(String.format("PASSWD: %s", param.getRole()));
		personRepository.save(param);
		if(person != null) {
			printer.accept("가입 성공");
			map.put("result", "SUCCESS");
			map.put("person", person);
		}else {
			printer.accept("가입 실패");
			map.put("result", "FAIL");
			map.put("result", person);
		}
		return map;
	}
	@DeleteMapping("/withdrawal")
	public void withdrawal(@PathVariable String userid) {
		personRepository
		.delete(personRepository
				.findByUserid(userid));
	}
}
