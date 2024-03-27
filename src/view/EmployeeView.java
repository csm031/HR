package view;

import dto.EmployeeDto;
import model.Model;
import util.UserInput;

import java.util.ArrayList;

public class EmployeeView {
    public EmployeeView() {
        // private 생성자로 인스턴스화 방지
    }

    public void employeeMenuView(Model model) {
        System.out.println("============================================");
        String strMainMenu = "";
        strMainMenu += "1.조회 | 2.수정 | 3.삭제 | 4.삽입";
        model.setAttribute("input1", UserInput.inputInt(strMainMenu));
    }

    public void selectMenuView(Model model) {
        System.out.println("============================================");
        String strMainMenu = "";
        strMainMenu += "1.전체조회 | 2.부서별조회 | 3.직원번호 조회";
        model.setAttribute("input2", UserInput.inputInt(strMainMenu));
    }

    public void updateMenuView(Model model) {
        System.out.println("============================================");
        String strMainMenu = "";
        strMainMenu += "1.전화번호 변경 | 2.직급 변경";
        model.setAttribute("input2", UserInput.inputInt(strMainMenu));
    }

    public void DepartmentIdView(Model model) {
        model.setAttribute("departmentId", UserInput.inputDepartmentId());
    }

    public void employeeIdView(Model model) {
        model.setAttribute("employeeId", UserInput.inputEmployeeId());
    }

    public void employeeInsertView(Model model) {
        model.setAttribute("employeeInsert", UserInput.insertEmployee());
    }

    public void employeeUpdateView(Model model) {
        model.setAttribute("employeeUpdate", UserInput.updateEmployeePhoneNum());
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

    public void deleteEmployeeResultView(Model model) {
        System.out.println("삭제 완료되었습니다.");
    }
}