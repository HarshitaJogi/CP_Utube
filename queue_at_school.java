import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class queue_at_school{

	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
  
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
  
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
  
        int nextInt() { return Integer.parseInt(next()); }
  
        long nextLong() { return Long.parseLong(next()); }
  
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
  
        String nextLine()
        {
            String str = " ";
            StringTokenizer st = new StringTokenizer(str);
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

	public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        int n = sc.nextInt();

        int t = sc.nextInt();

        String s = sc.nextLine();

        for(int i=1; i<=t; i++){
            for(int j=1; j<n; j++){
                if(s.charAt(j-1)=='B' && s.charAt(j)=='G'){
                    // s.charAt(j-1) = 'G';
                    s = s.substring(0, j-1) + 'G' + s.substring(j-1 + 1);
                    // s.charAt(j) = 'B';
                    s = s.substring(0, j) + 'B' + s.substring(j + 1);
                    j++;
                }
                
            }
        }

        System.out.println(s);


	}
}