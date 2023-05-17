import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class dominant_piranha{

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
		
        int t = sc.nextInt();
        while(t-->0){

            int n = sc.nextInt();
            int [] arr = new int [n];

            int max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
            }

            boolean allsame = true;
            for(int i=1; i<n; i++){
                if(arr[i] != arr[0]){
                    allsame = false;
                    break;
                }
            }

            if(allsame == true) System.out.println(-1);

            else{
                boolean found = false;
                for(int i=0; i<n; i++){
                    if(arr[i] == max){
                        if(i-1>=0 && arr[i-1]<arr[i]){
                            System.out.println(i+1);
                            found = true;
                            break;
                        }

                        else if(i+1<n && arr[i+1]<arr[i]){
                            System.out.println(i+1);
                            found = true;
                            break;
                        }
                    }
                }
                if(found == false) System.out.println(-1);
            }
        }


	}
}