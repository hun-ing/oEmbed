package com.huning.oembed.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class AlgorithmTest2 {

	private boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				char top = stack.pop();
				if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	@Test
	@DisplayName("")
	void test() throws Exception {
		String s1 = "()";
		assertThat(isValid(s1)).isTrue();

		String s2 = "()[]{}";
		assertThat(isValid(s2)).isTrue();

		String s3 = "(]";
		assertThat(isValid(s3)).isFalse();

		String s4 = "(({)})";
		assertThat(isValid(s4)).isFalse();

		String s5 = "(({}))";
		assertThat(isValid(s5)).isTrue();

		String s6 = "([{}])";
		assertThat(isValid(s6)).isTrue();
	}
}
