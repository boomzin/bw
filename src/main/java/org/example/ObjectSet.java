package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 *This class is only designed to provide a textual display of a set of objects sorted by name in alphabetical order.
 */
public class ObjectSet {
    private final Set<MyObject> objects = new HashSet<>();

    public ObjectSet(MyObject... objects) {
        this.objects.addAll(Arrays.asList(objects));
    }

    public Set<MyObject> getObjects() {
        return objects;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        objects.stream()
                .sorted(Comparator.comparing(MyObject::getName))
                .forEach(myObject -> stringBuilder.append(myObject).append(": ").append(myObject.getCurrentOwner()).append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
