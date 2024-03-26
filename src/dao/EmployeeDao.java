package dao;

import dto.EmployeeDto;
import util.DBConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao {
    public ArrayList<EmployeeDto> selectAll() {
        ArrayList<EmployeeDto> resultDtos = new ArrayList<EmployeeDto>();
        ResultSet rs = DBConn.statementQuery("select * from EMPLOYEES");
        try {
            while (rs.next()) {
                resultDtos.add(new EmployeeDto(
                        rs.getInt(1), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("email"),
                        rs.getString("phone_number"), rs.getTimestamp("hire_date").toLocalDateTime(),
                        rs.getString("job_id"), rs.getInt("salary"),
                        rs.getDouble("commission_pct"), rs.getInt("manager_id"),
                        rs.getInt("department_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultDtos;
    }

    public ArrayList<EmployeeDto> selectDepartment(int num) {
        ArrayList<EmployeeDto> resultDtos = new ArrayList<>();
        ResultSet rs = DBConn.prepareStatementQuery1("select * from EMPLOYEES WHERE department_id = ?", num);
        return getEmployeeDtos(resultDtos, rs);
    }

    public ArrayList<EmployeeDto> selectEmployee(int num) {
        ArrayList<EmployeeDto> resultDtos = new ArrayList<>();
        ResultSet rs = DBConn.prepareStatementQuery1("select * from EMPLOYEES WHERE employee_id = ?", num);
        return getEmployeeDtos(resultDtos, rs);
    }

    private ArrayList<EmployeeDto> getEmployeeDtos(ArrayList<EmployeeDto> resultDtos, ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(rs.getInt("employee_id"));
                resultDtos.add(new EmployeeDto(
                        rs.getInt("employee_id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("email"),
                        rs.getString("phone_number"), rs.getTimestamp("hire_date").toLocalDateTime(),
                        rs.getString("job_id"), rs.getInt("salary"),
                        rs.getDouble("commission_pct"), rs.getInt("manager_id"),
                        rs.getInt("department_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultDtos;
    }
}