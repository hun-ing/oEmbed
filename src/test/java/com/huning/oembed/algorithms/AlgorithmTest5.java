package com.huning.oembed.algorithms;

import groovy.util.logging.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class AlgorithmTest5 {

	private int findUniqueIndex(int[] arr) {
		int evenCount = 0;
		int oddCount = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}

			if ((evenCount > 1 && oddCount == 1) || (oddCount > 1 && evenCount == 1)) {
				return i;
			}
		}

		return -1;
	}

	@Test
	@DisplayName("")
	void test() {
		// 짝수나 홀수 둘 중 하나가 1개만 들어있는 랜덤 숫자 배열 생성
		int[] randomArray = createRandomArray(10, 1, 100);

		// 만들어진 랜덤 배열에 짝수나 홀수가 1개만 들어있는지 검증
		int evenCount = 0;
		int oddCount = 0;
		for (int i = 0; i < randomArray.length; i++) {
			if (randomArray[i] % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
		}

		assertThat((evenCount == 1 && oddCount > 1) || (oddCount == 1 && evenCount > 1)).isTrue();

		// 짝수나 홀수 중에서 1개만 들어있는 값의 인덱스 찾기
		int uniqueIndex = findUniqueIndex(randomArray);

		String arrayString = Arrays.toString(randomArray);
		System.out.println("randomArray = " + arrayString);
		System.out.println("uniqueIndex = " + uniqueIndex);
	}

	private int[] createRandomArray(int length, int min, int max) {
		Integer[] randomArray = new Integer[length];
		Random random = new Random();

		randomArray[0] = random.nextInt(max - min + 1) + min;

		for (int i = 1; i < length; i++) {
			if (randomArray[0] % 2 == 0) {
				randomArray[i] = generateOddNumber(min, max, random);
			} else {
				randomArray[i] = generateEvenNumber(min, max, random);
			}
		}

		List<Integer> list = Arrays.asList(randomArray);
		Collections.shuffle(list);

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	private int generateEvenNumber(int min, int max, Random random) {
		int evenNumber = random.nextInt((max - min) / 2 + 1) * 2 + min;

		if (evenNumber % 2 != 0) {
			evenNumber++;
		}

		return evenNumber;
	}

	private int generateOddNumber(int min, int max, Random random) {
		int oddNumber = random.nextInt((max - min) / 2) * 2 + min + 1;

		if (oddNumber % 2 == 0) {
			oddNumber++;
		}

		return oddNumber;
	}
}
