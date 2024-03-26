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
        String strMainMenu = "";
        strMainMenu += "1.전체조회 | 2.부서별조회 | 3.이름순 조회";
        model.setAttribute("input2", UserInput.inputInt(strMainMenu));
    }

    public void DepartmentIdView(Model model){
        model.setAttribute("departmentId", UserInput.inputDepartmentId());
    }

    public void selectAllResultView(Model model) {
        System.out.println(String.format("%-12s %-17s %-17s %-22s %-20s %-14s %-14s %-12s %-12s %-12s %-12s", "[employeeId]", "[firstName]", "[lastName]", "[email]", "[phoneNumber]", "[hireDate]", "[jobId]", "[salary]", "[commissionPct]", "[managerId]", "[departmentId]"));
        for (EmployeeDto dto : (ArrayList<EmployeeDto>) model.getAttribute("resultDtos")) {
            System.out.println(dto);
        }
    }

    public void selectDepartmentResultView(Model model) {
        System.out.println(String.format("%-12s %-17s %-17s %-22s %-20s %-14s %-14s %-12s %-12s %-12s %-12s", "[employeeId]", "[firstName]", "[lastName]", "[email]", "[phoneNumber]", "[hireDate]", "[jobId]", "[salary]", "[commissionPct]", "[managerId]", "[departmentId]"));
        for (EmployeeDto dto : (ArrayList<EmployeeDto>) model.getAttribute("resultDtos")) {
            System.out.println(dto);
        }
    }
}