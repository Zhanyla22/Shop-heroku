package com.zhanko.learningSpring.contoller;

import com.zhanko.learningSpring.entity.EmployeeEntity;
import com.zhanko.learningSpring.model.EmployeeModel;
import com.zhanko.learningSpring.serviceInterfaceImplement.EmployeeServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImplement employeeService;

    @GetMapping("/getEmployee/{empId}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@RequestParam Integer empId) throws Exception{
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping("/allEmployee")
    public List<EmployeeEntity> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel employeeModel) throws Exception{
        return employeeService.createNewEmployee(employeeModel);
    }



    @PutMapping("/updateEmployee/{empId}")
    public ResponseEntity<EmployeeModel> updateEmployeeById(@PathVariable Integer  empId, EmployeeModel employeeModel) throws Exception {
            return employeeService.updateEmployeeById(empId,employeeModel);

    }



    @DeleteMapping("/deleteEmployee/{empId}")
    public void deleteEmployeeById(@PathVariable Integer  empId){
        employeeService.deleteEmployeeById(empId);
    }


}
