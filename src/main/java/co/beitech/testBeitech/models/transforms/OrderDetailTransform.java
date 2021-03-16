package co.beitech.testBeitech.models.transforms;

import co.beitech.testBeitech.models.OrderDetailModel;
import co.beitech.testBeitech.models.dtos.OrderDetailDTO;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDetailTransform {

    private static final OrderTransform ORDER_TRANSFORM = new OrderTransform();
    private static final ProductTransform PRODUCT_TRANSFORM = new ProductTransform();

    public OrderDetailDTO OrderDetailToOrderDetailDTO(OrderDetailModel orderDetailModel){

        OrderDetailDTO orderDetailDTOResponse = null;

        if(orderDetailModel != null){

            orderDetailDTOResponse = OrderDetailDTO.builder()
                    .orderDetailId(orderDetailModel.getOrderDetailId())
                    .order(ORDER_TRANSFORM.OrderToOrderDTO(orderDetailModel.getOrderModel()))
                    .product(PRODUCT_TRANSFORM.ProductToProductDTO(orderDetailModel.getProductModel()))
                    .price(orderDetailModel.getPrice())
                    .quantity(orderDetailModel.getQuantity())
                    .price(orderDetailModel.getPrice())
                    .productDescription(orderDetailModel.getProductDescription())
                    .build();


        }
        return orderDetailDTOResponse;

    }

    public OrderDetailModel OrderDetailDTOToOrderDetail(OrderDetailDTO orderDetailDTO){

        OrderDetailModel orderDetailModelResponse = null;

        if(orderDetailDTO != null){

            orderDetailModelResponse = OrderDetailModel.builder()
                    .orderDetailId(orderDetailDTO.getOrderDetailId())
                    .orderModel(ORDER_TRANSFORM.OrderDTOToOrder(orderDetailDTO.getOrder()))
                    .productModel(PRODUCT_TRANSFORM.ProductDTOToProduct(orderDetailDTO.getProduct()))
                    .price(orderDetailDTO.getPrice())
                    .quantity(orderDetailDTO.getQuantity())
                    .price(orderDetailDTO.getPrice())
                    .productDescription(orderDetailDTO.getProductDescription())
                    .build();

        }
        return orderDetailModelResponse;

    }


}
