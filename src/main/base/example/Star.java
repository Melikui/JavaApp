package example;

public class Star {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 1; i <= 5; i++) {
            // 空格数等于最大行数 - 当前行数
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            // 星星数等于(当前行数*2-1)
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }
            // 每画一行就换一次行
            System.out.println();
        }
    }
}
