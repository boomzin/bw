package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.example.TestData.*;
class SubjectComparatorTest {
    static final SubjectComparator subjectComparator = new SubjectComparator();

    @BeforeAll
    static void setSubjectSet() {
        clear();
        SUBJECT_SET.add(SUBJECT1);
        SUBJECT_SET.add(SUBJECT2);
        SUBJECT_SET.add(SUBJECT3);
        SUBJECT_SET.add(SUBJECT4);
        System.out.println("The current state of the set objects");
        System.out.println(OBJECT_SET);
    }

    @Test
    void compareSameObject() {
        Assertions.assertTrue(subjectComparator.compare(SUBJECT1, SUBJECT1) == 0);
    }
    @Test
    void compareWithDifferentPrio() {
        Assertions.assertTrue(subjectComparator.compare(SUBJECT3, SUBJECT4) < 0);
    }

    @Test
    void compareWithSamePrioDifferentInOwn() {
        Assertions.assertTrue(subjectComparator.compare(SUBJECT1, SUBJECT2) < 0);
    }

    @Test
    void compareWithSamePrioSameInOwn() {
        Assertions.assertTrue(subjectComparator.compare(SUBJECT1, SUBJECT3) == SUBJECT1.hashCode() - SUBJECT3.hashCode());
    }
}