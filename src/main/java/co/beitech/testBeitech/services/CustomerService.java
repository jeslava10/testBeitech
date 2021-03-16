package co.beitech.testBeitech.services;

import co.beitech.testBeitech.exceptions.GeneralServiceException;
import co.beitech.testBeitech.exceptions.NoDataFoundException;
import co.beitech.testBeitech.exceptions.ValidateServiceException;
import co.beitech.testBeitech.models.dtos.CustomerDTO;
import co.beitech.testBeitech.models.transforms.CustomerTransform;
import co.beitech.testBeitech.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerService {

    private static final CustomerTransform CUSTOMER_TRANSFORM = new CustomerTransform();

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> findAllCustomer(){


        try {
       return customerRepository.findAll().stream()
       .map(CUSTOMER_TRANSFORM::customerToCustomerDTO)
       .collect(Collectors.toList());

        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }


    }


}
