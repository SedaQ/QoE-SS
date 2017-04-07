package cz.vutbr.feec.seda.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Pavel Šeda (441048)
 *
 */
public class SortVideoSources {

	public SortVideoSources() {

	}

	public static List<String> sortVideoSources(List<String> sortSources) {
		Collections.sort(sortSources, new Comparator<String>() {
			@Override
			public int compare(String src1, String src2) {
				Pattern p = Pattern.compile("(\\d+).*");
				Matcher m1 = p.matcher(src1);
				Matcher m2 = p.matcher(src2);
				Integer i1 = Integer.MAX_VALUE;
				Integer i2 = Integer.MIN_VALUE;
				if (m1.find())
					i1 = Integer.valueOf(m1.group(1));
				if (m2.find())
					i2 = Integer.valueOf(m2.group(1));
				return i2 - i1;
			}
		});
		return sortSources;
	}

}
