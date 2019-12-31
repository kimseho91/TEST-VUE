package com.test.web.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
	@Autowired private PersonRepository personRepository;
	@Autowired private Printer printer;
	@Autowired private Person person;
	@Autowired private PersonService service;
	@Autowired ModelMapper modelMapper;
	@Bean public ModelMapper modelMapper() { return new ModelMapper(); }

	@RequestMapping("/")
	public String index() {
		Iterable<Person> all = personRepository.findAll();
		StringBuilder sb = new StringBuilder();
		all.forEach(p -> sb.append(p.getName() + " "));
		return sb.toString();
	}

	@PostMapping("/login")
	public HashMap<String, Object> login(@RequestBody Person param) {
		HashMap<String, Object> map = new HashMap<>();
		printer.accept("로그인 진입");
		printer.accept(String.format("USERID: %s", param.getUserid()));
		printer.accept(String.format("PASSWD: %s", param.getPasswd()));
		person = personRepository.findByUseridAndPasswd(param.getUserid(), param.getPasswd());
		if (person != null) {
			printer.accept("로그인 성공");
			map.put("result", "SUCCESS");
			map.put("person", person);
		} else {
			printer.accept("로그인 실패");
			map.put("result", "FAIL");
			map.put("result", person);
		}
		return map;
	}

	@PostMapping("/join")
	public HashMap<String, Object> join(@RequestBody Person param) {
		HashMap<String, Object> map = new HashMap<>();
		printer.accept("가입 진입");
		printer.accept(String.format("USERID: %s", param.getUserid()));
		printer.accept(String.format("PASSWD: %s", param.getPasswd()));
		printer.accept(String.format("PASSWD: %s", param.getName()));
		printer.accept(String.format("PASSWD: %s", param.getBirthday()));
		printer.accept(String.format("PASSWD: %s", param.getHak()));
		printer.accept(String.format("PASSWD: %s", param.getBan()));
		printer.accept(String.format("PASSWD: %s", param.getScore()));
		printer.accept(String.format("PASSWD: %s", param.getRole()));
		personRepository.save(param);
		if (person != null) {
			printer.accept("가입 성공");
			map.put("result", "SUCCESS");
			map.put("person", person);
		} else {
			printer.accept("가입 실패");
			map.put("result", "FAIL");
			map.put("result", person);
		}
		return map;
	}

	@DeleteMapping("/withdrawal")
	public void withdrawal(@PathVariable String userid) {
		personRepository.delete(personRepository.findByUserid(userid));
	}

	@GetMapping("/students")
	public Stream<Person> list(){
		/* Iterable<Person> entites=personRepository.findByRole("student"); */
		Iterable<Person> entites = personRepository.findAll();
		List<Person> list = new ArrayList<>();
		for(Person p:entites) {
			Person dto = modelMapper.map(p,Person.class);
			list.add(dto);
		}
		return list.stream().filter(role-> role.getRole().equals("student"));
	}
	
	@GetMapping("/students/{searchWord}")
	public Stream<Person> findSome(@PathVariable String searchWord){
		printer.accept("넘어온 검색어 : " + searchWord );
		String switchKey = "";
		switch (searchWord) {
		case "namesOfStudents": break;
		case "streamToArray": break;
		case "streamToMap": break;
		case "theNumberOfStudents": break;
		case "totalScore": break;
		case "topStudent": break;
		case "getStat": break;
		case "nameList": break;
		case "topByGrade": break;
		case "남학생" : case "여학생": 
			switchKey = (searchWord == "남") ? "partioningByMale" : "partioningByFemale";
			break;
		case "partioningCountPerGender": break;
		case "partioningTopPerGender": break;
		case "partioningRejectPerGender": break;
		case "groupingByBan": break;
		case "groupingByGrade": break;
		case "groupingByCountByLevel": break;
		case "3학년목록": 
			switchKey = "groupingByHak";
			break;
		case "groupingByHakAndBan": break;
		case "groupingTopByHakAndBan": break;
		case "groupingByStat": break;
		
		}
		switch (switchKey) {
		case "namesOfStudents": break;
		case "streamToArray": break;
		case "streamToMap": break;
		case "theNumberOfStudents": break;
		case "totalScore": break;
		case "topStudent": break;
		case "getStat": break;
		case "nameList": break;
		case "topByGrade": break;
		case "partioningByMale" : 
			List<Person> list = service.partioningByGender(true);
			break;
		case "partioningCountPerGender": break;
		case "partioningTopPerGender": break;
		case "partioningRejectPerGender": break;
		case "groupingByBan": break;
		case "groupingByGrade": break;
		case "groupingByCountByLevel": break;
		case "groupingByHakAndBan": break;
		case "groupingTopByHakAndBan": break;
		case "groupingByStat": break;
		case "groupingByHak": 
			Iterable<Person> entites = personRepository.findAll();
			List<Person> person = new ArrayList<>();
			for(Person p:entites) {
				Person dto = modelMapper.map(p,Person.class);
				person.add(dto);
			}
			return person.stream().filter(role-> role.getRole().equals("student"));
			
		
		}
		return null;
	}
}