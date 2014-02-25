package entry;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ndrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new FileReader("SampleInput.txt"));
			PrintWriter out;
			out = new PrintWriter(new FileWriter("output.txt"));
			while(s.hasNext()) {
				String word = s.nextLine();
				String[] words = word.split("\\|");
				int i = new Integer(words[1]);
				out.println(word + "|" + solve(i, words[0]));
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int solve(int n, String s) {
		if(s.length() % n != 0) {
			return 0;
		} else {
			String[] tuples = s.split("(?<=\\G.{"+n+"})");
			int i = 0;
			int j = tuples.length;
			int b = 1;
			while(i < j) {
				if(!tuples[i].equals(tuples[j-1])) {
					b = 0;
					j = -1;
				}
				i++;
				j--;
			}

			return b;
		}
	}

}
