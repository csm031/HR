package view;

import model.Model;
import util.UserInput;

/*
import JAVA_0319.customer.src.com.human.dto.CustomerDto;
import JAVA_0319.customer.src.com.human.model.Model;
import JAVA_0319.customer.src.com.human.util.UserInput;
*/
public class HrDbView {
    public HrDbView() {
        // private 생성자로 인스턴스화 방지
    }

    public void mainMenuView(Model model) {
        System.out.println("HR 프로그램입니다.");
        String strMainMenu = "";
        System.out.println("============================================");
        strMainMenu += "1.직원관리 | 2.부서관리 | 3.급여관리 | 4.종료";
        model.setAttribute("input", UserInput.inputInt(strMainMenu));
    }

    public void exitOutputView(Model model) {
        System.out.println("------------------------------------------");
        System.out.println("프로그램을 종료합니다.");
        model.setAttribute("input", 4);
    }

    public void errorOutputView(Model model) {
        System.out.println("보기에 있는 숫자를 입력하세요");
    }
}
