package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.TestData.*;

class SubjectSetTest {

    @BeforeEach
    void clearData() {
        clear();
    }

    @Test
    void testAdd() {
        SUBJECT_SET.add(SUBJECT1);
        Assertions.assertEquals(OBJECT2.getCurrentOwner(), SUBJECT1);
        Assertions.assertEquals(OBJECT3.getCurrentOwner(), SUBJECT1);
    }

    @Test
    void testAddLowPrio() {
        SUBJECT_SET.add(SUBJECT1);
        Assertions.assertEquals(OBJECT2.getCurrentOwner(), SUBJECT1);
        Assertions.assertEquals(OBJECT3.getCurrentOwner(), SUBJECT1);
        SUBJECT_SET.add(SUBJECT4);
        Assertions.assertEquals(OBJECT2.getCurrentOwner(), SUBJECT1);
        Assertions.assertEquals(OBJECT3.getCurrentOwner(), SUBJECT1);
    }

    @Test
    void remove() {
        SUBJECT_SET.add(SUBJECT1);
        Assertions.assertEquals(OBJECT2.getCurrentOwner(), SUBJECT1);
        Assertions.assertEquals(OBJECT3.getCurrentOwner(), SUBJECT1);
        SUBJECT_SET.add(SUBJECT4);
        Assertions.assertEquals(OBJECT2.getCurrentOwner(), SUBJECT1);
        Assertions.assertEquals(OBJECT3.getCurrentOwner(), SUBJECT1);
        SUBJECT_SET.remove(SUBJECT1);
        Assertions.assertEquals(OBJECT2.getCurrentOwner(), SUBJECT4);
        Assertions.assertEquals(OBJECT3.getCurrentOwner(), SUBJECT4);
    }
}