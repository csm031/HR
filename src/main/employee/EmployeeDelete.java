package main.employee;

import dto.EmployeeDto;
import model.Model;
import service.EmployeeService;
import view.EmployeeView;

import java.util.ArrayList;

public class EmployeeDelete {

    public static void employeeDelete() {
        EmployeeService employeeService = new EmployeeService();
        Model model = new Model();
        EmployeeView employeeView = new EmployeeView();

        employeeView.employeeIdView(model);
        int num = (int) model.getAttribute("employeeId");
        ArrayList<EmployeeDto> resultDtos = employeeService.deleteEmployee(num);
        model.setAttribute("resultDtos", resultDtos);
        employeeView.deleteEmployeeResultView(model);
    }
}