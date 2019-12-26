package com.test.web.aricle;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.test.web.person.Person;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

}
