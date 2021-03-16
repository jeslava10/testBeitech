package co.beitech.testBeitech.models.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {

    private Long orderDetailId;

    private OrderDTO order;

    private ProductDTO product;

    private String productDescription;

    private Integer quantity;

    private Double price;


}
