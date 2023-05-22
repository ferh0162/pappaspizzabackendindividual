package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.receipt.ReceiptResponse;
import dat22v2.tb.pappaspizza.entity.Order;
import dat22v2.tb.pappaspizza.entity.Receipt;
import dat22v2.tb.pappaspizza.repository.OrderRepository;
import dat22v2.tb.pappaspizza.repository.ReceiptRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceiptService {


    ReceiptRepository receiptRepository;

    OrderRepository orderRepository;

    public ReceiptService(ReceiptRepository receiptRepository, OrderRepository orderRepository) {
        this.receiptRepository = receiptRepository;
        this.orderRepository = orderRepository;
    }

    public List<ReceiptResponse> getReceipts() {
        return receiptRepository.findAll().stream().map(ReceiptResponse::new).collect(Collectors.toList());
    }


    public ReceiptResponse addReceiptToOrder(int orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("Order not found"));
        Receipt receipt = new Receipt();
        receipt.setOrder(order);
        return new ReceiptResponse(receiptRepository.save(receipt));

    }

    public ReceiptResponse getReceipt(int id) {
        return new ReceiptResponse(receiptRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Receipt not found")));
    }
}
