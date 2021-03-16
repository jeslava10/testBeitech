package co.beitech.testBeitech.controllers;

import co.beitech.testBeitech.models.dtos.CustomerDTO;
import co.beitech.testBeitech.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin()
@RestController
@RequestMapping("/customer")
@Api(tags = "Customer Api")
public class CustomerControllers {

    private final CustomerService customerService;

    @Autowired
    public CustomerControllers(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(path = "/all")
    @ApiOperation(value = "Get All Customers", response = CustomerDTO[].class)
    public List<CustomerDTO> findAllCustomer(){
        return customerService.findAllCustomer();

    }

}
