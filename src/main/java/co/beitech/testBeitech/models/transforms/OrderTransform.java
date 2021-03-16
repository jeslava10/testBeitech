package co.beitech.testBeitech.models.transforms;

import co.beitech.testBeitech.models.OrderModel;
import co.beitech.testBeitech.models.dtos.OrderDTO;


public class OrderTransform {

    private static final CustomerTransform CUSTOMER_TRANSFORM = new CustomerTransform();
    private static final OrderDetailTransform ORDER_DETAIL_TRANSFORM = new OrderDetailTransform();

    public OrderDTO OrderToOrderDTO(OrderModel order){

        OrderDTO orderDTOResponse = null;

        if(order != null){

            orderDTOResponse = OrderDTO.builder()
                    .orderId(order.getOrderId())
                    .customer(CUSTOMER_TRANSFORM.customerToCustomerDTO(order.getCustomerModel()))
                    .deliveryAddress(order.getDeliveryAddress())
                    .creationDate(order.getCreationDate())
                    .total(order.getTotal())
                    .build();


        }
        return orderDTOResponse;

    }

    public OrderModel OrderDTOToOrder(OrderDTO orderDTO){

        OrderModel orderResponse = null;

        if(orderDTO != null){

            orderResponse = OrderModel.builder()
                    .orderId(orderDTO.getOrderId())
                    .customerModel(CUSTOMER_TRANSFORM.customerDTOToCustomer(orderDTO.getCustomer()))
                    .deliveryAddress(orderDTO.getDeliveryAddress())
                    .creationDate(orderDTO.getCreationDate())
                    .total(orderDTO.getTotal())
                    .build();

        }
        return orderResponse;

    }







}
