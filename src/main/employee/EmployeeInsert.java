package main.employee;

import dto.EmployeeDto;
import model.Model;
import service.EmployeeService;
import view.EmployeeView;

import java.util.ArrayList;

public class EmployeeInsert {

    public static void employeeInsert() {
        EmployeeService employeeService = new EmployeeService();
        Model model = new Model();
        EmployeeView employeeView = new EmployeeView();

        employeeView.employeeIdView(model);

        ArrayList<EmployeeDto> resultDtos = employeeService.deleteEmployee( model.getAttribute("employeeInsert"));
        model.setAttribute("resultDtos", resultDtos);
        employeeView.deleteEmployeeResultView(model);
    }
}