package org.example;

public class TestData {
    public static final MyObject OBJECT0 = new MyObject("Object0");
    public static final MyObject OBJECT1 = new MyObject("Object1");
    public static final MyObject OBJECT2 = new MyObject("Object2");
    public static final MyObject OBJECT3 = new MyObject("Object3");
    public static final MyObject OBJECT4 = new MyObject("Object4");
    public static final MyObject OBJECT5 = new MyObject("Object5");
    public static final MyObject OBJECT6 = new MyObject("Object6");
    public static final MyObject OBJECT7 = new MyObject("Object7");
    public static final MyObject OBJECT8 = new MyObject("Object8");
    public static final MyObject OBJECT9 = new MyObject("Object9");

    public static final ObjectSet OBJECT_SET = new ObjectSet(OBJECT0, OBJECT1, OBJECT2, OBJECT3, OBJECT4, OBJECT5, OBJECT6, OBJECT7, OBJECT8, OBJECT9);
    public static final SubjectSet SUBJECT_SET = new SubjectSet();
    public static final Subject SUBJECT1 = new Subject(false, "Subject1", OBJECT2, OBJECT3);
    public static final Subject SUBJECT2 = new Subject(false, "Subject2", OBJECT2, OBJECT4, OBJECT5);
    public static final Subject SUBJECT3 = new Subject(false, "Subject3", OBJECT2);
    public static final Subject SUBJECT4 = new Subject(true, "Subject4", OBJECT2, OBJECT3);
    public static final Subject SUBJECT5 = new Subject(false, "Subject5", OBJECT4, OBJECT5);
    public static final Subject SUBJECT6 = new Subject(false, "Subject6", OBJECT3, OBJECT4, OBJECT5);

    static void clear() {
        for (MyObject myObject : OBJECT_SET.getObjects()) {
            myObject.setCurrentOwner(null);
            myObject.getAssignedOwners().clear();
        }
        for (Subject subject : SUBJECT_SET.getSubjects()) {
            subject.getInOwn().clear();
        }
        SUBJECT_SET.getSubjects().clear();
    }
}
