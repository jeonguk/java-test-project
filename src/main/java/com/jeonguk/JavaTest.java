package com.jeonguk;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class JavaTest {

	public class Info {
		private String a = "1";
	}

	public void aaa() {

		List<Info> list = Arrays.asList(new Info());

		String a = "x";
		System.out.println(a.hashCode());

		a = a+ "0";
		System.out.println(a.hashCode());


		list.forEach(f -> f.a += "0");

		log.info("{}", list.get(0).a);


		List<String> list2 = Arrays.asList("1", "2", "3");

		list2.forEach(f -> f = f + "x");
		list.forEach(f -> f.a += "0");



		log.info("{}", list2.toString());

	}
	public static void main(String[] args) {
		JavaTest javaTest = new JavaTest();
		javaTest.aaa();


	}

}

