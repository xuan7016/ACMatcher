package to.xuan.acmatcher.trie;


import to.xuan.acmatcher.trie.exceptions.TrieNodeNotALeafException;
import com.sun.istack.internal.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TrieTreeBuilder {

    private static Set<String> chars;
    private static Set<TrieNode> allNodes;
    private static Set<TrieNode> roots;

    public static TrieTree build(String word) throws TrieNodeNotALeafException {
        return build(Collections.singletonList(word));
    }

    public static TrieTree build(@NotNull Iterable<String> words) throws TrieNodeNotALeafException {
        chars = new HashSet<>();
        allNodes = new HashSet<>();
        roots = new HashSet<>();
        for (String word : words) {
            addWordToTree(word);
        }
        return new TrieTree(chars, roots);
    }

    private static void addWordToTree(String word) throws TrieNodeNotALeafException {
        TrieNode prev = null;
        for (int i = 0; i < word.length(); i++) {
            String cStr = Character.toString(word.charAt(i));
            chars.add(cStr);

            if (i == word.length() - 1) { // last letter of the word
                if (prev == null){
                    TrieNode match = getMatchInNodeSet(roots, cStr);
                    if (match == null) match = makeNewNode(null, cStr);
                    makeNodeAsLeaf(match, word);
                    continue;
                }
                if (prev.getC().equals(cStr)){
                    // same letter as prev, point to self
                    makeNodeAsLeaf(prev, word);
                    continue;
                }
                TrieNode newNode = (prev.isInChildNode(cStr)) ? prev.getChildByKey(cStr) : makeNewNode(prev, cStr);
                makeNodeAsLeaf(newNode, word);
            } else if (i == 0) { // first letter of the word
                TrieNode match = getMatchInNodeSet(roots, cStr);
                prev = (match == null) ? makeNewNode(null, cStr) : match;
            } else { // middle letters of the word
                if (prev.getC().equals(cStr)) {
                    // same letter, point to self
                    prev.addNextNode(cStr, prev);
                    continue;
                }
                TrieNode match = getMatchInNodeSet(allNodes, cStr);
                if (match != null){
                    prev.addNextNode(cStr, match);
                    prev = match;
                } else {
                    if (!prev.isInChildNode(cStr)) {
                        // if it does not exist in the node's child
                        prev = makeNewNode(prev, cStr);
                    } else {
                        prev.addNextNode(cStr, prev.getChildByKey(cStr));
                        prev = prev.getChildByKey(cStr);
                    }
                }
            }
        }
    }

    private static TrieNode makeNewNode(TrieNode prev, String c){
        TrieNode temp = new TrieNode(c, prev);
        allNodes.add(temp);
        if (prev == null) {
            roots.add(temp);
        } else {
            prev.addNextNode(c, temp);
        }
        return temp;
    }

    private static void makeNodeAsLeaf(TrieNode node, String word) throws TrieNodeNotALeafException{
        node.setAsLeaf();
        node.addLeafWord(word);
    }

    private static TrieNode getMatchInNodeSet(Set<TrieNode> nodeSet, String c){
        for (TrieNode node : nodeSet) {
            if (node.getC().equals(c)) return node;
        }
        return null;
    }

}
