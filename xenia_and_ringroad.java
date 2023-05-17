import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class xenia_and_ringroad{

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
		
        long n = sc.nextLong();
        long m = sc.nextLong();

        long [] arr = new long [(int)m];

        for(int i=0; i<m; i++){
            arr[i] = sc.nextLong();
        }

        long ans = arr[0];
        long last_vis = arr[0];

        for(int i=1; i<m; i++){
            // System.out.println("ans: " + ans);
            if(arr[i] >= last_vis){
                ans += arr[i] - last_vis;
                last_vis = arr[i];
            }
            // go to n and come back clockwise
            else{
                ans += n - last_vis;
                ans += arr[i];
                last_vis = arr[i];
            }
        }

        System.out.println(ans - 1); 


	}
}