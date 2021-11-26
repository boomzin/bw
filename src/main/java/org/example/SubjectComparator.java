package org.example;

import java.util.Comparator;

/**
 * The class is designed to sort items according to the following rules:
 *  - low priority items are larger than high priority items
 *  - of two subjects with equal priority, the larger is the one with more objects in ownership at the moment
 */
public class SubjectComparator implements Comparator<Subject> {
    @Override
    public int compare(Subject s1, Subject s2) {
        if (s1.equals(s2)) {
            return 0;
        }
        if (s1.isLowPrio() != s2.isLowPrio()) {
            return s1.isLowPrio() ? 1 : -1;
        }
        if (s1.getInOwn().size() == s2.getInOwn().size()) {
            return s1.hashCode() - s2.hashCode();
        }
        return s1.getInOwn().size() - s2.getInOwn().size();
    }
}
