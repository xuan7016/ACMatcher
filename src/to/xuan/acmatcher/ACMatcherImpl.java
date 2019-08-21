package to.xuan.acmatcher;

import to.xuan.acmatcher.trie.TrieTree;
import to.xuan.acmatcher.trie.TrieTreeBuilder;

import java.util.*;

public class ACMatcherImpl implements ACMatcher {

    private TrieTreeMatcherIterator matcherIterator;

    public ACMatcherImpl(TrieTree tree){
        this.matcherIterator = new TrieTreeMatcherIterator(tree);
    }

    @Override
    public Set<String> matchAll(String text) {
        Set<String> matched = new HashSet<>();
        matcherIterator.setText(text);
        while(matcherIterator.hasNext()){
            matched.add(matcherIterator.next());
        }
        return matched;
    }

    @Override
    public String matchOne(String text) {
        matcherIterator.setText(text);
        return (matcherIterator.hasNext()) ? matcherIterator.next() : null;
    }

    @Override
    public boolean exists() {
        return false;
    }

}
