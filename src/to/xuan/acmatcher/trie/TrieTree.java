package to.xuan.acmatcher.trie;


import java.util.Set;

public class TrieTree {

    private Set<String> chars;

    private Set<TrieNode> roots;

    public TrieTree(Set<String> chars, Set<TrieNode> roots){
        this.chars = chars;
        this.roots = roots;
    }

    public boolean isCharInTree(String c){
        return chars.contains(c);
    }

    public void setChars(Set<String> chars) {
        this.chars = chars;
    }

    public void setRoots(Set<TrieNode> roots) {
        this.roots = roots;
    }

    public Set<TrieNode> getRoots() {
        return roots;
    }

}
