package dat22v2.tb.pappaspizza.dto.order;

import dat22v2.tb.pappaspizza.dto.orderitem.OrderItemRequest;
import dat22v2.tb.pappaspizza.entity.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequest {

    private Integer id;

    private String phoneNumber;

    private List<OrderItemRequest> orderItems;

    private String name;
    private String address;
    private String postalCode;
    private LocalDateTime pickUpTime;

    private boolean confirmed;
    private OrderStatus status;



}
