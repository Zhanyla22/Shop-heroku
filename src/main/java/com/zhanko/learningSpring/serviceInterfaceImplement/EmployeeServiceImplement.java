package com.zhanko.learningSpring.serviceInterfaceImplement;

import com.zhanko.learningSpring.entity.EmployeeEntity;
import com.zhanko.learningSpring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<EmployeeEntity> getAllEmployee(){
       return employeeRepository.findAll(); //посмотреть еще раз
    }

    public Optional<EmployeeEntity> getByID(Integer id){
        return employeeRepository.findById(id);
    }


    public EmployeeEntity createEmployee(EmployeeEntity employee){
        return employeeRepository.save(employee);
    }

    public String updateEmployee(Integer id, EmployeeEntity employee){ //переделать возвращаем updated и новые updated список,
        EmployeeEntity employeeFromDB = employeeRepository.findById(id).get();
        System.out.println(employeeFromDB.toString());
        employeeFromDB.setEmpId(employee.getEmpId());
        employeeFromDB.setName(employee.getName());
        employeeFromDB.setLastName(employee.getLastName());
        employeeFromDB.setDepartment(employee.getDepartment());
        employeeFromDB.setSalary(employee.getSalary());
        employeeFromDB.setWorkExperienceYear(employee.getWorkExperienceYear());
        employeeRepository.save(employeeFromDB);
        return "updated";
    }

    public void deleteById(Integer id){
        employeeRepository.deleteById(id);
    }

}
