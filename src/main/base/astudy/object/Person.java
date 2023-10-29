package astudy.object;

public class Person {
    public String name = "person-name";

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



