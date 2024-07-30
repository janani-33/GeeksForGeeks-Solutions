//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    long len=-1;
    public long largesSumCycle(int N, int Edge[]){
        boolean visited[]=new boolean[N];
        boolean st[]=new boolean[N];
        for(int i=0;i<N;i++)
        cyclic(i,Edge,visited,st,new ArrayList<Integer>());
        return len;
    }
    void cyclic(int i,int edge[],boolean[] visited,boolean[] st,ArrayList<Integer> l){
        if(i==-1)
        return;
        if(st[i]){
            int p=l.indexOf(i);
            if(p!=-1){
                int sum=0;
                for(int c=p;c<l.size();c++)
                sum+=l.get(c);
                if(sum>len)
                len=sum;
            }
            return;
        }
        if(visited[i])
        return;
        visited[i]=true;
        st[i]=true;
        l.add(i);
        cyclic(edge[i],edge,visited,st,l);
        st[i]=false;
        l.remove(l.size()-1);
        return;
    }
}