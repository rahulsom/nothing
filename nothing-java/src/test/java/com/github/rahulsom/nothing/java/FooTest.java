package com.github.rahulsom.nothing.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FooTest {
	@Test
	void testSum() {
		assertEquals(3, new Foo().sum(1, 2));
	}
}
