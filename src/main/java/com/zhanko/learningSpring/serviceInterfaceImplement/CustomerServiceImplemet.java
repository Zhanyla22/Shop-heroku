package com.zhanko.learningSpring.serviceInterfaceImplement;

import com.zhanko.learningSpring.entity.CustomerEntity;
import com.zhanko.learningSpring.model.CustomerModel;
import com.zhanko.learningSpring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImplemet{

    @Autowired
    private CustomerRepository customerRepository;
    public CustomerServiceImplemet(CustomerRepository customerRepository){
        this.customerRepository= customerRepository;
    }
    public List<CustomerEntity> getAllCustomer() {
        return customerRepository.findAll();
    }


    public ResponseEntity<CustomerModel> getCustomerById(Integer cId) throws Exception {
        try{
            CustomerEntity customerEntity = customerRepository.findById(cId).get();
            CustomerModel customerModel = new CustomerModel();
            customerModel.setCId(customerEntity.getCId());
            customerModel.setName(customerEntity.getName());
            customerModel.setLastName(customerEntity.getLastName());
            customerModel.setAge(customerEntity.getAge());
            customerModel.setCity(customerEntity.getCity());
            return new ResponseEntity<CustomerModel>(customerModel,HttpStatus.OK);
        }

        catch (Exception e){
            return new ResponseEntity<CustomerModel>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<CustomerModel> createNewCustomer(CustomerModel customerModel) throws Exception {
        try{
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setCId(customerModel.getCId());
            customerEntity.setName(customerModel.getName());
            customerEntity.setLastName(customerModel.getLastName());
            customerEntity.setAge(customerModel.getAge());
            customerEntity.setCity(customerModel.getCity());
            customerRepository.save(customerEntity);
            return new ResponseEntity<CustomerModel>(customerModel,HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<CustomerModel>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity<CustomerModel> updateCustomerById(Integer cId, CustomerModel customerModel) throws Exception {
        try {
            CustomerEntity customerFromDB = customerRepository.findById(cId).get();
            System.out.println(customerFromDB.toString());
            customerFromDB.setCId(customerModel.getCId());
            customerFromDB.setName(customerModel.getName());
            customerFromDB.setLastName(customerModel.getLastName());
            customerFromDB.setAge(customerModel.getAge());
            customerFromDB.setCity(customerModel.getCity());
            customerRepository.save(customerFromDB);
            return new ResponseEntity<CustomerModel>(customerModel, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<CustomerModel>(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteCustomerById(Integer cId) {
        customerRepository.deleteById(cId);
    }
}
