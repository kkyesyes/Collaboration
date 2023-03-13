package com.kiki.SmallChangeSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {

    //1.先完成显示菜单，并可以选择菜单，给出对应提示
    //2.完成零钱通明细
    //3.收益入账

    public static void main(String[] args) {

        //定义相关的变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //2.完成零钱通明细
        //(1) 保存数组 (2)使用对象 (3) 用String拼接
        String details = "---------------零钱通明细---------------";

        //3.收益入账
        //定义新变量(随功能驱动而定义新变量)
        double money = 0;
        double balance = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  //用于日期格式化的

        //4.消费
        //定义新变量，保存消费原因
        String note = "";

        //5.退出



        do {

            System.out.println("===============零钱通菜单===============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.print("请先择(1-4):");
            key = scanner.next();

            //使用switch 分支控制
            switch (key) {
                case "1" :
                    //System.out.println("1 零钱通明细");
                    System.out.println(details);
                    break;
                case "2" :
                    //System.out.println("2 收益入账");
                    System.out.print("收益入账金额:");
                    money = scanner.nextDouble();

                    //money应有校验(待完善)
                    //找出不正确的金额,给出提示,直接break
                    if (money <= 0) {
                        System.out.println("收益入账金额需大于0");
                        break;
                    }

                    balance += money;

                    //拼接收益入账信息到details
                    date = new Date();  //获取当前日期
                    details += "\n收益入账\t\t" + " +" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3" :
                    //System.out.println("3 消费");
                    System.out.print("消费金额:");
                    money = scanner.nextDouble();

                    //money 范围应进行校验(待完善)
                    //找出不正确的金额,给出提示,直接break
                    if (money <= 0 || money >= balance) {
                        System.out.println("你的消费金额应该在0-"+ balance + "之间");
                        break;
                    }

                    System.out.print("消费说明:");
                    note = scanner.next();

                    balance -= money;

                    //拼接消费入账信息到details
                    date = new Date();  //获取当前日期
                    details += "\n" + note + "\t\t" + " -" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4" :
                    //System.out.println("4 退     出");
                    //(1)定义一个新变量 choice, 接收用户输入
                    //一段代码完成一个小功能，尽量不要混在一起

                    String choice = "";
                    while (true) {
                        System.out.println("你确定要退出吗? y/n");
                        choice = scanner.next();
                        if ("y".equals(choice) || "n".equals(choice)) {
                            break;
                        }
                    }

                    //用户退出后进行判断
                    if (choice.equals("y")) {
                        loop = false;
                    }

                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }

        }while(loop);

        System.out.println("-----退出了零钱通-----");

    }
}
