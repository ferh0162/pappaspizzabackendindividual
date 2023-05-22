package dat22v2.tb.pappaspizza.dto.order;

import dat22v2.tb.pappaspizza.dto.orderitem.OrderItemResponse;
import dat22v2.tb.pappaspizza.entity.Order;
import lombok.*;
import dat22v2.tb.pappaspizza.entity.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private Integer id;

    private LocalDateTime creationDate;

    private List<OrderItemResponse> orderItems;

    private String phoneNumber;

    private String name;

    private String address;

    private String postalCode;

    private LocalDateTime pickUpTime;

    private boolean confirmed;

    private OrderStatus status;


    public OrderResponse(Order order) {
        this.id = order.getId();
        this.creationDate = order.getCreationDate();
        this.orderItems = order.getOrderItems().stream().map(OrderItemResponse::new).toList();
        this.phoneNumber = order.getPhoneNumber();
        this.name = order.getName();
        this.address = order.getAddress();
        this.postalCode = order.getPostalCode();
        this.pickUpTime = order.getPickUpTime();
        this.confirmed = order.getConfirmed();
        this.status = order.getStatus();
    }
}
