package main;

import dto.EmployeeDto;
import model.Model;
import view.HrDbView;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        Model model = new Model();
        HrDbView hrDbView = new HrDbView();
        int input = 0;
        while (input != 4) {

            hrDbView.mainMenuView(model);
            input = (int) model.getAttribute("input");

            switch (input) {
                case 1:
                    ArrayList<EmployeeDto> resultDtos = customerService.select();
                    model.setAttribute("resultDtos", resultDtos);
                    hrDbView.selectResultView(model);
                    break;

                case 2:
                    hrDbView.insertInputView(model);
                    customerService.insert((EmployeeDto) model.getAttribute("dto"));
                    break;

                case 3:
                    hrDbView.updateInputView(model);
                    customerService.update((String) model.getAttribute("updatename"), (int) model.getAttribute("updateid"));
                    break;

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
