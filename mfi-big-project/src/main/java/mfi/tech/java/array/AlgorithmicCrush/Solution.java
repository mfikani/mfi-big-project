package mfi.tech.java.array.AlgorithmicCrush;

import static org.assertj.core.api.Assertions.catchThrowable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    private static InputReader in = new InputReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
    	FileInputStream in = null;
        FileOutputStream out = null;

        try {
			try {
			   in = new FileInputStream("t.txt");
			   out = new FileOutputStream("output.txt");
			   
			   int c;
			   while ((c = in.read()) != -1) {
			      out.write(c);
			   }
			}finally {
			   if (in != null) {
			      in.close();
			   }
			   if (out != null) {
			      out.close();
			   }
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        solve();
//        out.close();
    }

    private static void solve() {
        String s = in.readLine().toLowerCase();
        boolean[] was = new boolean[26];
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isLetter(s.charAt(i))) {
                was[s.charAt(i) - 'a'] = true;
            }
        }
        for (int i = 0; i < 26; ++i)
            if (!was[i]) {
                out.print("not ");
                break;
            }
        out.println("pangram");
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}