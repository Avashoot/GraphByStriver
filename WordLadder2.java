import java.util.*;

public class WordLadder2 {
    public static ArrayList<ArrayList<String>> findSequences(String startWord,String targetWord,String[] wordList) {
        // Code here
        Set<String> st = new HashSet<>();
        for(String s: wordList){
            st.add(s);
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);

        //strore every string on that level used
        ArrayList<String> usedOnlevel = new ArrayList<>();
        usedOnlevel.add(startWord);

        //initial level
        int level =0;

        //answer
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        //alphabet array
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        //iterate a loop
        while (!q.isEmpty()) {
            ArrayList<String> al = q.remove();

            //remove all words that has been used on previous level to transform
            if(al.size() > level){
                level++;
                for(String s: usedOnlevel){
                    st.remove(s);
                }
            }

            String word = al.get(al.size()-1);
            if(word.equals(targetWord)){
                if(ans.size()==0){
                    ans.add(al);
                }
                else if(ans.get(0).size()== al.size()){
                    ans.add(al);
                }
            }

            for(int i = 0; i< word.length(); i++){
                
                for(char a: alphabet){
                    char[] w =word.toCharArray();
                    w[i] = a;
                    String check = new String(w);

                    if(st.contains(check)){
                        al.add(check);
                        //java works on reference 
                        ArrayList<String> temp = new ArrayList<>(al);
                        q.add(temp);
                        //the word is used on the levele
                        usedOnlevel.add(check);
                        al.remove(al.size()-1);
                    }
                }
            }
        }

        return ans;
        
    }


    public static void main(String[] args) {
        String[] wordList = {"poon", "plee", "same", "poie","plea","plie","poin"};
        String startWord = "toon", targetWord = "plea";
        System.out.println(findSequences(startWord, targetWord, wordList));

    }
}
