package com.today.base;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Boy();
        Person p3 = new Girl();
        System.out.println(p1.name);
        System.out.println(p2.name);
        System.out.println(p3.name);
    }
}

class Person {
    String name = "person-name";

    void person() {
        System.out.println("person");
    }
}

class Boy extends Person {
    String name = "boy-name";

    void boy() {
        System.out.println("boy");
    }
}

class Girl extends Person {
    String name = "girl-name";

    void girl() {
        System.out.println("girl");
    }
}