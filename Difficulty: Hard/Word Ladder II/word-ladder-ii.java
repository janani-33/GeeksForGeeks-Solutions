//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b) {
        String x = "";
        String y = "";
        for (int i = 0; i < a.size(); i++) x += a.get(i);
        for (int i = 0; i < b.size(); i++) y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for (int i = 0; i < n; i++) {
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans =
                obj.findSequences(startWord, targetWord, wordList);
            if (ans.size() == 0)
                System.out.println(-1);
            else {
                Collections.sort(ans, new comp());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ans.size(); i++) {
                    for (int j = 0; j < ans.get(i).size(); j++) {
                        sb.append(ans.get(i).get(j) + " ");
                    }
                    if (i != ans.size() - 1) sb.append("\n");
                }
                System.out.println(sb);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    HashMap<String,Integer> map=new HashMap<>();
    ArrayList<ArrayList<String>> res=new ArrayList<>();
    public void checkseq(String st,String word,ArrayList<String> seq){
        if(word.equals(st)){
            ArrayList<String> temp=new ArrayList<>(seq);
            Collections.reverse(temp);
            res.add(temp);
            return;
        }
        int steps=map.get(word);
        int s=word.length();
        for(int i=0;i<s;i++){
            for(char ch='a';ch<='z';ch++){
                String ns=word.substring(0,i)+ch+word.substring(i+1,s);
                if(map.containsKey(ns) && map.get(ns)+1==steps){
                    seq.add(ns);
                    checkseq(st,ns,seq);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        Set<String> set=new HashSet(Arrays.asList(wordList));
        if(!set.contains(targetWord))
        return res;
        Queue<String> q=new LinkedList<>();
        q.add(startWord);
        map.put(startWord,1);
        set.remove(startWord);
        int s=startWord.length();
        while(!q.isEmpty()){
            String word=q.remove();
            int steps=map.get(word);
            if(word.equals(targetWord))
            break;
            for(int i=0;i<s;i++){
                for(char ch='a';ch<='z';ch++){
                    String ns=word.substring(0,i)+ch+word.substring(i+1,s);
                    if(set.contains(ns)){
                        q.add(ns);
                        set.remove(ns);
                        map.put(ns,steps+1);
                    }
                }
            }
        }
        ArrayList<String> seq=new ArrayList<>();
        seq.add(targetWord);
        if(map.containsKey(targetWord))
        checkseq(startWord,targetWord,seq);
        return res;
    }
}