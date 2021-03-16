package co.beitech.testBeitech.models.transforms;

import co.beitech.testBeitech.models.OrderModel;
import co.beitech.testBeitech.models.dtos.OrderCustomerProductDTO;
import co.beitech.testBeitech.models.dtos.OrderDTO;


public class OrderTransform {

    private static final CustomerTransform CUSTOMER_TRANSFORM = new CustomerTransform();

    public OrderCustomerProductDTO orderCustomerProductDTOToModel(OrderModel order){

        OrderCustomerProductDTO orderCustomerProductDTOResponse = null;

        if(order != null){

            orderCustomerProductDTOResponse = OrderCustomerProductDTO.builder()
                    .orderId(order.getOrderId())
                    .customer(CUSTOMER_TRANSFORM.customerToCustomerDTO(order.getCustomerModel()))
                    .deliveryAddress(order.getDeliveryAddress())
                    .creationDate(order.getCreationDate())
                    .total(order.getTotal())
                    .build();


        }
        return orderCustomerProductDTOResponse;

    }

    public OrderModel orderModelToOrderCustomerProductDTO(OrderCustomerProductDTO orderCustomerProductDTO){

        OrderModel orderResponse = null;

        if(orderCustomerProductDTO != null){

            orderResponse = OrderModel.builder()
                    .orderId(orderCustomerProductDTO.getOrderId())
                    .customerModel(CUSTOMER_TRANSFORM.customerDTOToCustomer(orderCustomerProductDTO.getCustomer()))
                    .deliveryAddress(orderCustomerProductDTO.getDeliveryAddress())
                    .creationDate(orderCustomerProductDTO.getCreationDate())
                    .total(orderCustomerProductDTO.getTotal())
                    .build();

        }
        return orderResponse;

    }

    public OrderDTO orderDTOToEntity(OrderModel order){

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

    public OrderModel entityToOrderDTO(OrderDTO orderDTO){

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
