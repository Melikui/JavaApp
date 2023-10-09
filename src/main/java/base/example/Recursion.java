package base.example;

public class Recursion {
    public int recursion(int num) {
        System.out.println(num);
        return num == 1 ? num : num * recursion(num - 1);
    }
}
