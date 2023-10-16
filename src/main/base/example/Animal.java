package example;

public class Animal {
    private final String name;
    private final int id;

    public Animal(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void eat() {
        System.out.println(name + "正在吃");
    }

    public void sleep() {
        System.out.println(name + "正在睡");
    }

    public void introduction() {
        System.out.println("大家好！我是" + id + "号" + name + ".");
    }
}

class Penguin extends Animal {
    public Penguin(String name, int id) {
        super(name, id);
    }
}

class Mouse extends Animal {
    public Mouse(String name, int id) {
        super(name, id);
    }
}

