package com.codegnan.javadatatimes;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Dates {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		System.out.println(LocalDate.of(2001, 8, 10));
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.of(2001, 8, 10,14,0,0,0, ZoneId.of("America/New_York")));
		System.out.println(Instant.now());
		System.out.println(Duration.between(LocalTime.of(0, 0),LocalTime.now()));
		System.out.println(Period.between(LocalDate.of(2001, 8, 10), LocalDate.now()));
		
		System.out.println(1+2+3*4-1);
	}

}
