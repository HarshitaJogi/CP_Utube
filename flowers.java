import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class flowers{

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
    
    static int N = (int)1E6;
    static int M = (int)1000000007;
    static int [] dp = new int [N+5];
    static int [] prefix = new int [N+5];

	public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();

		
        int t = sc.nextInt();
        int k = sc.nextInt();

        Arrays.fill(dp, -1);
        Arrays.fill(prefix, 0);

        // for(int i=0; i<k; i++) dp[i] = 1;
        // dp[k] = 2;

        // func(10, k);


        // TABULAR FORM

        // base case
        dp[0] = 1;

        for(int ind = 1; ind <=N; ind++){
            // case 1: dont take white (red fixed as last)
            int donttake =  dp[ind-1];  

            // case 2: take white (last k places filled with white)
            int take = 0;
            if(ind - k >= 0){
                take =  dp[ind-k];  
            }

            dp[ind] = (take + donttake)%M;
        }




        prefix[0] = 0;
        prefix[1] = dp[1];
        for(int i=2; i<prefix.length; i++){
            prefix[i] = (prefix[i-1] + dp[i])%M;
        }

        while(t-->0){
            

            int a = sc.nextInt();
            int b = sc.nextInt();

            
            int ans = 0;

            ans = (prefix[b] - prefix[a-1])%M;

            if(ans < 0) ans += M;

            System.out.println(ans);

            
        }

	}

    // static int func(int ind, int k){

    //     if(ind == 0) return 1;

    //     if(dp[ind] != -1) return dp[ind];

    //     // case 1: dont take white (red fixed as last)
    //     int donttake = func(ind-1, k);

    //     // case 2: take white (last k places filled with white)
    //     int take = 0;
    //     if(ind - k >= 0){
    //         take = func(ind-k, k);
    //     }

    //     return dp[ind] = take + donttake;
        
    // }
}