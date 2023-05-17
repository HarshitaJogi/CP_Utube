import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class longest_regular_bracket_sequence{

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
		
        String s = sc.nextLine();

        Stack<Integer> st = new Stack<Integer>();

        int n = s.length();
        int [] dp = new int [n];
        int length = 0;
        int count = 0;

        for(int i=0; i<n; i++){

            char c = s.charAt(i);

            if(c == '('){
                st.push(i);
                continue;
            } 

            if(st.isEmpty()) continue;

            int j = st.peek();
            st.pop();
            int cnt = 0;
            if(j-1 >=0) cnt = dp[j-1];
            dp[i] = i - j + 1 + cnt;

            if(dp[i] > length){
                length = dp[i];
                count = 1;
            }
            else if(dp[i] == length) count++;

        }

        if(length == 0 && count == 0) System.out.println(0 + " " + 1);

        // for(int i: dp) System.out.print(i + " ");
        else System.out.println(length + " " + count);


	}
}