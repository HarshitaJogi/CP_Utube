import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class consecutive_subsequence{

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
        int [] arr = new int [n];
        // ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        // int [][] dp = new int [n+5][n+5];
        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[0].length; j++){
        //         dp[i][j] = -1;
        //     }
        // }


       

        // TABULER

        
        int [] dp = new int [n+5];
        Arrays.fill(dp, 1);
        int [] hash = new int [n+5];
        Arrays.fill(hash, -1);

        for(int index = 0; index<n; index++){
            for(int prev_index=0; prev_index<=index; prev_index++){
                if((arr[index] == arr[prev_index]+1) && dp[index] < dp[prev_index] + 1){
                    dp[index] = dp[prev_index] + 1;
                    hash [index] = prev_index;
                }
            }  
        }

        int maxi = dp[0];
        int max_index = 0;
        for(int i=1; i<n; i++){
            if(dp[i]>dp[i-1]){
                maxi = dp[i];
                max_index = i;
            }
        } 

        ArrayList<Integer> ans = new ArrayList<Integer>();
        int prev_ind = max_index;

        while(prev_ind != -1){
            ans.add(prev_ind + 1);
            prev_ind = hash[prev_ind];
        }

        Collections.reverse(ans);

        
        System.out.println(maxi);
        for(int i: ans){
            System.out.print(i + " ");
        }
        System.out.println();
        // System.out.println(maxi + " " + max_index);


	}

    // static int lis(int index, int [] arr, int prev_index, int [][] dp){

    //     if(index < 0) return 0;

    //     if(dp[index][prev_index+1] != -1) return dp[index][prev_index+1];

    //     int nottake = lis(index-1, arr, prev_index, dp);

    //     int take = 0;
    //     if(prev_index == -1 || (arr[prev_index]==(arr[index]+1))){
    //         take = lis(index-1, arr, index, dp)+1;
    //     }

    //     return dp[index][prev_index+1] = Math.max(take,nottake);

    // }
}