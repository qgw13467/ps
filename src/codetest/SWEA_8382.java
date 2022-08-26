package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8382 {
	static int t;
	static StringTokenizer stringTokenizer;

	static int startx, starty, targetx, targety;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(bufferedReader.readLine());

		for (int tc = 1; tc <= t; tc++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			startx = Integer.parseInt(stringTokenizer.nextToken());
			starty = Integer.parseInt(stringTokenizer.nextToken());
			targetx = Integer.parseInt(stringTokenizer.nextToken());
			targety = Integer.parseInt(stringTokenizer.nextToken());
			
			
			
		}
	}
}
