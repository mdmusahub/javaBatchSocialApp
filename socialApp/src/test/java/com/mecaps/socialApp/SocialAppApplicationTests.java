package com.mecaps.socialApp;

import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SocialAppApplicationTests {


	@Test
	void contextLoads() {
	}

	@Disabled
	@Test
	public void simpleTest(){
		assertEquals(5, 2+3);
		assertTrue(5>2);
		assertFalse(0>0);
		assertNotNull(5);

	}


	@ParameterizedTest
	@CsvSource({
			"10,20,30",
			"11,12,10",
			"15,15,30",
			"45,50,20",
			"10,10,20"
	})
	public void parameterTest(int a, int b, int target){
		assertEquals(target, a + b);
	}




}
