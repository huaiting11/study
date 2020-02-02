package bfsordfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 成语接龙
 *
 */
public class Q127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord)) return 0;
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String curr = queue.poll();
                if(curr.equals(endWord)) return level+1;
                char[] currArray = curr.toCharArray();
                for(int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for(char ch = 'a'; ch < 'z'; ch++){
                        currArray[i] = ch;
                        String check = new String(currArray);
                        if(!visited.contains(check) && wordList.contains(check)){
                            visited.add(check);
                            queue.offer(check);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;

        }
        return 0;
    }

    public static void main(String[] args) {
        Q127 q127 = new Q127();
        Set set = new HashSet();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        set.add("cog");
       int i = q127.ladderLength("hit","cog",set);
        System.out.println(i);

    }
}
