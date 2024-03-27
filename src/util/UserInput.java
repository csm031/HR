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

    public static int inputEmployeeId() {
        System.out.println("============================================");
        System.out.println("직원 번호를 입력하세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static String[] insertEmployee() {
        System.out.println("============================================");
        System.out.println("firstName을 입력하세요.");
        String firstName = sc.nextLine();
        System.out.println("lastName을 입력하세요.");
        String lastName = sc.nextLine();
        System.out.println("email을 입력하세요.");
        String email = sc.nextLine();
        System.out.println("phoneNumber을 입력하세요.");
        String phoneNumber = sc.nextLine();
        System.out.println("jobId를 입력하세요.");
        String jobId = sc.nextLine();
        return new String[]{firstName, lastName, email, phoneNumber, jobId};
    }

    public static int updateEmployeeId() {
        System.out.println("============================================");
        System.out.println("정보를 수정할 직원 번호를 입력하세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static Object updateEmployeePhoneNum() {
        Object[] data = new Object[2];
        data[0] = updateEmployeeId();
        System.out.println("============================================");
        System.out.println("변경할 전화번호를 입력하세요.");
        data[1] = sc.nextLine();
        return data;
    }
}
