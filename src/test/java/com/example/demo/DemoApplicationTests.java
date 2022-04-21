package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@SpringBootTest
class DemoApplicationTests {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testAppConstructor() {
		try {
			new App();
		} catch (Exception e) {
			fail("Construction failed.");
		}
	}

	@Test
	public void testAppMain()
	{

		try {
			assertEquals("Hello World!", App.getMessage());
		} catch (AssertionError e) {
			System.out.println("expected: "+"Hello World!" + System.getProperty("line.separator"));
			System.out.println("Actual: "+App.getMessage());
			fail("\"message\" is not \"Hello World!\"");
		}
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

}
