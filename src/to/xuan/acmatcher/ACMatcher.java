package to.xuan.acmatcher;

import to.xuan.acmatcher.trie.TrieTree;

import java.util.List;
import java.util.Set;

public interface ACMatcher {

    void setTrieTree(TrieTree tree);

    List<String> matchAll(String message);

    String matchOne(String message);

    boolean exists(String message);

}
