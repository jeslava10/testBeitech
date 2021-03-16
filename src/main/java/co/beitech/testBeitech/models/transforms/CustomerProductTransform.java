package co.beitech.testBeitech.models.transforms;

import co.beitech.testBeitech.models.CustomerProductModel;
import co.beitech.testBeitech.models.dtos.CustomerProductDTO;

public class CustomerProductTransform {

    private static final CustomerTransform CUSTOMER_TRANSFORM = new CustomerTransform();
    private static final ProductTransform PRODUCT_TRANSFORM = new ProductTransform();

    public CustomerProductDTO CustomerProductToCustomerProductDTO(CustomerProductModel customerProductModel){

        CustomerProductDTO customerProductDTOResponse = null;

        if(customerProductModel != null){

            customerProductDTOResponse = CustomerProductDTO.builder()
                    .customer(CUSTOMER_TRANSFORM.customerToCustomerDTO(customerProductModel.getCustomerModel()))
                    .product(PRODUCT_TRANSFORM.ProductToProductDTO(customerProductModel.getProductModel()))
                    .build();


        }
        return customerProductDTOResponse;

    }

    public CustomerProductModel CustomerProductDTOToCustomerProduct(CustomerProductDTO customerProductDTO){

        CustomerProductModel customerProductModelResponse = null;

        if(customerProductDTO != null){

            customerProductModelResponse = CustomerProductModel.builder()
                    .customerModel(CUSTOMER_TRANSFORM.customerDTOToCustomer(customerProductDTO.getCustomer()))
                    .productModel(PRODUCT_TRANSFORM.ProductDTOToProduct(customerProductDTO.getProduct()))
                    .build();

        }
        return customerProductModelResponse;

    }


}
