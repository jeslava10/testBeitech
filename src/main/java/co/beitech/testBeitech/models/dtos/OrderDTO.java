package co.beitech.testBeitech.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long orderId;

    private CustomerDTO customer;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date creationDate;

    private String deliveryAddress;

    private Double total;

    private List<ProductDetailDTO> listProductDTO;


}
