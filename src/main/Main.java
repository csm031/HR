package main;

import main.employee.EmployeeMain;
import model.Model;
import service.EmployeeService;
import view.EmployeeView;
import view.HrDbView;

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
                case 1: // 직원관리 시작


                    EmployeeView employeeView = new EmployeeView();
                    int input1 = 0;
                    employeeView.employeeMenuView(model);
                    input1 = (int) model.getAttribute("input1");

                    switch (input1) {
                        case 1:
                            EmployeeMain.employeeMain();
                            break;

                        default:
                            hrDbView.errorOutputView(model);
                            break;
                    }
                case 4: // 종료
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
