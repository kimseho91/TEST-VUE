package com.test.web.proxy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.web.aricle.Article;

@Component("writeArt")
public class ArticleProxy {
	/*
	 * @Autowired ArticleMapper artMapper;
	 * 
	 * @Autowired TxMapper txMapper;
	 */
	@Autowired Article article;
	/* @Autowired CrawlingProxy writeArt; */
	@Autowired Trunk<String> trunk;
	@Autowired Box<String> box;
	
	//MID, BOARDTYPE, TITLE, UPLOADFILE, CONTENT,artseq
	
	public String writerMID() {
		List<String> mids = Arrays.asList("aedn6", "afbw6", "atxd6", "bawz3", "bnlk5", "bzqh0", "ckdk8",
				"cmcb3", "cmkm9", "cnzt2");
		Collections.shuffle(mids);
		String mid = mids.get(0);
		return mid;
	}

	public String title() {
		List<String> titles = Arrays.asList("너무좋아요", "또오고 싶어요", "주변에 알리고 싶어요", "주변에 소개하고 싶어요",
				"다음에 다시 올게요!");
		Collections.shuffle(titles);
		String title = titles.get(0);
		return title;
	}

	private String boardtype() {
		String btype = "게시판";
		return btype;
	}
	
	public String content() {
		List<String> contents = Arrays.asList("우리 꽁이 너무 귀여워요","나래랑 콩이랑 자꾸 싸워요 ㅠㅠ", "우리 강아지가 편식해요", 
				"댕댕이 처음 키워봐여!!","사료 추천해주세요~","너무좋아요", "또오고 싶어요", "여기 살고 싶어요", "주변에 알리고 싶어요");
		Collections.shuffle(contents);
		String content = contents.get(0);
		return content;
	}

	public String artseq() {
		return null;
	}

	public String upLoadFile() {
		return null;
	}
	/*
	 * public Article makeArticle() { return new Article(artseq(), writerMID(),
	 * boardtype(), title(), upLoadFile(), content()); }
	 * 
	 * @Transactional public void insertArticle() { for(int i=0 ; i<50 ; i++) {
	 * txMapper.insertArticle(makeArticle()); } }
	 */
}