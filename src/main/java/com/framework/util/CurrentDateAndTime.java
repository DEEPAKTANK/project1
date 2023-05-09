package com.framework.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateAndTime {
	public String getDateNTime() {
		 // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        
        // Format the date and time as a string using a DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");
        String formattedDateTime = now.format(formatter);
        
        // Print the formatted date and time to the console
       return  formattedDateTime;
	}

	public static void main(String[] args) {
		CurrentDateAndTime d=new CurrentDateAndTime();
		System.out.println(d.getDateNTime());
	}
}
