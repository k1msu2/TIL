package regex;

import java.util.regex.*;

public class RegularEx1 {
	public static void main(String[] args) {
		String[] data = {"bat","baby", "bonus", "cA", "ca", "co", "c.","b", 
				"c0","car","ct", "combat", "count", "date", "disc"};
		Pattern p = Pattern.compile("[b|c].{2}");
		
		for(int i =0;i <data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches()) {
				System.out.print(data[i]+", ");
			}
			
		}
	}
}
