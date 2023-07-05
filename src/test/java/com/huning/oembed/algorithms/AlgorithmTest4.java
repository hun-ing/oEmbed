package com.huning.oembed.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class AlgorithmTest4 {

	private static HashMap<String, Integer[]> fruitMap;

	static {
		// 과일 코드 초기화
		fruitMap = new HashMap<>();

		fruitMap.put("kiwi", new Integer[]{1,3,24,26,47,49,68,70,91,93});
		fruitMap.put("pear", new Integer[]{2,21,23,42,44,46,65,67,69,88});
		fruitMap.put("banana", new Integer[]{4,6,25,29,48,50,71,73,92,94,96});
		fruitMap.put("melon", new Integer[]{5,7,28,30,32,51,53,74,76,95,97});
		fruitMap.put("pineapple", new Integer[]{8,10,12,31,33,52,56,75,77,79,98,100});
		fruitMap.put("apple", new Integer[]{9,18,27,36,45,54,63,72,81,90,99});
		fruitMap.put("cucumber", new Integer[]{11,13,34,55,57,59,78,80});
		fruitMap.put("orange", new Integer[]{14,16,35,37,39,58,60,83});
		fruitMap.put("grape", new Integer[]{15,17,19,38,40,61,82,84,86});
		fruitMap.put("cherry", new Integer[]{20,22,41,43,62,64,66,85,87,89});
	}

	@Test
	@DisplayName("")
	void test() throws Exception {
	    // given

	    // when

	    // then
	}
}
