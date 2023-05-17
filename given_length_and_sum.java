import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class given_length_and_sum{

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

    static char [] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static String min_ans = "";
    static String max_ans = "";

	public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        int m = sc.nextInt();
        int s = sc.nextInt();

        if(s==0){
            if(m==1){
                System.out.println("0 " + "0");
            }
            else{
                System.out.println("-1 " + "-1");
            }
        }


        else{

            String maxi = "";
            String mini = "";

            for(int i=0; i<m; i++){
                int k = Math.min(9, s);
                String k1 = Integer.toString(k);
                maxi += k1;
                s -= k;
            }

            // even after filling all places with 9, still sum is not zero then it is not possible
            if(s>0){
                System.out.println("-1 " + "-1");
            }


            else{

                // reverse maxi to get mini
                for(int i=maxi.length()-1; i>=0; i--){

                    String st = Character.toString(maxi.charAt(i));
                    mini += st;
                }


                // to handle leading zeroes
                int j = 0;
                while(mini.charAt(j)=='0') j++;

                if(j>0){
                    char c = mini.charAt(j);
                    c--;
                    // System.out.println(c);
                    mini = '1' + mini.substring(1, j) + c + mini.substring(j+1, mini.length());
                }



                System.out.println(mini + " " + maxi);

            }
            

        }
        

        



      
        // String curr = "";
        // func(m, s, 0, curr);

        
        // int small = Integer.parseInt(min_ans);
        // int big = Integer.parseInt(max_ans);


        // System.out.println(small + " " + big);

        // if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE){
        //     min = -1;
        //     max = -1;
        // } 

        // System.out.println(min + " " + max);


	}

    // static void func(int m, int s, int index, String curr){


    //     if(index == m){
    //         // convert string curr to integer
    //         if(curr.length()>0){

    //             int sum = 0;
    //             for(int i=0; i<curr.length(); i++){
    //                 // String st = Character.toString(curr.charAt(i));
    //                 char c = curr.charAt(i);
    //                 int num = c - '0';
    //                 sum += num;
    //             }
    //             // System.out.println(curr);

    //             if(sum == s){
    //                 int num = Integer.parseInt(curr);
    //                 min = Math.min(min, num);
    //                 max = Math.max(max, num);
    //             } 
    //         }
    //         return;


    //     }

    //     for(int i=0; i<nums.length; i++){
    //         if(index == 0 && nums[i]=='0') continue;
    //         curr += nums[i];
    //         func(m, s, index+1, curr);
    //         curr = curr.substring(0, curr.length()-1);
    //     }

    // }
}












