package dat22v2.tb.pappaspizza.dto.receipt;

import dat22v2.tb.pappaspizza.dto.order.OrderResponse;
import dat22v2.tb.pappaspizza.entity.Receipt;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class ReceiptResponse {


    Integer id;
    OrderResponse order;

    LocalDateTime completedDate;


    public ReceiptResponse(Receipt receipt) {
        this.id = receipt.getId();
        this.order = new OrderResponse(receipt.getOrder());
        this.completedDate = receipt.getCompleted();
    }
}
