package org.example;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class distributes the rights of subjects to own objects.
 */
public class SubjectSet {
    /**
     * Stores subjects with already allocated rights
     */
    private final Set<Subject> subjects = new HashSet<>();

    /**
     *Provides set of subjects with already allocated rights.
     * @return set of subjects with already allocated rights.
     */
    public Set<Subject> getSubjects() {
        return subjects;
    }

    /**
     *Adds a subject to a set of subjects. Aim to allocate rights in a "fair" way.
     * @param subject added subject.
     */
    public void add(Subject subject) {
        setSubject(subject, 0);
        for (MyObject object : subject.getAssignedObjects()) {
            object.getAssignedOwners().add(subject);
        }
    }

    /**
     * Releases objects owned by the deleted subject. Assigns each of these objects a new owner, if there is one among the assigned subjects.
     * @param subject deleted subject.
     */
    public void remove(Subject subject) {
        for (MyObject object : subject.getInOwn()) {
            object.setCurrentOwner(null);
            object.getAssignedOwners().remove(subject);
            if (object.getAssignedOwners().size() > 0) {
                object.setCurrentOwner(getSubjectWithMinInOwn(object.getAssignedOwners()));
                object.getCurrentOwner().getInOwn().add(object);
            }
        }
        for (MyObject object : subject.getAssignedObjects()) {
            object.getAssignedOwners().remove(subject);
        }
        subjects.remove(subject);
    }

    /**
     *Searches the objects assigned to the ownership of the added subject. When found, distributes the rights in a "fair" way.
     * Uses recursion. Recursion continues until the added subject takes ownership of the required number of objects.
     * This number is determined by the smallest number of objects owned by the subject from all subjects already added to the set.
     * @param subject added subject.
     * @param eager coefficient influencing the choice - to take away or not the right of ownership of another subject to a specific object.
     */
    private void setSubject(Subject subject, int eager) {
        int equity = 0;
        if (!subjects.isEmpty()) {
            equity = getSubjectWithMinInOwn(subjects).getInOwn().size();
        }
        for (MyObject object : subject.getAssignedObjects()) {
            if (object.getCurrentOwner() == null) {
                object.setCurrentOwner(subject);
                subject.getInOwn().add(object);
                subjects.add(subject);
            }
            if (object.getCurrentOwner() != subject
                    && !subject.isLowPrio()
                    && object.getCurrentOwner().getInOwn().size() > equity
                    && object.getCurrentOwner().getInOwn().size() > subject.getInOwn().size()
                    && eager > 0) {
                object.getCurrentOwner().getInOwn().remove(object);
                object.setCurrentOwner(subject);
                subject.getInOwn().add(object);
                subjects.add(subject);
            }
            if (object.getCurrentOwner() != subject
                    && !subject.isLowPrio()
                    && object.getCurrentOwner().getInOwn().size() == equity
                    && object.getCurrentOwner().getInOwn().size() > subject.getInOwn().size()
                    && eager > 1) {
                object.getCurrentOwner().getInOwn().remove(object);
                object.setCurrentOwner(subject);
                subject.getInOwn().add(object);
                subjects.add(subject);
            }
        }
        if (!subject.isLowPrio() && subject.getInOwn().size() < equity) {
            setSubject(subject, ++eager);
        }
    }

    /**
     * Provides the "smallest" of the set of subjects.
     * @param subjects set of subjects to search.
     * @return the "smallest" of the set of subjects.
     * @see SubjectComparator
     */
    private Subject getSubjectWithMinInOwn(Set<Subject> subjects) {
        return Collections.min(subjects, new SubjectComparator());
    }
}
