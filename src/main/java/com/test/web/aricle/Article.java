package com.test.web.aricle;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Entity
@Component
@Table(name="ARTICLE")
public class Article {
	@Id
	@GeneratedValue
	@Column(name="ID", nullable=false) 
	private Long id;
	@Column(name="USERID",length = 64, nullable=false) 
	private String userid;
	@Column(name="COMMENTS",length = 64, nullable=false) 
	private String comments;
	@Column(name="TITLE",length = 64, nullable=false) 
	private String title;
	@Column(name="CONTENTS",length = 64, nullable=false) 
	private String content;
	@Column(name="IMG",length = 64, nullable=false) 
	private String img;
	@Column(name="BOARDTYPE",length = 64, nullable=false) 
	private String boardtype;
	@Column(name="RATING",length = 64, nullable=false) 
	private String rating;
	@Temporal(TemporalType.DATE)
	@Column(name="REGDATE", nullable=false) 
	private Date regdate;
}
