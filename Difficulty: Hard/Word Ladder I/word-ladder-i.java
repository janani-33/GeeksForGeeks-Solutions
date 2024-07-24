//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Set<String> words=new HashSet<>(Arrays.asList(wordList));
        if(startWord.equals(targetWord) || !words.contains(targetWord))
        return 0;
        Queue<String> q=new LinkedList<>();
        q.add(startWord);
        words.remove(startWord);
        int c=1,n=startWord.length();
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                String str=q.remove();
                if(str.equals(targetWord))
                return c;
                for(int j=0;j<n;j++){
                    for(char ch='a';ch<='z';ch++){
                        String nstr=str.substring(0,j)+ch+str.substring(j+1,n);
                        if(words.contains(nstr)){
                            q.add(nstr);
                            words.remove(nstr);
                        }
                    }
                }
            }
            c++;
        }
        return 0;
    }
}