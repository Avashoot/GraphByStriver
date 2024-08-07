import java.util.*;

public class WordLadder1 {
    static class Pair {
        String ele;
        int d;

        Pair(String ele, int d) {
            this.ele = ele;
            this.d = d;
        }
    }

    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        // Code here
        int l = startWord.length();
        // System.out.println(l);
        Set<String> s = new HashSet<>();
        for (String str : wordList) {
            s.add(str);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));
        if (s.contains(startWord))
            s.remove(startWord);

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int len = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            String word = p.ele;
            
            int d = p.d;
            for (int i = 0; i < l; i++) {
                char[] w = word.toCharArray();
                for (char c : alphabet) {
                    w[i] = c;
                    String check = new String(w);
                    
                    if (s.contains(check)) {
                        q.add(new Pair(check, d + 1));
                        s.remove(check);
                        // System.out.println(q.size());

                        if (check.equals(targetWord)) {

                            len = d + 1;
                        }
                    }
                }
            }
        }

        return len;

    }

    public static void main(String[] args) {
        String[] wordList = {"poon", "plee", "same", "poie","plea","plie","poin"};
        String startWord = "toon", targetWord = "plea";
        System.out.println(wordLadderLength(startWord, targetWord, wordList));

    }
}
