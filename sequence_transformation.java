import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class sequence_transformation{

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
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            if(n==1){
                System.out.println(0);
                continue;
            }

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

            for(int i=0; i<n; i++){

                if(map.containsKey(arr[i])){
                    ArrayList<Integer> l = map.get(arr[i]);
                    l.add(i);
                    map.put(arr[i], l);
                }
                else{
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(i);
                    map.put(arr[i], l);
                }
            }

            // for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()){
            //     ArrayList<Integer> li = new ArrayList<Integer>();
            //     li = entry.getValue();
            //     for(int i: li) System.out.print(i + " ");
            //     System.out.println();
            // }


            int ans = Integer.MAX_VALUE;
            for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()){
                ArrayList<Integer> li = new ArrayList<Integer>();
                li = entry.getValue();
                
                if(li.size()==1){
                    if(li.get(0) == 0 || li.get(0) == n-1) ans = Math.min(ans, 1);
                    else{
                        ans = Math.min(ans, 2);
                    }
                }


                else{
                    int ok = 0;
                    for(int i=0; i<li.size(); i++){

                        if(i==0){
                            if(li.get(i) >=1 ) ok++;
                            continue;
                        }

                        if( i == li.size()-1){
                            if(li.get(i) < n-1) ok++;
                        }

                        if(li.get(i) - li.get(i-1) > 1) ok++;


                    }

                    ans = Math.min(ans, ok);
                }
                
            }

            System.out.println(ans);


        }


	}
}









