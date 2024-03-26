package util;

import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public static int inputInt(String st) {
        System.out.println(st);
        System.out.println("============================================");
        System.out.println("숫자를 입력하세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static int inputDepartmentId() {
        System.out.println("============================================");
        System.out.println("부서 번호를 입력하세요.");
        return Integer.parseInt(sc.nextLine());
    }
    public static double inputDouble(String st) {
        System.out.println(st + " 키를 입력하세요.>>");
        return Double.parseDouble(sc.nextLine());
    }

    public static String inputString(String st) {
        System.out.println(st + " 이름을 입력하세요.>>");
        return sc.nextLine();
    }
}
