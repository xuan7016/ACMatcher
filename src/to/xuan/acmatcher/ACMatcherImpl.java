package to.xuan.acmatcher;

import to.xuan.acmatcher.trie.TrieTree;
import to.xuan.acmatcher.trie.TrieTreeBuilder;

import java.util.*;

public class ACMatcherImpl implements ACMatcher {

    private TrieTree tree;

    public ACMatcherImpl(TrieTree tree){
        this.tree = tree;
    }

    @Override
    public ACMatcher build(String word) {
        return null;
    }

    @Override
    public ACMatcher build(String[] wordList) {
        return null;
    }

    @Override
    public ACMatcher build(List<String> wordList) {
        return null;
    }

    @Override
    public ACMatcher build(Set<String> wordList) {
        return null;
    }

    @Override
    public List<String> matchAll(String message) {
        return null;
    }

    @Override
    public String matchOne(String message) {
        return null;
    }

    @Override
    public boolean exists(String message) {
        return false;
    }

}
