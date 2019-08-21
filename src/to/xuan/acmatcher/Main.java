package to.xuan.acmatcher;


import to.xuan.acmatcher.trie.TrieTree;
import to.xuan.acmatcher.trie.TrieTreeBuilder;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        TrieTree test;
//        try {
//            test = TrieTreeBuilder.build(Arrays.asList("我是傻屌", "我傻屌", "是智障", "我是智障", "我是智障啊" ,"哈哈哈哈", "a"));
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println();
//
        try {
            String text = "啊哈哈哈哈智障是傻屌我傻屌";
            List<String> toMatch = Arrays.asList("我是傻屌", "我傻屌", "是智障", "我是智障", "我是智障啊", "哈哈哈哈", "a");
            ACMatcher matcher = new ACMatcherImpl(TrieTreeBuilder.build(toMatch), text);
            Set<String> matched = matcher.matchAll();
            System.out.println(matched.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
