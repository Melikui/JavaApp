package example;

import java.util.Scanner;

public class ATM {
    String name;
    int money;

    public ATM(String name, int money) {
        this.name = name;
        this.money = money;
    }

    /**
     * 定义查询方法
     *
     * @param showHeader 是否显示提示头
     */
    public void query(boolean showHeader) {
        if (showHeader) {
            System.out.println("----------- 查询余额 -----------");
        }
        System.out.println(this.name + "，您好，您的余额剩余：" + this.money + "元");
    }

    /**
     * 定义存款方法
     *
     * @param money 金额
     */
    public void saveMoney(int money) {
        this.money += money;
        System.out.println("----------- 存款 -----------");
        System.out.println(this.name + "，您好，您存款：" + this.money + "元成功。");
        // 调用 query 函数查询余额
        this.query(false);
    }

    /**
     * 定义取款方法
     *
     * @param money 金额
     */
    public void getMoney(int money) {
        this.money -= money;
        System.out.println("----------- 取款 -----------");
        System.out.println(this.name + "，您好，您取款：" + this.money + "元成功。");
        // 调用 query 方法查询余额
        this.query(false);
    }

    /**
     * 选择操作
     *
     * @return 输入的选择
     */
    public String userInput() {
        System.out.println("----------- 主菜单 -----------");
        System.out.println(this.name + "，您好，欢迎来到银行ATM。请选择操作：");
        System.out.println("查询余额\t[输入1]");
        System.out.println("存款\t\t[输入2]");
        System.out.println("取款\t\t[输入3]");
        System.out.println("退出\t\t[输入4]");
        System.out.print("请输入你的操作：");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


    /**
     * 输出操作菜单
     */
    public void showMenu() {
        while (true) {
            String input = this.userInput();
            Scanner scanner = new Scanner(System.in);
            switch (input) {
                case "1" -> this.query(true);
                case "2" -> {
                    System.out.print("您想要存多少钱？请输入：");
                    this.saveMoney(scanner.nextInt());
                }
                case "3" -> {
                    System.out.print("您想要取多少钱？请输入：");
                    this.getMoney(scanner.nextInt());
                }
                default -> {
                    System.out.println("\n----------- 退出程序 -----------");
                    return;
                }
            }
        }
    }
}
