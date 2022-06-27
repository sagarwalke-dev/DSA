package com.dsa;

import java.util.Stack;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;

public class ValidParentheses {
	
	final static Logger log = Logger.getLogger(SampleDSA.class);

	public static boolean isValid(String s) {
		log.info("calling isValid");
		if (s.length() % 2 != 0)
			return false;
		log.info("Validating string : {}", s);
		Stack<Character> stack = new Stack();
		for (char c : s.toCharArray()) {
			if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}

	
	public static void main(String[] args) {
		String str = "([])";
		log.info("The String " + str " is {}" , isValid(str));
	}
}
