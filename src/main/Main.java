package main;

import dto.EmployeeDto;
import model.Model;
import service.EmployeeService;
import view.EmployeeView;
import view.HrDbView;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("HR 프로그램입니다.");
        EmployeeService employeeService = new EmployeeService();
        Model model = new Model();
        HrDbView hrDbView = new HrDbView();

        int input = 0;
        while (input != 4) {
            hrDbView.mainMenuView(model);
            input = (int) model.getAttribute("input");

            switch (input) {
                case 1:
                    EmployeeView employeeView = new EmployeeView();

                    int input2 = 0;

                    employeeView.mainMenuView(model);
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

                        default:
                            hrDbView.errorOutputView(model);
                            break;
                    }



/*                case 2:
                    hrDbView.insertInputView(model);
                    customerService.insert((EmployeeDto) model.getAttribute("dto"));
                    break;

                case 3:
                    hrDbView.updateInputView(model);
                    customerService.update((String) model.getAttribute("updatename"), (int) model.getAttribute("updateid"));
                    break;*/

                case 4:
                    hrDbView.exitOutputView(model);
                    input = (int) model.getAttribute("input");
                    break;

                default:
                    hrDbView.errorOutputView(model);
                    break;
            }
        }
    }
}
