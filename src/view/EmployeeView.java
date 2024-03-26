package view;

import dto.EmployeeDto;
import model.Model;
import util.UserInput;

import java.util.ArrayList;

public class EmployeeView {
    public EmployeeView() {
        // private 생성자로 인스턴스화 방지
    }

    public void mainMenuView(Model model) {
        System.out.println("============================================");
        String strMainMenu ="";
        strMainMenu += "1.전체조회 | 2.부서별조회 | 3.이름순 조회";
        model.setAttribute("input2", UserInput.inputInt(strMainMenu));
    }

    public void selectResultView(Model model) {
        System.out.println("------------------------------------------");
        for (EmployeeDto dto : (ArrayList<EmployeeDto>) model.getAttribute("resultDtos")) {
            System.out.println(dto);
        }
    }
}
