package com.google.main;

import java.util.Scanner;

import com.google.service.StudentService;

public class RunAppcation {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        // 如这里你想编写界面的，实际上，也一样，你要在外界创建一个图形类
        // 然后在这里初始化图形类即可
        System.out.println("-----------Welcome Students Management System---------");

        System.out.println("1.limit for 10 data\n2.update\n3.delete\n4.....\n5.quit");

        functionService();
    }

    public static void functionService() {

        // 举例，此处可以自行修改
        switch (scanner.nextLine()) {
            // 1:
            case "1":
                System.out.println(StudentService.selectAll());
                break;

            // 2:
            case "2":
                StudentService.update(scanner.nextInt(), scanner.next(), scanner.nextInt());
                break;
            // 3:
            case "3":
                StudentService.delete(scanner.nextInt());
                break;
            // 4:...
            case "4":
                break;

            case "5":
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
