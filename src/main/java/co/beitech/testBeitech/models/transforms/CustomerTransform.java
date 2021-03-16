package co.beitech.testBeitech.models.transforms;

import co.beitech.testBeitech.models.CustomerModel;
import co.beitech.testBeitech.models.dtos.CustomerDTO;

public class CustomerTransform {

    public CustomerDTO customerToCustomerDTO(CustomerModel customerModel){

        CustomerDTO customerDTOResponse = null;

        if(customerModel != null){

            customerDTOResponse = CustomerDTO.builder()
                    .customerId(customerModel.getCustomerId())
                    .name(customerModel.getName())
                    .email(customerModel.getEmail())
                    .build();


        }
        return customerDTOResponse;

    }

    public CustomerModel customerDTOToCustomer(CustomerDTO customerDTO){

        CustomerModel customerModelResponse = null;

        if(customerDTO != null){

            customerModelResponse = CustomerModel.builder()
                    .customerId(customerDTO.getCustomerId())
                    .name(customerDTO.getName())
                    .email(customerDTO.getEmail())
                    .build();


        }
        return customerModelResponse;

    }


}
