package com.huning.oembed.algorithms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlgorithmTest3 {

	@Test
	@DisplayName("피보나치 수열을 이용한 풀이")
	void test1() {
		ClimbingStairs climbingStairs = new ClimbingStairs();

		int n1 = 2;
		int expected1 = 2;
		int result1 = climbingStairs.climbStairs(n1);
		Assertions.assertThat(result1).isEqualTo(expected1);

		int n2 = 3;
		int expected2 = 3;
		int result2 = climbingStairs.climbStairs(n2);
		Assertions.assertThat(result2).isEqualTo(expected2);

		int n3 = 4;
		int expected3 = 5;
		int result3 = climbingStairs.climbStairs(n3);
		Assertions.assertThat(result3).isEqualTo(expected3);

		int n4 = 5;
		int expected4 = 8;
		int result4 = climbingStairs.climbStairs(n4);
		Assertions.assertThat(result4).isEqualTo(expected4);

		int n5 = 6;
		int expected5 = 13;
		int result5 = climbingStairs.climbStairs(n5);
		Assertions.assertThat(result5).isEqualTo(expected5);

		int n6 = 7;
		int expected6 = 21;
		int result6 = climbingStairs.climbStairs(n6);
		Assertions.assertThat(result6).isEqualTo(expected6);

		int n7 = 8;
		int expected7 = 34;
		int result7 = climbingStairs.climbStairs(n7);
		Assertions.assertThat(result7).isEqualTo(expected7);

		int n8 = 9;
		int expected8 = 55;
		int result8 = climbingStairs.climbStairs(n8);
		Assertions.assertThat(result8).isEqualTo(expected8);
	}

	static private class ClimbingStairs {
		public int climbStairs(int n) {
			if (n <= 2) {
				return n;
			}

			int prev1 = 1;
			int prev2 = 2;
			int current = 0;

			for (int i = 3; i <= n; i++) {
				current = prev1 + prev2;
				prev1 = prev2;
				prev2 = current;
			}

			return current;
		}
	}
}
