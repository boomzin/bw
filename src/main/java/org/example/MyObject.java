package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 * Simple POJO class for describing objects. The equals and hashCode methods have not been overridden, because checking for equality by reference is enough for this task.
 */
public class MyObject {
    /**
     * Used for clarity.
     */
    private String name;
    /**
     * Stores current subject that owns this object at a given time if such subject exist.
     */
    private Subject currentOwner;
    /**
     * Stores a collection of all subjects assigned ownership of this object.
     */
    private Set<Subject> assignedOwners = new HashSet<>();

    public MyObject(String name) {
        this.name = name;
    }

    /**
     * Provides the string name of object. Used for clarity
     * @return string field name
     */
    public String getName() {
        return name;
    }
    /**
     * Returns a string representation of the object. Used for clarity
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Provides the current subject that owns this object at a given time if such subject exist.
     * @return current subject that owns this object at a given time if such subject exist.
     * @see Subject
     */
    public Subject getCurrentOwner() {
        return currentOwner;
    }

    /**
     * Sets subject to own this object. The subject can only be one of those who are assigned the ownership of this object.
     * @param currentOwner subject that owns this object at a given time.
     * @see Subject
     */
    public void setCurrentOwner(Subject currentOwner) {
        this.currentOwner = currentOwner;
    }

    /**
     * Provides collection of all subjects assigned ownership of this object.
     * @return collection of all subjects assigned ownership of this object.
     * @see Subject
     */
    public Set<Subject> getAssignedOwners() {
        return assignedOwners;
    }
}
