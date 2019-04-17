package com.better.piglatin;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.better.piglatin.controller.TranslatorController;
import com.better.piglatin.service.TranslatorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PiglatinApplicationTests {

	private TranslatorService translator;
	private TranslatorController controller;
	@Before
	public void init() {
		translator=new TranslatorService();	
		controller=new TranslatorController();
	}
	
	@Test
	public void validStringCheck()  {
		
		String answer=translator.translate("Hello, my name is Alice.");
		assertEquals("Ellohay, ymay amenay isay Aliceay.",answer);	
		
	}
	
	@Test
	public void nullStringCheck()  {
		
		String answer=controller.translateReqHandler(null);
		
		assertEquals("No input",answer);	
		
	}
	
	@Test
	public void nullWordCheck()  {
		
		String answer=translator.wordTranslate(null);
		
		assertEquals("",answer);	
		
	}
	
	@Test
	public void validWordCheckForYstart()  {
		
		String answer=translator.wordTranslate("yellow");
		
		assertEquals("ellowyay",answer);	
		
	}
	
	@Test
	public void validWordCheckForYnotStart()  {
		
		String answer=translator.wordTranslate("my");
		
		assertEquals("ymay",answer);	
		
	}
	
	@Test
	public void onlyPunctuationsCheck()  {
		
		String answer=translator.translate("........!!");
		
		assertEquals("........!!",answer);	
		
	}


}
