import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class sleeping_schedule{

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

    static int n,l,h,r;
    static int [] arr = new int [2005];

	public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();

        Arrays.fill(arr, 0);
		
        n = sc.nextInt();
        h = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        
        // Tabular form
        int [][] dp = new int [n+5][h+5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = 0;
            }
        }

        for(int index = n-1; index>=0; index--){
            for(int time = h; time>=0; time--){

                // option 1
                int t1 =  (time + arr[index])%h;
                int cnt1 = 0;
                if(t1 >= l && t1 <= r) cnt1 = 1;
                int opt1 =  dp[index+1][t1] + cnt1;


                // option 2
                int t2 = (time + arr[index] - 1)%h;
                int cnt2 = 0;
                if(t2 >= l && t2 <= r) cnt2 = 1;
                int opt2 = dp[index+1][t2] + cnt2;   

                dp[index][time] = Math.max(opt1, opt2);
            }
        }



        int ans = dp[0][0];
        System.out.println(ans);


	}

    static int func(int index, int time, int [][] dp){

        if(index == n) return 0;

        if(dp[index][time] != -1) return dp[index][time];

        // option 1
        int t1 = (time + arr[index])%h;
        int cnt1 = 0;
        if(t1 >= l && t1 <= r) cnt1 = 1;
        int opt1 = func(index+1, t1, dp) + cnt1;


        // option 2
        int t2 = (time + arr[index] - 1)%h;
        int cnt2 = 0;
        if(t2 >= l && t2 <= r) cnt2 = 1;
        int opt2 = func(index+1, t2, dp) + cnt2;

        return dp[index][time] = Math.max(opt1, opt2);
    }
}