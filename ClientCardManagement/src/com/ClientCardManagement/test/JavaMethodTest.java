package com.ClientCardManagement.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class JavaMethodTest {
	// @Test
	public void testListAdd() {
		List a = new ArrayList();
		for (int i = 0; i < 10; i++) {
			a.add(i);
		}
		List b = new ArrayList();
		b.addAll(a);
		assertTrue(b.size() == a.size());
		Iterator iter = b.iterator();
		while (iter.hasNext()) {

			System.out.print(iter.next() + " - ");
		}
		b.addAll(b);
		assertTrue(b.size() == a.size() * 2);
		iter = b.iterator();
		System.out.println();
		while (iter.hasNext()) {

			System.out.print(iter.next() + " - ");
		}
	}

	@Test
	public void testLongEqual() {

		Long a = 10L;
		Long b = 10L;
		assertTrue(a == b);
		//assertTrue(a != b);
		assertTrue(a.equals(b));
	}
}
