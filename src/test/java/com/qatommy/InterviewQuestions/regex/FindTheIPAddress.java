package com.qatommy.InterviewQuestions.regex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindTheIPAddress {

	private static Logger logger = LogManager.getLogger(FindTheIPAddress.class.getSimpleName());

	@Test
	public void testFindIPWithPort() {
		String source = "http://10.0.52.50:5555";

		Pattern p = Pattern.compile("http://(\\p{Digit}+\\.){3}\\p{Digit}+:\\p{Digit}+");
		Matcher m = p.matcher(source);
		if (m.find()) {
			logger.info("Found the node IP for " + source);
		}
		String nodeUrl = m.group(0);
		logger.info(nodeUrl);

	}

	@Test
	public void testFindIPWithOrWithoutPort() {
		String source = "http://10.0.52.50";

		Pattern p = Pattern.compile("http://(\\p{Digit}+\\.){3}\\p{Digit}+(:\\p{Digit})*");
		Matcher m = p.matcher(source);
		if (m.find()) {
			logger.info("Found the node IP for " + source);
		}
		String nodeUrl = m.group(0);
		logger.info(nodeUrl);

	}

	@Test
	public void testFindIPWithoutPort() {
		String source = "http://10.0.52.50:5555";

		Pattern p = Pattern.compile("http://(\\p{Digit}+\\.){3}\\p{Digit}+[\\p{Space}\\p{Punct}]*\\b");
		Matcher m = p.matcher(source);
		if (m.find()) {
			logger.info("Found the node IP for " + source);
		}
		String nodeUrl = m.group(0);
		logger.info(nodeUrl);

	}
}
