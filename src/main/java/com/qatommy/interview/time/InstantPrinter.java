package com.qatommy.interview.time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.Temporal;

public class InstantPrinter {

	public static void main(String[] args) {
		System.out.println(Instant.now());
		System.out.println(Instant.now().toEpochMilli());

		Duration timeout = Duration.ofMinutes(5);
		Instant end = Instant.now().plus(timeout);
		System.out.println(end);
		System.out.println(Instant.now().isAfter(end));
	}
}
