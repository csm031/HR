package main.employee;

import model.Model;
import service.EmployeeService;
import view.EmployeeView;

public class EmployeeInsert {

    public static void employeeInsert() {
        EmployeeService employeeService = new EmployeeService();
        Model model = new Model();
        EmployeeView employeeView = new EmployeeView();

        employeeView.employeeInsertView(model);
        String[] insertsInfo = (String[]) model.getAttribute("employeeInsert");
        employeeService.insertEmployee(insertsInfo);
    }
}