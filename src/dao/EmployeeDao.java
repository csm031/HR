package dao;

import dto.EmployeeDto;
import util.DBConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao {
    public ArrayList<EmployeeDto> selectAll() {
        ArrayList<EmployeeDto> resultDtos = new ArrayList<>();
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
        ResultSet rs = DBConn.selectWhereQuery("select * from EMPLOYEES WHERE department_id = ?", num);
        return getEmployeeDtos(resultDtos, rs);
    }

    public ArrayList<EmployeeDto> selectEmployee(int num) {
        ArrayList<EmployeeDto> resultDtos = new ArrayList<>();
        ResultSet rs = DBConn.selectWhereQuery("select * from EMPLOYEES WHERE employee_id = ?", num);
        return getEmployeeDtos(resultDtos, rs);
    }

    public ArrayList<EmployeeDto> deleteEmployee(int num) {
        ArrayList<EmployeeDto> resultDtos = new ArrayList<>();
        int rs = DBConn.deleteQuery("delete from EMPLOYEES WHERE employee_id = ?",num);
        if (rs == 1) {
            System.out.println("삽입 성공");
        } else {
            System.out.println("삽입 실패");
        }
        return resultDtos;
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

    public ArrayList<EmployeeDto> updateEmployee(Object[] data, String set) {
        ArrayList<EmployeeDto> resultDtos = new ArrayList<>();
        int rs = DBConn.updateQuery("update employees set "+set+" = ? where employee_id = ?", data);
        if (rs == 1) {
            System.out.println("삽입 성공");
        } else {
            System.out.println("삽입 실패");
        }
        return resultDtos;
    }


// 직급 업데이트
    public ArrayList<EmployeeDto> updateEmployee2(Object[] data, String set) {
        ArrayList<EmployeeDto> resultDtos = new ArrayList<>();
        int rs = DBConn.updateQuery("update employees set "+set+" = ? where employee_id = ?", data);
        if (rs == 1) {
            System.out.println("삽입 성공");
            rs = DBConn.updateQuery2("update employees set employees.salary = (select jobs.min_salary from jobs where employees.job_id = jobs.job_id)" +
                    "where employee_id = ?", data);
            if (rs == 1) {
                System.out.println("salary가 업데이트 되었습니다.");
            } else {
                System.out.println("salary 업데이트 실패하였습니다.");
            }

        } else {
            System.out.println("삽입 실패");
        }
        return resultDtos;
    }


    public ArrayList<EmployeeDto> insertEmployee(String[] data) {
        ArrayList<EmployeeDto> resultDtos = new ArrayList<>();
        int rs = DBConn.insertQuery("insert into EMPLOYEES (EMPLOYEE_ID," +
                " FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY," +
                " COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID ) VALUES (EMPLOYEES_SEQ.nextval,?,?,?,?,sysdate,?,'','','','')",data);
        if (rs == 1) {
            System.out.println("삽입 성공");
        } else {
            System.out.println("삽입 실패");
        }
        return resultDtos;
    }
}