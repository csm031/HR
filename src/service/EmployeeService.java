package service;

import dao.EmployeeDao;
import dto.EmployeeDto;

import java.util.ArrayList;


public class EmployeeService {
	private EmployeeDao dao=new EmployeeDao();
	public ArrayList<EmployeeDto> selectAll() {
		return dao.selectAll();
	}

	public ArrayList<EmployeeDto> selectDepartment(int num) {
		return dao.selectDepartment(num);
	}

	public ArrayList<EmployeeDto> selectEmployee(int num) {
		return dao.selectEmployee(num);
	}

/*	public void insert(EmployeeDto dto) {
		dao.insert(dto);
	}
	public void update(String updateName, int updateid) {
		dao.update(updateName, updateid);
	}
	public void delete(int id) {
		dao.delete(id);
	}	*/
}
