package to.xuan.acmatcher;

import to.xuan.acmatcher.trie.TrieTree;

import java.util.List;
import java.util.Set;

public interface ACMatcher {

    Set<String> matchAll();

    String matchOne();

    boolean exists();

}
