import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class permutations_and_partitions{

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
        long k = sc.nextLong();

        long [] arr = new long [(int)n];

        for(int i=0; i<(int)n; i++){
            arr[i] = sc.nextLong();
        }

        // to find last k numbers (i.e. to find the greatest k numbers in the array)
        // this works bec arr has all numbers from 1 to n
        int counter = 0;
        long sum = 0;
        for(int i=(int)n; i>=0; i--){
            counter++;
            sum += i;
            if(counter >= k) break;
        }
        // System.out.println(sum);

        long threshold = n-k;
        ArrayList<Integer> ind = new ArrayList<Integer>();

        for(int i=0; i<(int)n; i++){
            if(arr[i]>threshold) ind.add(i);
        }

        long ways = 1;
        for(int i=1; i<ind.size(); i++){
            long diff = ind.get(i) - ind.get(i-1);
            ways = (ways * diff)%998244353;
        }

        System.out.println(sum + " " + ways);

	}
}