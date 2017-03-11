package com.seda.qoe.comparator;

import java.util.Comparator;

/**
 * @author Pavel Šeda (441048)
 *
 */
public class StringComparator implements Comparator<String> {
	@Override
	public int compare(String a, String b) {
		return a.compareTo(b);
	}

}
