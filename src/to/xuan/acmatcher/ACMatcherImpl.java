package to.xuan.acmatcher;

import to.xuan.acmatcher.trie.TrieTree;
import to.xuan.acmatcher.trie.TrieTreeBuilder;

import java.util.*;

public class ACMatcherImpl implements ACMatcher {

    private TrieTreeMatcherIterator matcherIterator;

    public ACMatcherImpl(TrieTree tree, String text){
        this.matcherIterator = new TrieTreeMatcherIterator(tree, text);
    }

    @Override
    public Set<String> matchAll() {
        Set<String> matched = new HashSet<>();
        while(matcherIterator.hasNext()){
            matched.add(matcherIterator.next());
        }
        return matched;
    }

    @Override
    public String matchOne() {
        return (matcherIterator.hasNext()) ? matcherIterator.next() : null;
    }

    @Override
    public boolean exists() {
        return false;
    }

}
