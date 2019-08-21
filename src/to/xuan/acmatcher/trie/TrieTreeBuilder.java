package to.xuan.acmatcher.trie;


import com.sun.istack.internal.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TrieTreeBuilder {

    public static TrieTree build(String word) throws to.xuan.trie.exceptions.TrieNodeNotALeafException {
        return build(Collections.singletonList(word));
    }

    public static TrieTree build(@NotNull Iterable<String> words) throws to.xuan.trie.exceptions.TrieNodeNotALeafException {
        Set<String> chars = new HashSet<>();
        Set<TrieNode> allNodes = new HashSet<>();
        Set<TrieNode> roots = new HashSet<>();
        for (String word : words) {
            addWordToTree(word, chars, roots, allNodes);
        }
        return new TrieTree(chars, roots);
    }

    private static void addWordToTree(String word, Set<String> chars, Set<TrieNode> roots, Set<TrieNode> allNodes) throws to.xuan.trie.exceptions.TrieNodeNotALeafException {
        TrieNode prev = null;
        for (int i = 0; i < word.length(); i++) {
            String cStr = Character.toString(word.charAt(i));
            chars.add(cStr);

            if (i == 0) { // 单词第一个字
                TrieNode match = getMatchInNodeSet(roots, cStr);
                if (match == null) {
                    TrieNode newRoot = new TrieNode(cStr, null);
                    roots.add(newRoot);
                    allNodes.add(newRoot);
                    prev = newRoot;
                } else {
                    prev = match;
                }
            } else if (i == word.length() - 1) { // 单词最后一个字
                if (!prev.isInChildNode(cStr)) {
                    if (prev.getC().equals(cStr)){
                        // 同一个字 指向自己 设置他为可返回节点
                        prev.setAsLeaf();
                        prev.addLeafWord(word);
                        continue;
                    }
                    TrieNode newNode = new TrieNode(cStr, prev);
                    newNode.setAsLeaf();
                    newNode.addLeafWord(word);
                    allNodes.add(newNode);
                    prev.addNextNode(cStr, newNode);
                } else {
                    TrieNode leaf = prev.getChildByKey(cStr);
                    leaf.setAsLeaf();
                    leaf.addLeafWord(word);
                }
            } else { // 单词中间的字
                TrieNode match = getMatchInNodeSet(allNodes, cStr);
                if (match != null){
                    prev.addNextNode(cStr, match);
                    prev = match;
                } else {
                    if (!prev.isInChildNode(cStr)) {
                        // 如果没有在子分支里找到
                        if (prev.getC().equals(cStr)) {
                            // 是同一个字 指向自己
                            prev.addNextNode(cStr, prev);
                            continue;
                        }
                        TrieNode newNode = new TrieNode(cStr, prev);
                        prev.addNextNode(cStr, newNode);
                        allNodes.add(newNode);
                        prev = newNode;
                    } else {
                        prev.addNextNode(cStr, prev.getChildByKey(cStr));
                        prev = prev.getChildByKey(cStr);
                    }
                }
            }
        }
    }

    private static TrieNode getMatchInNodeSet(Set<TrieNode> nodeSet, String c){
        for (TrieNode node : nodeSet) {
            if (node.getC().equals(c)) return node;
        }
        return null;
    }

}
