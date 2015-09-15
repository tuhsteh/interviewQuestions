package com.qatommy.InterviewQuestions.regex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class CurrencyMatchingTests {
	private static Logger logger = LogManager.getLogger(CurrencyMatchingTests.class.getSimpleName());

	/**
	 * Can we match the currency symbol at the beginning of a string?
	 * e.g. $4.99
	 */
	@Test
	public void matchCurrencyBeginningCurrencySymbol() {
		final String pattern = "\\p{Digit}*[\\.,]*\\p{Digit}+[\\.,]*\\p{Digit}*";
		Pattern p = Pattern.compile(pattern);
		for (String s : valueGroups) {
			Matcher m = p.matcher(s);
			assertTrue("Failed to find a match.", m.find());
			logger.info(String.format("\n\tInput:\t%s\n\tOutput:\t%s", s, m.group(0)));
		}
	}

	private static final List<String> valueGroups = new ArrayList<String>() {{
		add("$4.99");
		add(" $4.99");
		add("$54.99");
		add("$594.99");
		add("$594.99");
		add("$4");
		add("$4,99");
		add("¥4,00");
		add("$$$$4");
		add("CAD$4.00");
		add("¥4.000,00");
	}};
}
