package day15;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.sound.sampled.AudioFormat.Encoding;

public class URLTest1 {
	public static void main(String[] args) throws Exception { // throws Exception 家必利 俊矾贸府
		URL url = new URL("https://movie.naver.com/");
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while (true) {
			line = br.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
	}
}
