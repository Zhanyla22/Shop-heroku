package com.zhanko.learningSpring.contoller;


import com.zhanko.learningSpring.entity.CustomerEntity;
import com.zhanko.learningSpring.model.CustomerModel;
import com.zhanko.learningSpring.serviceInterfaceImplement.CustomerServiceImplemet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImplemet customerService;


    @GetMapping("/getCustomer/{cId}")
    @PreAuthorize("hasAuthority('can:read')")
    public ResponseEntity<CustomerModel> getCustomerById(@RequestParam Integer cId)throws Exception{  //написать эксепшн
        return customerService.getCustomerById(cId);
    }

    @GetMapping("/getAllCustomer")
    @PreAuthorize("hasAuthority('can:read')")
    public List<CustomerEntity> getAllEmployee(){

        return customerService.getAllCustomer();
    }

    @PostMapping("/createNewCustomer")
    @PreAuthorize("hasAuthority('can:write')")
    public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customerModel ) throws Exception{
        return customerService.createNewCustomer(customerModel);
    }

    @PutMapping("/updateCustomer/{cid}")
    @PreAuthorize("hasAuthority('can:write')")
    public ResponseEntity<CustomerModel> UpdateCustomerById(@PathVariable Integer cId, CustomerModel customerModel) throws Exception{
        return customerService.updateCustomerById(cId,customerModel);
    }

    @DeleteMapping("/deleteCustomer/{cId}")
    @PreAuthorize("hasAuthority('can:write')")
    public void deleteCustomer(Integer cId){
        customerService.deleteCustomerById(cId);
    }
}
