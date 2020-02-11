package regex;

import java.util.regex.*;

public class RegularEx2 {
	public static void main(String[] args) {
		String date = "2020-01-17";
		String pattern = "(\\d{4})-(\\d{2})-(\\d{2})";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(date);
		
		//String source = "HP:2020-01-17, HOME:02-999-9999";
		//String pattern = "(\\d{4}-\\d{2}-\\d{2})";
		
		//Pattern p = Pattern.compile(pattern);
		//Matcher m = p.matcher(source);
		
		while(m.find()) {
			System.out.println(m.group(1));
		}
	}
}
