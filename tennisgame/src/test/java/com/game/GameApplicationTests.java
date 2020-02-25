package com.game;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.game.service.impl.TennisGame;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class GameApplicationTests {
	@InjectMocks
	TennisGame game;
	public GameApplicationTests(){
		
	}
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAlphaInputParam() {
		game.generateScore("aa ss", "asdas");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAllNegativeParam() {
		game.generateScore("-1", "-1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testoneNegativeParam() {
		game.generateScore("-1", "0");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMaxInputParam() {
		game.generateScore("6", "9");
	}
	
	@Test
	public void test() {
		assertEquals("Love all ",game.generateScore("0", "0"));
	}

}
