import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bad_luck_island{

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

    static int N = 110;
    static double [][][] dp1 = new double [N][N][N];
    static double [][][] dp2 = new double [N][N][N];
    static double [][][] dp3 = new double [N][N][N];

	public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();

        
        // our state contains r, s, p which are the number of rocks, papers and scissors at the end respectively.


        // Case 1: A rock and a scissor meet => new state: (r, s-1, p)


        // Case 2: A scissor and paper meet => new state: (r, s, p-1)


        // Case 3: A paper and rock meet => new state: (r-1, s, p)


        // dp1(r, s, p) = prob that r rocks are left at end
        // dp2(r, s, p) = prob that s scissors are left at the end
        // dp3(r, s, p) = prob that p papers are left at the end

        // Base cases:

        // Part 1:
        // dp1(0, s, p) = 0 bec no rocks left at end
        // same for rest

        // Part 2:
        // dp1(r, 0, 0) = 1 bec only rocks left at end
        // same for rest

        // Denominator = Total number of interactions = r*s + s*p + p*r (bec rock and sciccor can meet in r*s ways and so on)


        // dp1 or dp2 or dp3:
        // (r*s)/denominator = prob that rock meets scissor and goes to state (r, s-1, p)
        // (s*p)/denominator = prob that paper meets scissor and goes to state (r, s, p-1)
        // (r*p)/denominator = prob that rock meets paper and goes to state (r-1, s, p)


        // only base cases differ for dp1,dp2,dp3. Transitions remain same



        double r = sc.nextDouble();
        double s = sc.nextDouble();
        double p = sc.nextDouble();

        for(int i=0; i<dp1.length; i++){
            for(int j=0; j<dp1[0].length; j++){
                for(int k=0; k<dp1[0][0].length; k++){
                    dp1[i][j][k] = -1;
                }
            }
        }

        for(int i=0; i<dp2.length; i++){
            for(int j=0; j<dp2[0].length; j++){
                for(int k=0; k<dp2[0][0].length; k++){
                    dp2[i][j][k] = -1;
                }
            }
        }

        for(int i=0; i<dp3.length; i++){
            for(int j=0; j<dp3[0].length; j++){
                for(int k=0; k<dp3[0][0].length; k++){
                    dp3[i][j][k] = -1;
                }
            }
        }

        double rock = solve1(r, s, p);
        double rock_final = Math.round(rock * 1000000000) / 1000000000.0;
        double scissor = solve2(r, s, p);
        double scissor_final = Math.round(scissor * 1000000000) / 1000000000.0;
        double paper = solve3(r, s, p);
        double paper_final = Math.round(paper * 1000000000) / 1000000000.0;

        System.out.println(rock_final + " " + scissor_final + " " + paper_final);

	}

    // prob that rock is left
    static double solve1 (double r, double s, double p){

        // Base cases

        if(r==0) return dp1[(int)r][(int)s][(int)p] = 0; //part 1

        if(r>0 && s==0 && p==0) return dp1[(int)r][(int)s][(int)p] = 1; // part 2

        if(dp1[(int)r][(int)s][(int)p] != -1) return dp1[(int)r][(int)s][(int)p];

        double all = (r*s) + (s*p) + (r*p);

        double ans = 0;

        if(s>0 && r>0) ans += ((r*s)/all)*solve1(r, s-1, p);  // prob of r and s meeting * prob of rock winning
        if(p>0 && s>0) ans += ((s*p)/all)*solve1(r, s, p-1);  // prob of s and p meeting * prob of rock winning
        if(r>0 && p>0) ans += ((r*p)/all)*solve1(r-1, s, p);  // prob of r and p meeting * prob of rock winning

        return dp1[(int)r][(int)s][(int)p] = ans;
    }

    // prob that scissor is left
    static double solve2 (double r, double s, double p){

        // Base cases

        if(s==0) return dp2[(int)r][(int)s][(int)p] = 0; //part 1

        if(r==0 && s>0 && p==0) return dp2[(int)r][(int)s][(int)p] = 1; // part 2

        if(dp2[(int)r][(int)s][(int)p] != -1) return dp2[(int)r][(int)s][(int)p];

        double all = (r*s) + (s*p) + (r*p);

        double ans = 0;

        if(s>0 && r>0) ans += ((r*s)/all)*solve2(r, s-1, p);  // prob of r and s meeting * prob of rock winning
        if(p>0 && s>0) ans += ((s*p)/all)*solve2(r, s, p-1);  // prob of s and p meeting * prob of rock winning
        if(r>0 && p>0) ans += ((r*p)/all)*solve2(r-1, s, p);  // prob of r and p meeting * prob of rock winning

        return dp2[(int)r][(int)s][(int)p] = ans;
    }


    // prob that paper is left
    static double solve3 (double r, double s, double p){

        // Base cases

        if(p==0) return dp3[(int)r][(int)s][(int)p] = 0; //part 1

        if(r==0 && s==0 && p>0) return dp3[(int)r][(int)s][(int)p] = 1; // part 2

        if(dp3[(int)r][(int)s][(int)p] != -1) return dp3[(int)r][(int)s][(int)p];

        double all = (r*s) + (s*p) + (r*p);

        double ans = 0;

        if(s>0 && r>0) ans += ((r*s)/all)*solve3(r, s-1, p);  // prob of r and s meeting * prob of rock winning
        if(p>0 && s>0) ans += ((s*p)/all)*solve3(r, s, p-1);  // prob of s and p meeting * prob of rock winning
        if(r>0 && p>0) ans += ((r*p)/all)*solve3(r-1, s, p);  // prob of r and p meeting * prob of rock winning

        return dp3[(int)r][(int)s][(int)p] = ans;
    }
}