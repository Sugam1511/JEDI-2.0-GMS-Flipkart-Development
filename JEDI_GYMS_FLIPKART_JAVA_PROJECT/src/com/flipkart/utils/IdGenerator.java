/**
 * 
 */
package com.flipkart.utils;

import java.util.HashSet;

/**
 * 
 */
public class IdGenerator {

	static HashSet<Integer> alreadyAlloted = new HashSet<>();

	public static String generateId(String part) {
		String id = "" ;

		while (true) {
			while (id.length() - part.length() < 4) {
				id += (int) Math.ceil((Math.random() + 1) * 10);
			}
			if(!alreadyAlloted.contains(id)) break;
			
		}
		
		return id;
	}

}