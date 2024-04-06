package com.mohit.password;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeneratorTest {
	
	private final Password password= new Password("Secret");
	private final Alphabets firstAlphabet = new Alphabets(true,false,false,false);
	private final Alphabets secondAlphabet = new Alphabets(false,true,true,true);
	private final Generator generator = new Generator(true,false,false,false);
//	private final Password generatedPassword = generator.GeneratePassword(4);
	
	@Test
	void test1() {
		assertEquals("Secret", password.toString());
	}

	@Test
	void test2() {
		assertEquals(firstAlphabet.getAlphabet(), Alphabets.UPPERCASE_LETTERS);
	}

	@Test
	void test3() {
		assertEquals(secondAlphabet.getAlphabet(), Alphabets.LOWERCASE_LETTERS + Alphabets.NUMBERS + Alphabets.SYMBOLS);
	}
	
	@Test
	void test4() {
		assertEquals(generator.alphabet.getAlphabet(), Alphabets.UPPERCASE_LETTERS);
	}
	
	@Test
	void test5() {
		assertEquals(generator.alphabet.getAlphabet().length(), 26);
	}

}