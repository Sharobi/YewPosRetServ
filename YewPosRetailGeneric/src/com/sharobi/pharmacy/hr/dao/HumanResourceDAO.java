package com.sharobi.pharmacy.hr.dao;

import java.io.InputStream;
import java.util.List;

import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.hr.model.Department;
import com.sharobi.pharmacy.hr.model.Designation;
import com.sharobi.pharmacy.hr.model.DutyShift;
import com.sharobi.pharmacy.hr.model.EmpAttendance;
import com.sharobi.pharmacy.hr.model.EmpLeaveCal;
import com.sharobi.pharmacy.hr.model.EmpShiftSchedule;
import com.sharobi.pharmacy.hr.model.EmpShiftScheduleList;
import com.sharobi.pharmacy.hr.model.Employee;
import com.sharobi.pharmacy.hr.model.EmployeeHoliday;
import com.sharobi.pharmacy.hr.model.EmployeeLeave;
import com.sharobi.pharmacy.hr.model.EmployeeOffDay;
import com.sharobi.pharmacy.hr.model.EmployeeType;
import com.sharobi.pharmacy.hr.model.StoreHoliday;



public interface HumanResourceDAO {

	public List<Department> getAllDepartments(String storeId)
			throws DAOException;

	public List<Designation> getAllDesignations(String storeId)
			throws DAOException;

	public List<DutyShift> getAllDutyShifts(String storeId) throws DAOException;
	
	public DutyShift getDutyShiftsById(String storeId,String id) throws DAOException;

	public List<Employee> getAllEmployees(String storeId) throws DAOException;
	
	public Employee getEmployeeById(String storeId,String id) throws DAOException;

	public List<Employee> getAllChefs(String storeId) throws DAOException;

	public List<EmployeeHoliday> getAllEmployeeHolidays(String storeId)
			throws DAOException;

	public List<EmployeeLeave> getEmployeeLeaves(String storeId)
			throws DAOException;

	public List<EmployeeOffDay> getEmployeeOffDay(String storeId)
			throws DAOException;

	public List<EmployeeType> getEmployeeTypes(String storeId)
			throws DAOException;

	public List<StoreHoliday> getStoreHolidays(String storeId)
			throws DAOException;

	public String addDepartment(Department department) throws DAOException;

	public String updateDepartment(Department department) throws DAOException;

	public String deleteDepartment(String id, String storeId)
			throws DAOException;

	public String addDesignation(Designation designation) throws DAOException;

	public String updateDesignation(Designation designation)
			throws DAOException;

	public String deleteDesignation(String id, String storeId)
			throws DAOException;

	public String addDutyShift(DutyShift dutyShift) throws DAOException;

	public String updateDutyShift(DutyShift dutyShift) throws DAOException;

	public String deleteDutyShift(String id, String storeId)
			throws DAOException;

	public int addEmployee(Employee employee) throws DAOException;

	public int updateEmployee(Employee employee) throws DAOException;

	public String deleteEmployee(String id, String storeId) throws DAOException;
	
	public String uploadEmpImage(String empId, String fileName,
			InputStream inputStream) throws Exception;
	
	public String uploadEmpDocImage(String empId,String docName, String fileName,
			InputStream inputStream) throws Exception;

	public String addEmployeeType(EmployeeType employeeType)
			throws DAOException;

	public String updateEmployeeType(EmployeeType employeeType)
			throws DAOException;

	public String deleteEmployeeType(String id, String storeId)
			throws DAOException;

	public EmployeeType getEmployeeTypesById(String storeId, int id)
			throws DAOException;
	
	public List<EmpShiftSchedule> getAllEmpShiftSchedule(String storeId,String fromDate,String toDate) throws DAOException;
	
	public List<EmpShiftSchedule> getEmpShiftScheduleByEmpIdandDate(String storeId,String empId,String date) throws DAOException;
	
	public String addEmpShiftSchedule(EmpShiftScheduleList empShiftScheduleList) throws DAOException;
	
	public String updateEmpShiftSchedule(EmpShiftScheduleList empShiftScheduleList) throws DAOException;
	
	public String cancelEmpShiftSchedule(EmpShiftScheduleList empShiftScheduleList) throws DAOException;
	
	public List<EmpAttendance> getAllEmpAttendance(String storeId,String fromDate,String toDate) throws DAOException;
	
	public EmpAttendance getEmpAttendanceByEmpIdandDate(String storeId,String empId,String date) throws DAOException;
	
	public String addEmpAttendance(EmpAttendance empAttn) throws DAOException;
	
	public List<EmpLeaveCal> getEmpCalculationByYear(String storeId,String empId,String fromDate,String toDate) throws DAOException;
}
