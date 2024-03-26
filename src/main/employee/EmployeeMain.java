package main.employee;

import dto.EmployeeDto;
import model.Model;
import service.EmployeeService;
import view.EmployeeView;
import view.HrDbView;

import java.util.ArrayList;

public class EmployeeMain {

    public static void employeeMain() {
        EmployeeService employeeService = new EmployeeService();
        Model model = new Model();
        HrDbView hrDbView = new HrDbView();
        EmployeeView employeeView = new EmployeeView();

        int input2 = 0;

        employeeView.selectMenuView(model);
        input2 = (int) model.getAttribute("input2");

        switch (input2) {
            case 1:
                ArrayList<EmployeeDto> resultDtos = employeeService.selectAll();
                model.setAttribute("resultDtos", resultDtos);
                employeeView.selectAllResultView(model);
                break;

            case 2:
                employeeView.DepartmentIdView(model);
                int num = (int) model.getAttribute("departmentId");
                resultDtos = employeeService.selectDepartment(num);
                model.setAttribute("resultDtos", resultDtos);
                employeeView.selectDepartmentResultView(model);
                break;

            case 3:
                employeeView.employeeIdView(model);
                num = (int) model.getAttribute("employeeId");
                resultDtos = employeeService.selectEmployee(num);
                model.setAttribute("resultDtos", resultDtos);
                employeeView.selectDepartmentResultView(model);
                break;

            default:
                hrDbView.errorOutputView(model);
                break;
        }
    }
}
