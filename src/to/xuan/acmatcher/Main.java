package to.xuan.acmatcher;


import to.xuan.acmatcher.trie.TrieTree;
import to.xuan.acmatcher.trie.TrieTreeBuilder;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        TrieTree test;
        try {
            test = TrieTreeBuilder.build(Arrays.asList("我是傻屌", "我傻屌", "我是智障", "哈哈哈哈", "a"));
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println();
    }
}
