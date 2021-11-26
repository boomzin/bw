package org.example;

import java.util.*;

/**
 * Simple POJO class for describing subjects. The equals and hashCode methods have not been overridden, because checking for equality by reference is enough for this task.
 */
public class Subject {
    /**
     * Indicates that the subject has a low or high prioritet.
     */
    private final boolean lowPrio;
    /**
     * Used for clarity.
     */
    private final String name;
    /**
     * Stores a collection of all objects that have been assigned ownership by this subject.
     */
    private final Set<MyObject> assignedObjects = new HashSet<>();
    /**
     * Stores a collection of all objects currently owned by this subject.
     */
    private final Set<MyObject> inOwn = new HashSet<>();

    public Subject(boolean lowPrio, String name, MyObject... assignedObjects) {
        this.lowPrio = lowPrio;
        this.name = name;
        this.assignedObjects.addAll(Arrays.asList(assignedObjects));
    }
    /**
     * Returns a string representation of the object. Used for clarity
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        assignedObjects.stream()
                .sorted(Comparator.comparing(MyObject::getName))
                .forEach(myObject -> stringBuilder.append(myObject.getName()).append(" "));
        return getName() + ": " + stringBuilder + "LowPrio: " + lowPrio;
    }

    /**
     * Provides information of low or high priority for the subject.
     * @return
     */
    boolean isLowPrio() {
        return lowPrio;
    }
    /**
     * Provides the string name of subject. Used for clarity
     * @return string field name
     */
    String getName() {
        return name;
    }

    /**
     * Provides collection of all objects that have been assigned ownership by this subject.
     * @return collection of all objects that have been assigned ownership by this subject.
     */
    Set<MyObject> getAssignedObjects() {
        return assignedObjects;
    }

    /**
     * Provides a collection of all objects currently owned by this subject.
     * @return collection of all objects currently owned by this subject.
     */
    Set<MyObject> getInOwn() {
        return inOwn;
    }

}
