package com.huning.oembed.algorithms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class AlgorithmTest1 {

	private String[] sortArray(String[] arr) {
		Set<String> uniqueWords = new HashSet<>(Arrays.asList(arr));
		Map<Integer, List<String>> wordMap = new TreeMap<>();

		for (String word : uniqueWords) {
			int length = word.length();
			List<String> group = wordMap.getOrDefault(length, new ArrayList<>());
			group.add(word);
			wordMap.put(length, group);
		}

		List<String> result = new ArrayList<>();

		for (List<String> group : wordMap.values()) {
			Collections.sort(group);
			result.addAll(group);
		}

		return result.toArray(new String[0]);
	}

	@Test
	@DisplayName("")
	void test() {
		String[] arr = {"stayfolio", "hand", "curation", "tuna", "tuna", "yes", "no", "no", "style", "stash"};
		String[] expected = {"no", "yes", "hand", "tuna", "stash", "style", "curation", "stayfolio"};

		String[] sortedArray = sortArray(arr);

		Assertions.assertThat(sortedArray)
						.isNotNull()
						.hasSameSizeAs(expected)
						.containsExactly(expected);
	}
}
