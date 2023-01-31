package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Asset;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.serviceimplementation.AssetServiceImplementation;
import com.employee.serviceimplementation.EmployeeServiceImplementation;

@CrossOrigin("*")
@RestController

public class AdminController {

	@Autowired
	private AssetServiceImplementation assetService;
	
	@Autowired
	private EmployeeServiceImplementation employeeService;
	
	
	@PostMapping("/addAsset")
	public Asset addAsset(@RequestBody Asset asset) {
		return assetService.addAsset(asset);
	}
	
	@DeleteMapping("/deleteAsset/{id}")
	public void deleteAsset(@PathVariable("id") int id) {
          assetService.deleteAsset(id);
	}
	
	@PutMapping("/updateAsset/{id}")
	public Asset updateAsset(@PathVariable("id") int id,@RequestBody Asset asset) {
		return assetService.updateAsset(id,asset);
	}
	
	@GetMapping("/viewAllAssets")
	public List<Asset> viewAllAssets(){
		return assetService.viewAllAssets();
	}
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/updateEmployeeName/{id}/{name}")
	public Employee updateEmployeeName(@PathVariable ("id") int id,@PathVariable("name") String name) {
		return employeeService.updateEmployeeName(id,name);
	}

	@GetMapping("/viewAllEmployees")
	public List<Employee> viewAllEmployees(){
		return employeeService.retriveAllEmployees();
	}
	
	@GetMapping("/login/{id}/{name}")
	public String login(@PathVariable ("id") int id,@PathVariable ("name")String name) {
		return employeeService.login(id,name);
	}
	
	
	
}
