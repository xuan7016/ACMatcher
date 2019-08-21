package to.xuan.acmatcher;


import to.xuan.acmatcher.trie.TrieTree;
import to.xuan.acmatcher.trie.TrieTreeBuilder;
import to.xuan.acmatcher.trie.exceptions.TrieNodeNotALeafException;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String text = "我是傻屌吗";
        List<String> toMatch = Arrays.asList("我是傻屌", "我傻屌", "是智障", "我是智障", "我是智障啊", "哈哈哈哈",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n");
        TrieTree matcherTree;
        int RUNS = 50000000;
        try {
            matcherTree = TrieTreeBuilder.build(toMatch);
        } catch (TrieNodeNotALeafException e){
            e.printStackTrace();
            return;
        }
        long startTime = System.currentTimeMillis();
        System.out.println("Start Time: " + startTime);
        TrieTreeMatcher matcher = new TrieTreeMatcher(matcherTree);
        for (int i = 0; i < RUNS; i++) {
            Set<String> matched = matcher.matchAll(text);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("End Time: " + endTime);
        System.out.println("Total Time: " + (endTime - startTime));

        Set<String> toMatchSet = new HashSet<>(toMatch);
        startTime = System.currentTimeMillis();
        System.out.println("Start Time: " + startTime);
        for (int i=0; i < RUNS; i++) {
            Set<String> matched = new HashSet<>();
            for (String word : toMatchSet) {
                if (text.contains(word)) matched.add(word);
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("End Time: " + endTime);
        System.out.println("Total Time: " + (endTime - startTime));
    }
}
