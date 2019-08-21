package to.xuan.acmatcher;

import to.xuan.acmatcher.trie.TrieNode;
import to.xuan.acmatcher.trie.TrieTree;

import java.util.HashSet;
import java.util.Set;

public class TrieTreeMatcher {

    private TrieTree tree;

    public TrieTreeMatcher(TrieTree tree){
        this.tree = tree;
    }

    public Set<String> matchAll(String text){
        Set<String> matched = new HashSet<>();
        StringBuilder temp = new StringBuilder();
        TrieNode prev = null;
        for (int i=0; i<text.length(); i++){
            String cStr = Character.toString(text.charAt(i));
            if (!tree.isCharInTree(cStr)) {
                temp.setLength(0);
                prev = null;
                continue;
            }
            if (temp.length() == 0) {
                if (!tree.isCharInRoots(cStr)) continue;
                prev = tree.getRoots().get(cStr);
                temp.append(cStr);
            } else {
                if (prev.isInChildNode(cStr)) {
                    prev = prev.getChildByKey(cStr);
                    temp.append(prev.getC());
                    if (prev.isLeaf()) matched.add(temp.toString());
                }
            }
        }
        return matched;
    }
}
