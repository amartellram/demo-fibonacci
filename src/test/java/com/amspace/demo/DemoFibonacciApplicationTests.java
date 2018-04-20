package com.amspace.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amspace.demo.service.FibonacciService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoFibonacciApplicationTests {
	
	private FibonacciService tested;

	@Before
	public void beforeTest() {
		tested = new FibonacciService();
	}
	
	@Test
	public void test0() {
		int actual = tested.getNthNumber(0);
		assertEquals(0, actual);
	}

	@Test
	public void test1() {
		int actual = tested.getNthNumber(1);
		assertEquals(1, actual);
	}
	
	@Test
	public void test7() {
		int actual = tested.getNthNumber(7);
		assertEquals(13, actual);
	}
}
