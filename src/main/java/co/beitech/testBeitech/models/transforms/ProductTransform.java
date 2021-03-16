package co.beitech.testBeitech.models.transforms;

import co.beitech.testBeitech.models.ProductModel;
import co.beitech.testBeitech.models.dtos.ProductDTO;

public class ProductTransform {

    public ProductDTO ProductToProductDTO(ProductModel productModel){

        ProductDTO productDTOResponse = null;

        if(productModel != null){

            productDTOResponse = ProductDTO.builder()
                    .productId(productModel.getProductId())
                    .name(productModel.getName())
                    .productDescription(productModel.getProductDescription())
                    .price(productModel.getPrice())
                    .build();


        }
        return productDTOResponse;

    }

    public ProductModel ProductDTOToProduct(ProductDTO productDTO){

        ProductModel productModelResponse = null;

        if(productDTO != null){

            productModelResponse = ProductModel.builder()
                    .productId(productDTO.getProductId())
                    .name(productDTO.getName())
                    .productDescription(productDTO.getProductDescription())
                    .price(productDTO.getPrice())
                    .build();

        }
        return productModelResponse;

    }


}
