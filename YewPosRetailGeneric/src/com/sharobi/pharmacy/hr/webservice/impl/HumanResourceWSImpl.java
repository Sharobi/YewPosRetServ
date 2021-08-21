package com.sharobi.pharmacy.hr.webservice.impl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
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
import com.sharobi.pharmacy.hr.service.HumanResourceService;
import com.sharobi.pharmacy.hr.webservice.HumanResourceWS;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;



@Path(value = "/hr")
public class HumanResourceWSImpl implements HumanResourceWS {
  
	//private final static Logger logger = LogManager.getLogger(HumanResourceWSImpl.class);

	private HumanResourceService humanResourceService =new HumanResourceService();
	public HumanResourceWSImpl(){
		
	}

	@Override
	@Path(value = "/getAllDepartments")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllDepartments(
			@QueryParam(value = "storeId") String storeId) {
		List<Department> departmnts = null;
		try {
			departmnts = humanResourceService.getAllDepartments(storeId);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<Department>>() {
		}.getType();
		String json = gson.toJson(departmnts, type);
		//System.out.println(json);
		return json;
	}

	@Override
	@Path(value = "/getAllDesignations")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllDesignations(
			@QueryParam(value = "storeId") String storeId) {
		List<Designation> designations = null;
		try {
			designations = humanResourceService.getAllDesignations(storeId);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<Designation>>() {
		}.getType();
		String json = gson.toJson(designations, type);
		//System.out.println(json);
		return json;
	}

	@Override
	@Path(value = "/getAllDutyShifts")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllDutyShifts(@QueryParam(value = "storeId") String storeId) {
		List<DutyShift> dutyShifts = null;
		try {
			dutyShifts = humanResourceService.getAllDutyShifts(storeId);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<DutyShift>>() {
		}.getType();
		String json = gson.toJson(dutyShifts, type);
		//System.out.println(json);
		return json;
	}
	
	@Override
	@Path(value = "/getDutyShiftsById")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getDutyShiftsById(@QueryParam(value = "storeId") String storeId,@QueryParam(value = "id") String id) {
		DutyShift dutyShift = null;
		try {
			dutyShift = humanResourceService.getDutyShiftsById(storeId,id);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<DutyShift>() {
		}.getType();
		String json = gson.toJson(dutyShift, type);
		//System.out.println(json);
		return json;
	}

	@Override
	@Path(value = "/getAllEmployees")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllEmployees(@QueryParam(value = "storeId") String storeId) {
		List<Employee> employees = null;
		try {
			employees = humanResourceService.getAllEmployees(storeId);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<Employee>>() {
		}.getType();
		String json = gson.toJson(employees, type);
		//System.out.println(json);
		return json;
	}
	
	@Override
	@Path(value = "/getEmployeeById")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getEmployeeById(@QueryParam(value = "storeId") String storeId,@QueryParam(value = "id") String id) {
		Employee employee = null;
		try {
			employee = humanResourceService.getEmployeeById(storeId,id);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<Employee>() {
		}.getType();
		String json = gson.toJson(employee, type);
		//System.out.println(json);
		return json;
	}

	@Override
	@Path(value = "/getEmployeeHolidays")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllEmployeeHolidays(
			@QueryParam(value = "storeid") String storeid) {
		List<EmployeeHoliday> holidays = null;
		try {
			holidays = humanResourceService.getAllEmployeeHolidays(storeid);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<EmployeeHoliday>>() {
		}.getType();
		String json = gson.toJson(holidays, type);
		//System.out.println(json);
		return json;
	}

	@Override
	@Path(value = "/getEmployeeLeaves")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getEmployeeLeaves(
			@QueryParam(value = "storeid") String storeid) {
		List<EmployeeLeave> leaves = null;
		try {
			leaves = humanResourceService.getEmployeeLeaves(storeid);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<EmployeeLeave>>() {
		}.getType();
		String json = gson.toJson(leaves, type);
		//System.out.println(json);
		return json;
	}

	@Override
	@Path(value = "/getEmployeeOffDay")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getEmployeeOffDay(
			@QueryParam(value = "storeid") String storeid) {
		List<EmployeeOffDay> offday = null;
		try {
			offday = humanResourceService.getEmployeeOffDay(storeid);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<EmployeeOffDay>>() {
		}.getType();
		String json = gson.toJson(offday, type);
		//System.out.println(json);
		return json;
	}

	@Override
	@Path(value = "/getEmployeeTypes")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getEmployeeTypes(@QueryParam(value = "storeId") String storeId) {
		List<EmployeeType> types = null;
		try {
			types = humanResourceService.getEmployeeTypes(storeId);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<EmployeeType>>() {
		}.getType();
		String json = gson.toJson(types, type);
		//System.out.println(json);
		return json;
	}
	
	@Override
	@Path(value = "/getEmployeeTypesById")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getEmployeeTypesById(@QueryParam(value = "storeId") String storeId,@QueryParam(value = "id") String id) {
		EmployeeType emptype = null;
		try {
			int empId = Integer.parseInt(id);
			emptype = humanResourceService.getEmployeeTypesById(storeId,empId);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<EmployeeType>() {
		}.getType();
		String json = gson.toJson(emptype, type);
		//System.out.println(json);
		return json;
	}

	@Override
	@Path(value = "/getStoreHolidays")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getStoreHolidays(@QueryParam(value = "storeid") String storeid) {
		List<StoreHoliday> holidays = null;
		try {
			holidays = humanResourceService.getStoreHolidays(storeid);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<StoreHoliday>>() {
		}.getType();
		String json = gson.toJson(holidays, type);
		//System.out.println(json);
		return json;
	}

	@Override
	@Path(value = "/addDepartment")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addDepartment(Department department) {
		String status = "";
		try {
			status = humanResourceService.addDepartment(department);
		} catch (Exception x) {
			status = "Failure";
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/updateDepartment")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateDepartment(Department department) {
		String status = "";
		try {
			status = humanResourceService.updateDepartment(department);
		} catch (Exception x) {
			status = "Failure";
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteDepartment")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String deleteDepartment(@QueryParam(value = "id") String id,
			@QueryParam(value = "storeId") String storeId) {
		String message = "";
		try {
			message = humanResourceService.deleteDepartment(id, storeId);
		} catch (Exception x) {
			message = "Failure";
			x.printStackTrace();
		}

		return message;
	}

	@Override
	@Path(value = "/addDesignation")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addDesignation(Designation designation) {
		String status = "";
		try {
			status = humanResourceService.addDesignation(designation);
		} catch (Exception x) {
			status = "Failure";
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/updateDesignation")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateDesignation(Designation designation) {
		String status = "";
		try {
			status = humanResourceService.updateDesignation(designation);
		} catch (Exception x) {
			status = "Failure";
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteDesignation")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String deleteDesignation(@QueryParam(value = "id") String id,
			@QueryParam(value = "storeId") String storeId) {
		String message = "";
		try {
			message = humanResourceService.deleteDesignation(id, storeId);
		} catch (Exception x) {
			message = "Failure";
			x.printStackTrace();
		}

		return message;
	}

	@Override
	@Path(value = "/addDutyShift")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addDutyShift(DutyShift dutyShift) {
		String status = "";
		try {
			status = humanResourceService.addDutyShift(dutyShift);
		} catch (Exception x) {
			status = "Failure";
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/updateDutyShift")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateDutyShift(DutyShift dutyShift) {
		String status = "";
		try {
			status = humanResourceService.updateDutyShift(dutyShift);
		} catch (Exception x) {
			status = "Failure";
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteDutyShift")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String deleteDutyShift(@QueryParam(value = "id") String id,
			@QueryParam(value = "storeId") String storeId) {
		String message = "";
		try {
			message = humanResourceService.deleteDutyShift(id, storeId);
		} catch (Exception x) {
			message = "Failure";
			x.printStackTrace();
		}

		return message;
	}

	@Override
	@Path(value = "/addEmployee")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addEmployee(Employee employee) {
		String status = "";
		int empid=0;
		try {
			empid = humanResourceService.addEmployee(employee);
		} catch (Exception x) {
			status = "Failure";
			x.printStackTrace();
		}

		return status+empid;
	}

	@Override
	@Path(value = "/updateEmployee")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateEmployee(Employee employee) {
		String status = "";
		int empid=0;
		try {
			empid = humanResourceService.updateEmployee(employee);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return status+empid;
	}

	@Override
	@Path(value = "/deleteEmployee")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String deleteEmployee(@QueryParam(value = "id") String id,
			@QueryParam(value = "storeId") String storeId) {
		String message = "";
		try {
			message = humanResourceService.deleteEmployee(id, storeId);
		} catch (Exception x) {
			message = "Failure";
			x.printStackTrace();
		}

		return message;
	}
	
	
	@Path(value = "/uploadEmpImage")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String uploadEmpImage(
		@FormDataParam("file") InputStream  file,
		@FormDataParam("file") FormDataContentDisposition cdh,
		@FormDataParam("emp") String emp) {
		ObjectMapper objectMapper = new ObjectMapper();
		String status = "";
		try {
			JsonNode mf = objectMapper.readTree(emp);
			String empId=mf.get("id").toString();
			String fileName=mf.get("fileName").toString();
			status = humanResourceService.uploadEmpImage(empId, fileName, file);

		} catch (Exception x) {
			x.printStackTrace();

		}
		return status;

	}
	
	@Path(value = "/uploadEmpDocImage")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String uploadEmpDocImage(
			@FormDataParam("file") InputStream  file,
			@FormDataParam("file") FormDataContentDisposition cdh,
			@FormDataParam("emp") String emp) {
		ObjectMapper objectMapper = new ObjectMapper();
		String status = "";
		try {
			JsonNode mf = objectMapper.readTree(emp);
			String empId=mf.get("id").toString();
			String docName=mf.get("docName").textValue();
			String fileName=mf.get("fileName").toString();
			status = humanResourceService.uploadEmpDocImage(empId,docName ,fileName, file);

		} catch (Exception x) {
			x.printStackTrace();

		}
		return status;

	}
	
	@Path(value = "/getEmpImage")
	@GET
	@Produces("text/plain")
	public void getEmpImage(@QueryParam(value = "id") String id,@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		try {
			String path = "/home/ubuntu/.resturant/hr";
			String ops = System.getProperty("os.name").toLowerCase();
			if (ops.startsWith("windows")) {
				path = "C:/uploadedImages/hr";
			}
			File file = new File(path + "/"+"emp_" + id + ".png");
			InputStream is = new FileInputStream(file);
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("file not found exception! emp_"+id+".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Path(value = "/getEmpDocImage")
	@GET
	@Produces("text/plain")
	public void getEmpDocImage(@QueryParam(value = "id") String id,@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		try {
			String path = "/home/ubuntu/.resturant/hr";
			String ops = System.getProperty("os.name").toLowerCase();
			if (ops.startsWith("windows")) {
				path = "C:/uploadedImages/hr";
			}
			File file = new File(path + "/"+"empdoc_" + id + ".png");
			InputStream is = new FileInputStream(file);
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("file not found exception! empdoc_"+id+".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	@Path(value = "/addEmployeeType")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addEmployeeType(EmployeeType employeeType) {
		String status = "";
		try {
			status = humanResourceService.addEmployeeType(employeeType);
		} catch (Exception x) {
			status = "Failure";
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/updateEmployeeType")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateEmployeeType(EmployeeType employeeType) {
		String status = "";
		try {
			status = humanResourceService.updateEmployeeType(employeeType);
		} catch (Exception x) {
			status = "Failure";
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteEmployeeType")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String deleteEmployeeType(@QueryParam(value = "id") String id,
			@QueryParam(value = "storeId") String storeId) {
		String message = "";
		try {
			message = humanResourceService.deleteEmployeeType(id, storeId);
		} catch (Exception x) {
			message = "Failure";
			x.printStackTrace();
		}

		return message;
	}
	
	@Override
	@Path(value = "/getAllEmpShiftSchedule")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllEmpShiftSchedule(@QueryParam(value = "storeId") String storeId,@QueryParam(value = "fromDate") String fromDate,
			@QueryParam(value = "toDate") String toDate) {
		List<EmpShiftSchedule> shiftSchedules = null;
		try {
			shiftSchedules = humanResourceService.getAllEmpShiftSchedule(storeId,fromDate,toDate);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<EmpShiftSchedule>>() {
		}.getType();
		String json = gson.toJson(shiftSchedules, type);
		//System.out.println(json);
		return json;
	}
	
	@Override
	@Path(value = "/getEmpShiftScheduleByEmpIdandDate")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getEmpShiftScheduleByEmpIdandDate(@QueryParam(value = "storeId") String storeId,@QueryParam(value = "empId") String empId,
			@QueryParam(value = "date") String date) {
		List<EmpShiftSchedule> shiftSchedules = null;
		try {
			shiftSchedules = humanResourceService.getEmpShiftScheduleByEmpIdandDate(storeId,empId,date);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<EmpShiftSchedule>>() {
		}.getType();
		String json = gson.toJson(shiftSchedules, type);
		//System.out.println(json);
		return json;
	}

	@Override
	@Path(value = "/addEmpShiftSchedule")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addEmpShiftSchedule(EmpShiftScheduleList empShiftScheduleList) {
		String status = "";
		try {
			status = humanResourceService.addEmpShiftSchedule(empShiftScheduleList);
		} catch (Exception x) {
			status = "Failure";
			x.printStackTrace();
		}

		return status;
	}
	
	@Override
	@Path(value = "/updateEmpShiftSchedule")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateEmpShiftSchedule(EmpShiftScheduleList empShiftScheduleList) {
		String status = "";
		try {
			status = humanResourceService.updateEmpShiftSchedule(empShiftScheduleList);
		} catch (Exception x) {
			status = "Failure";
			x.printStackTrace();
		}

		return status;
	}
	
	@Override
	@Path(value = "/cancelEmpShiftSchedule")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String cancelEmpShiftSchedule(EmpShiftScheduleList empShiftScheduleList) {
		String status = "";
		try {
			status = humanResourceService.cancelEmpShiftSchedule(empShiftScheduleList);
		} catch (Exception x) {
			status = "Failure";
			x.printStackTrace();
		}

		return status;
	}
	
	@Override
	@Path(value = "/getAllEmpAttendance")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllEmpAttendance(@QueryParam(value = "storeId") String storeId,@QueryParam(value = "fromDate") String fromDate,
			@QueryParam(value = "toDate") String toDate) {
		List<EmpAttendance> attns = null;
		try {
			attns = humanResourceService.getAllEmpAttendance(storeId,fromDate,toDate);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<EmpAttendance>>() {
		}.getType();
		String json = gson.toJson(attns, type);
		//System.out.println(json);
		return json;
	}
	
	@Override
	@Path(value = "/getEmpAttendanceByEmpIdandDate")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getEmpAttendanceByEmpIdandDate(@QueryParam(value = "storeId") String storeId,@QueryParam(value = "empId") String empId,
			@QueryParam(value = "date") String date) {
		EmpAttendance attn = null;
		try {
			attn = humanResourceService.getEmpAttendanceByEmpIdandDate(storeId,empId,date);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<EmpAttendance>() {
		}.getType();
		String json = gson.toJson(attn, type);
		//System.out.println(json);
		return json;
	}
	
	@Override
	@Path(value = "/addEmpAttendance")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addEmpAttendance(EmpAttendance empAttn) {
		String status = "";
		try {
			status = humanResourceService.addEmpAttendance(empAttn);
		} catch (Exception x) {
			status = "Failure";
			x.printStackTrace();
		}

		return status;
	}
	
	@Override
	@Path(value = "/getEmpCalculationByYear")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getEmpCalculationByYear(@QueryParam(value = "storeId") String storeId,@QueryParam(value = "empId") String empId,
			@QueryParam(value = "fromDate") String fromDate,@QueryParam(value = "toDate") String toDate) {
		List<EmpLeaveCal> leaves = null;
		try {
			leaves = humanResourceService.getEmpCalculationByYear(storeId,empId,fromDate,toDate);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<EmpLeaveCal>>() {
		}.getType();
		String json = gson.toJson(leaves, type);
		//System.out.println(json);
		return json;
	}
	
	@Override
	@Path(value = "/getAllChefs")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllChefs(@QueryParam(value = "storeid") String storeid) {
		List<Employee> employees = null;
		try {
			employees = humanResourceService.getAllChefs(storeid);
		} catch (Exception x) {
			x.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<Employee>>() {
		}.getType();
		String json = gson.toJson(employees, type);
		//System.out.println(json);
		return json;
	}
	
	public HumanResourceService getHumanResourceService() {
		return humanResourceService;
	}

	public void setHumanResourceService(
			HumanResourceService humanResourceService) {
		this.humanResourceService = humanResourceService;
	}

}
