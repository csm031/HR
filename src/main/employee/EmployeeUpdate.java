package main.employee;

import dto.EmployeeDto;
import model.Model;
import service.EmployeeService;
import view.EmployeeView;
import view.HrDbView;

import java.util.ArrayList;

public class EmployeeUpdate {

    public static void employeeUpdate() {
        System.out.println("정보 수정을 시작합니다.");

        HrDbView hrDbView = new HrDbView();
        EmployeeService employeeService = new EmployeeService();
        Model model = new Model();
        EmployeeView employeeView = new EmployeeView();
        int input2 = 0;

        employeeView.updateMenuView(model);
        input2 = (int) model.getAttribute("input2");

        switch (input2){
            case 1:
                String set = "phone_number";
                employeeView.employeePhoneUpdateView(model);
                ArrayList<EmployeeDto> resultDtos = employeeService.updateEmployee(model.getAttributes("employeeUpdate"), set);
                model.setAttribute("resultDtos", resultDtos);
                break;

            case 2:
                set = "JOB_ID";
                employeeView.employeeJobIdUpdateView(model);
                resultDtos = employeeService.updateEmployee(model.getAttributes("employeeUpdate"), set);
                model.setAttribute("resultDtos", resultDtos);
                break;
            default:
                hrDbView.errorOutputView(model);
                break;
        }

    }
}