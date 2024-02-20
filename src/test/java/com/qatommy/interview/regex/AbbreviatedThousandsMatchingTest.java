package com.qatommy.interview.regex;

import java.time.Instant;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class AbbreviatedThousandsMatchingTest {

	public static final Logger logger = LogManager.getLogger(AbbreviatedThousandsMatchingTest.class.getSimpleName());

	@Test
	public void readNumberFromString() {
		int bound = 99;
		Random r = new Random(Instant.now().getEpochSecond());
		final String outFormat = "%.0f";
		final String inFormat = "%.1f";
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(r.nextInt(bound) + "k")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(r.nextInt(bound) + "K")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(r.nextInt(bound) + "m")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(r.nextInt(bound) + "M")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(String.format(inFormat, bound * r.nextDouble()) + "k")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(String.format(inFormat, bound * r.nextDouble()) + "K")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(String.format(inFormat, bound * r.nextDouble()) + "m")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(String.format(inFormat, bound * r.nextDouble()) + "M")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(-1 * r.nextInt(bound) + "k")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(-1 * r.nextInt(bound) + "K")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(-1 * r.nextInt(bound) + "m")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(-1 * r.nextInt(bound) + "M")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(String.format(inFormat, -1 * bound * r.nextDouble()) + "k")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(String.format(inFormat, -1 * bound * r.nextDouble()) + "K")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(String.format(inFormat, -1 * bound * r.nextDouble()) + "m")));
		logger.info(String.format(outFormat, AbbreviatedThousandsMatching.readNumberFromString(String.format(inFormat, -1 * bound * r.nextDouble()) + "M")));
	}
}