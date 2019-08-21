package to.xuan.acmatcher;

import to.xuan.acmatcher.trie.TrieNode;
import to.xuan.acmatcher.trie.TrieTree;

import java.util.Iterator;
import java.util.Set;

public class TrieTreeMatcherIterator implements Iterator<String> {

    private TrieTree tree;
    private String text;
    private String next;
    private Boolean foundByHasNext = false;
    private int index = 0;

    public TrieTreeMatcherIterator(TrieTree tree){
        this.tree = tree;
        this.text = null;
    }

    public void setText(String text){
        this.text = text;
        this.next = null;
        this.foundByHasNext = false;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        this.next = next();
        if (this.next != null){
            this.foundByHasNext = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String next() {
        if (this.foundByHasNext && this.next != null){
            this.foundByHasNext = false;
            return this.next;
        }
        StringBuilder temp = new StringBuilder();
        TrieNode prev = null;
        while (index < text.length()) {
            if (prev != null && prev.isLeaf() && prev.isInLeafWords(temp.toString())) {
                return temp.toString();
            }
            String cStr = Character.toString(text.charAt(index));
            index += 1;
            if (temp.length() == 0) {
                if (!tree.isCharInRoots(cStr)) continue;
                prev = tree.getRoots().get(cStr);
                temp.append(prev.getC());
            } else {
                if (!tree.isCharInTree(cStr)) {
                    temp.setLength(0);
                    prev = null;
                    continue;
                }
                if (prev.isInChildNode(cStr)){
                    prev = prev.getChildByKey(cStr);
                    temp.append(prev.getC());
                } else {
                    prev = null;
                    temp.setLength(0);
                }
            }
        }
        if (prev != null && prev.isLeaf() && prev.isInLeafWords(temp.toString())) {
            return temp.toString();
        }
        return null;
    }

}
