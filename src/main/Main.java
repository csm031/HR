package main;

import main.employee.EmployeeInsert;
import main.employee.EmployeeSelect;
import main.employee.EmployeeDelete;
import main.employee.EmployeeUpdate;
import model.Model;
import util.DBConn;
import view.EmployeeView;
import view.HrDbView;

public class Main {

    public static void main(String[] args) {
        System.out.println("HR 프로그램입니다.");
        Model model = new Model();
        HrDbView hrDbView = new HrDbView();

        int input = 0;
        while (input != 4) {
            hrDbView.mainMenuView(model);
            input = (int) model.getAttribute("input");

            switch (input) {
                case 1: // 직원관리 시작
                    EmployeeView employeeView = new EmployeeView();
                    int input1;
                    employeeView.employeeMenuView(model);
                    input1 = (int) model.getAttribute("input1");


                    switch (input1) {
                        case 1:
                            EmployeeSelect.employeeSelect();
                            break;

                        case 2:
                            EmployeeUpdate.employeeUpdate();
                            break;

                        case 3:
                            EmployeeDelete.employeeDelete();
                            break;

                        case 4:
                            EmployeeInsert.employeeInsert();
                            break;

                        default:
                            hrDbView.errorOutputView(model);
                            break;
                    }
                    break;

                case 4: // 종료
                    hrDbView.exitOutputView(model);
                    input = (int) model.getAttribute("input");
                    break;

                default:
                    hrDbView.errorOutputView(model);
                    break;
            }
            DBConn.dbClose();
        }
    }
}
