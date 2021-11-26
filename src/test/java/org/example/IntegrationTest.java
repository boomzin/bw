package org.example;

import org.junit.jupiter.api.*;

import static org.example.TestData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntegrationTest {

    @BeforeAll
    static void startObjectsState() {
        clear();
        System.out.println("Starting state of set of objects");
        System.out.println(OBJECT_SET);
    }

    @AfterEach
    void currentState() {
        System.out.println("Current state of set of objects");
        System.out.println(OBJECT_SET);
    }

    @Order(1)
    @Test
    void addSubject1Test() {
        System.out.println("Adding Subject1");
        System.out.println("Set of objects owns to " + SUBJECT1);
        SUBJECT_SET.add(SUBJECT1);
        Assertions.assertNull(OBJECT0.getCurrentOwner());
        Assertions.assertNull(OBJECT1.getCurrentOwner());
        Assertions.assertEquals(SUBJECT1, OBJECT2.getCurrentOwner());
        Assertions.assertEquals(SUBJECT1, OBJECT3.getCurrentOwner());
        Assertions.assertNull(OBJECT4.getCurrentOwner());
        Assertions.assertNull(OBJECT5.getCurrentOwner());
        Assertions.assertNull(OBJECT6.getCurrentOwner());
        Assertions.assertNull(OBJECT7.getCurrentOwner());
        Assertions.assertNull(OBJECT8.getCurrentOwner());
        Assertions.assertNull(OBJECT9.getCurrentOwner());
    }

    @Order(2)
    @Test
    void addSubject2Test() {
        System.out.println("Adding Subject2");
        System.out.println("Set of objects owns to " + SUBJECT2);
        SUBJECT_SET.add(SUBJECT2);
        Assertions.assertNull(OBJECT0.getCurrentOwner());
        Assertions.assertNull(OBJECT1.getCurrentOwner());
        Assertions.assertEquals(SUBJECT1, OBJECT2.getCurrentOwner());
        Assertions.assertEquals(SUBJECT1, OBJECT3.getCurrentOwner());
        Assertions.assertEquals(SUBJECT2, OBJECT4.getCurrentOwner());
        Assertions.assertEquals(SUBJECT2, OBJECT5.getCurrentOwner());
        Assertions.assertNull(OBJECT6.getCurrentOwner());
        Assertions.assertNull(OBJECT7.getCurrentOwner());
        Assertions.assertNull(OBJECT8.getCurrentOwner());
        Assertions.assertNull(OBJECT9.getCurrentOwner());
    }

    @Order(3)
    @Test
    void addSubject3Test() {
        System.out.println("Adding Subject3");
        System.out.println("Set of objects owns to " + SUBJECT3);
        SUBJECT_SET.add(SUBJECT3);
        Assertions.assertNull(OBJECT0.getCurrentOwner());
        Assertions.assertNull(OBJECT1.getCurrentOwner());
        Assertions.assertEquals(SUBJECT3, OBJECT2.getCurrentOwner());
        Assertions.assertEquals(SUBJECT1, OBJECT3.getCurrentOwner());
        Assertions.assertEquals(SUBJECT2, OBJECT4.getCurrentOwner());
        Assertions.assertEquals(SUBJECT2, OBJECT5.getCurrentOwner());
        Assertions.assertNull(OBJECT6.getCurrentOwner());
        Assertions.assertNull(OBJECT7.getCurrentOwner());
        Assertions.assertNull(OBJECT8.getCurrentOwner());
        Assertions.assertNull(OBJECT9.getCurrentOwner());
    }

    @Order(4)
    @Test
    void removeSubject2Test() {
        System.out.println("Removing Subject2");
        System.out.println("Set of objects owns to " + SUBJECT2);
        SUBJECT_SET.remove(SUBJECT2);
        Assertions.assertNull(OBJECT0.getCurrentOwner());
        Assertions.assertNull(OBJECT1.getCurrentOwner());
        Assertions.assertEquals(SUBJECT3, OBJECT2.getCurrentOwner());
        Assertions.assertEquals(SUBJECT1, OBJECT3.getCurrentOwner());
        Assertions.assertNull(OBJECT4.getCurrentOwner());
        Assertions.assertNull(OBJECT5.getCurrentOwner());
        Assertions.assertNull(OBJECT6.getCurrentOwner());
        Assertions.assertNull(OBJECT7.getCurrentOwner());
        Assertions.assertNull(OBJECT8.getCurrentOwner());
        Assertions.assertNull(OBJECT9.getCurrentOwner());
    }

    @Order(5)
    @Test
    void addSubject4Test() {
        System.out.println("Adding Subject4");
        System.out.println("Set of objects owns to " + SUBJECT4);
        SUBJECT_SET.add(SUBJECT4);
        Assertions.assertNull(OBJECT0.getCurrentOwner());
        Assertions.assertNull(OBJECT1.getCurrentOwner());
        Assertions.assertEquals(SUBJECT3, OBJECT2.getCurrentOwner());
        Assertions.assertEquals(SUBJECT1, OBJECT3.getCurrentOwner());
        Assertions.assertNull(OBJECT4.getCurrentOwner());
        Assertions.assertNull(OBJECT5.getCurrentOwner());
        Assertions.assertNull(OBJECT6.getCurrentOwner());
        Assertions.assertNull(OBJECT7.getCurrentOwner());
        Assertions.assertNull(OBJECT8.getCurrentOwner());
        Assertions.assertNull(OBJECT9.getCurrentOwner());
    }

    @Order(6)
    @Test
    void addSubject5Test() {
        System.out.println("Adding Subject5");
        System.out.println("Set of objects owns to " + SUBJECT5);
        SUBJECT_SET.add(SUBJECT5);
        Assertions.assertNull(OBJECT0.getCurrentOwner());
        Assertions.assertNull(OBJECT1.getCurrentOwner());
        Assertions.assertEquals(SUBJECT3, OBJECT2.getCurrentOwner());
        Assertions.assertEquals(SUBJECT1, OBJECT3.getCurrentOwner());
        Assertions.assertEquals(SUBJECT5, OBJECT4.getCurrentOwner());
        Assertions.assertEquals(SUBJECT5, OBJECT5.getCurrentOwner());
        Assertions.assertNull(OBJECT6.getCurrentOwner());
        Assertions.assertNull(OBJECT7.getCurrentOwner());
        Assertions.assertNull(OBJECT8.getCurrentOwner());
        Assertions.assertNull(OBJECT9.getCurrentOwner());
    }

    @Order(7)
    @Test
    void addSubject6Test() {
        System.out.println("Adding Subject6");
        System.out.println("Set of objects owns to " + SUBJECT6);
        SUBJECT_SET.add(SUBJECT6);
        Assertions.assertNull(OBJECT0.getCurrentOwner());
        Assertions.assertNull(OBJECT1.getCurrentOwner());
        Assertions.assertEquals(SUBJECT3, OBJECT2.getCurrentOwner());
        Assertions.assertEquals(SUBJECT1, OBJECT3.getCurrentOwner());
        Assertions.assertTrue((OBJECT4.getCurrentOwner() == SUBJECT6 && OBJECT5.getCurrentOwner() == SUBJECT5)
                || (OBJECT4.getCurrentOwner() == SUBJECT5 && OBJECT5.getCurrentOwner() == SUBJECT6));
        Assertions.assertNull(OBJECT6.getCurrentOwner());
        Assertions.assertNull(OBJECT7.getCurrentOwner());
        Assertions.assertNull(OBJECT8.getCurrentOwner());
        Assertions.assertNull(OBJECT9.getCurrentOwner());
    }

    @Order(8)
    @Test
    void removeSubject3Test() {
        System.out.println("Removing Subject3");
        System.out.println("Set of objects owns to " + SUBJECT3);
        SUBJECT_SET.remove(SUBJECT3);
        Assertions.assertNull(OBJECT0.getCurrentOwner());
        Assertions.assertNull(OBJECT1.getCurrentOwner());
        Assertions.assertEquals(SUBJECT1, OBJECT2.getCurrentOwner());
        Assertions.assertEquals(SUBJECT1, OBJECT3.getCurrentOwner());
        Assertions.assertTrue((OBJECT4.getCurrentOwner() == SUBJECT6 && OBJECT5.getCurrentOwner() == SUBJECT5)
                || (OBJECT4.getCurrentOwner() == SUBJECT5 && OBJECT5.getCurrentOwner() == SUBJECT6));
        Assertions.assertNull(OBJECT6.getCurrentOwner());
        Assertions.assertNull(OBJECT7.getCurrentOwner());
        Assertions.assertNull(OBJECT8.getCurrentOwner());
        Assertions.assertNull(OBJECT9.getCurrentOwner());
    }

    @Order(9)
    @Test
    void removeSubject1Test() {
        System.out.println("Removing Subject1");
        System.out.println("Set of objects owns to " + SUBJECT1);
        SUBJECT_SET.remove(SUBJECT1);
        Assertions.assertNull(OBJECT0.getCurrentOwner());
        Assertions.assertNull(OBJECT1.getCurrentOwner());
        Assertions.assertEquals(SUBJECT4, OBJECT2.getCurrentOwner());
        Assertions.assertEquals(SUBJECT6, OBJECT3.getCurrentOwner());
        Assertions.assertTrue((OBJECT4.getCurrentOwner() == SUBJECT6 && OBJECT5.getCurrentOwner() == SUBJECT5)
                || (OBJECT4.getCurrentOwner() == SUBJECT5 && OBJECT5.getCurrentOwner() == SUBJECT6));
        Assertions.assertEquals(null, OBJECT6.getCurrentOwner());
        Assertions.assertEquals(null, OBJECT7.getCurrentOwner());
        Assertions.assertEquals(null, OBJECT8.getCurrentOwner());
        Assertions.assertEquals(null, OBJECT9.getCurrentOwner());
    }
}
