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
        ResultSet rs = DBConn.prepareStatementQuery1("select * from EMPLOYEES WHERE department_id = ?",num);
        try {
            while (rs.next()) {
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

/*	public EmployeeDto selectId(int id) {
		EmployeeDto resultDtos=new EmployeeDto();
		ResultSet rs=DBConn.statementQuery(String.format("select * from customer where id=%d", id));
		if(rs!=null) {
			try {
				rs.next();
				resultDtos=new EmployeeDto(rs.getInt("id"),rs.getString("name"),rs.getDouble("height"),
						rs.getTimestamp("birthday").toLocalDateTime());
			}catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}
				
	public void insert(EmployeeDto dto) {
		String sql=String.format("insert into customer values("+"%d,'%s',%f,to_date('%s','yyyy-mm-dd HH24:mi:ss'))",
				dto.getId(),dto.getName(),dto.getHeight(),dto.getBirthday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
		DBConn.statementUpdate(sql);
		System.out.println("[입력 완료]");
	}
	public void update(String updatename, int updateid) {
		String sql=String.format("update customer set id='%d' where name='%s'",updateid,updatename);
		DBConn.statementUpdate(sql);
		System.out.println("[수정 완료]");
	}
	public void delete(int id) {
		String sql=String.format("delete customer where id=%d",id);
		DBConn.statementUpdate(sql);
		System.out.println("[삭제 완료]");
	}
	
	public ArrayList<Integer> getIds() {
		ArrayList<Integer> ids=new ArrayList<Integer>();
		ResultSet rs=DBConn.statementQuery(String.format("select * from customer"));
		try {
			while(rs.next()) {
				ids.add(rs.getInt("id"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return ids;
	}

	public int getMaxId() {
		int maxIdValue=-1;
		ResultSet rs=DBConn.statementQuery(String.format("select max(id) as maxId from customer"));
		if(rs!=null) {
			try {
				rs.next();
				maxIdValue=rs.getInt("maxId");	
			}catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return maxIdValue;
	}*/