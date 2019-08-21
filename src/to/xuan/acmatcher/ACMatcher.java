package to.xuan.acmatcher;

import java.util.List;
import java.util.Set;

public interface ACMatcher {

    ACMatcher build(String word);

    ACMatcher build(String[] wordList);

    ACMatcher build(List<String> wordList);

    ACMatcher build(Set<String> wordList);

    List<String> matchAll(String message);

    String matchOne(String message);

    boolean exists(String message);

}
