package com.qatommy.interview.regex;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbbreviatedThousandsMatching {

	public static final Logger logger = LogManager.getLogger(AbbreviatedThousandsMatching.class.getSimpleName());

	public static Double readNumberFromString(String str) {
		logger.info("ReadNumberFromString:  " + str);
		final String input = str.toLowerCase(Locale.getDefault());
		logger.info("toLowerCase:  " + input);
		Pattern p = Pattern.compile("([\\-0-9.]+)([km]$)");
		Matcher m = p.matcher(input);
		Double result = 0.0;
		if (m.find()) {
			logger.info("Group Count:  " + m.groupCount());
			result = Double.valueOf(m.group(1));
			switch (m.group(2)) {
				case "k":
					result *= 1_000;
					break;
				case "m":
					result *= 1_000_000;
					break;
			}
		}
		return result;
	}

}
