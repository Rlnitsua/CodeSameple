package rlnitsua.design;

import java.util.ArrayList;
import java.util.List;

public class ThroneInheritanceTLE {
    private final Person king;

    public ThroneInheritanceTLE(String kingName) {
        king = new Person(kingName);
    }

    // O(n)
    public void birth(String parentName, String childName) {
        Person parent = findPerson(king, parentName);
        if (parent != null) {
            parent.getChildren().add(new Person(childName));
        }
    }

    // O(n)
    public void death(String name) {
        Person target = findPerson(king, name);
        if (target != null) {
            target.setDead(true);
        }
    }

    private Person findPerson(Person person, String name) {
        if (person == null) {
            return null;
        }

        if (person.getName().equals(name)) {
            return person;
        } else {
            for (Person child : person.getChildren()) {
                Person target = findPerson(child, name);
                if (target != null) {
                    return target;
                }
            }
        }

        return null;
    }

    // O(n) !! TLE !!
    public List<String> getInheritanceOrder() {
        return getInheritanceOrder(king);
    }

    private List<String> getInheritanceOrder(Person person) {
        List<String> list = new ArrayList<>();
        if (!person.isDead()) {
            list.add(person.getName());
        }
        for (Person child : person.getChildren()) {
            list.addAll(getInheritanceOrder(child));
        }

        return list;
    }

    private static class Person {
        private final String name;
        private boolean isDead;
        private final List<Person> children;

        public Person(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public boolean isDead() {
            return isDead;
        }

        public void setDead(boolean dead) {
            isDead = dead;
        }

        public List<Person> getChildren() {
            return children;
        }
    }
}
