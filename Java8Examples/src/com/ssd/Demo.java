package com.ssd;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

	public static void main(String[] args) {

		int i = 5;
		int j = 20;

		Area ar = (int x) -> x * x;

		int squareArea = ar.area(j);

		System.out.println("squareArea.." + squareArea);

		CalcInterface add = (int a, int b) -> a + b;

		System.out.println("addition = " + add.calculate(i, j));

		CalcInterface mul = (int a, int b) -> a * b;
		System.out.println("multiplication = " + mul.calculate(i, j));

		List<String> fruitList = Arrays.asList("apple", "a", "b", "g", "b", "a", "grapes", "guava", "p", "o", "o");

		Map<String, Long> fruitCount = fruitList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println("fruitCount..." + fruitCount);

		List<String> aList = fruitList.stream().filter(p -> p.startsWith("a")).collect(Collectors.toList());

		System.out.println("a list...." + aList);

		List<String> gList =fruitList.stream().filter(p -> p.startsWith("g")).map(p->p.toUpperCase()).collect(Collectors.toList());

		
		
		System.out.println("gList... "+gList);
	}

}
