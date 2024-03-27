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

        employeeView.employeeInsertView(model);
        String[] insertsInfo = (String[]) model.getAttribute("employeeInsert");
        model.getAttribute("employeeInsert");
        ArrayList<EmployeeDto> resultDtos = employeeService.insertEmployee(insertsInfo);
        model.setAttribute("resultDtos", resultDtos);
    }
}