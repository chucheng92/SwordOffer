package com.nowcoder.offer.problem35;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 字符串中第一个只出现一次的字符位置
 * @author 哓哓
 *
 */
public class FirstNotRepeating {
	/**
	 * LinkedHashMap实现
	 * @param s
	 * @return
	 */
	public Character getFirstNotRepeatingWay1(String s) {
		if (null == s) {
			return null;
		}
		Map<Character, Integer> map = new LinkedHashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		
		for (Character key : map.keySet()) {
			if (map.get(key) == 1) {
				return key;
			}
		}
		
		return null;
	}
	
	/**
	 * 两个数组实现
	 * @param s
	 * @return
	 */
	public Character getFirstNotRepeatingWay2(String s) {
		if (null == s || s.length() <= 0)
			return null;
		if (s.length() < 2)
			return s.charAt(0);
		int[] num = new int[256];
		int[] index = new int[256];
		
		for (int i = 0; i < s.length(); i++) {
			num[s.charAt(i)]++;
			if (index[s.charAt(i)] == 0) {
				index[s.charAt(i)] = i;
			}
		}
		
		int min = 300;
		for (int i = 0; i < 256; i++) {
			if (1 == num[i]) {
				min = (index[i] < min ? index[i] : min);
			}
		}
		if (min != 100)
			return s.charAt(min);
		return null;
	}
}