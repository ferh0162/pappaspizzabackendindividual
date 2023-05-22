package dat22v2.tb.pappaspizza.api;


import dat22v2.tb.pappaspizza.dto.receipt.ReceiptRequest;
import dat22v2.tb.pappaspizza.dto.receipt.ReceiptResponse;
import dat22v2.tb.pappaspizza.service.ReceiptService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/receipts")
public class ReceiptController {


    ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping
    public ResponseEntity<List<ReceiptResponse>> getReceipts() {
        return ResponseEntity.ok(receiptService.getReceipts());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ReceiptResponse> getReceipt(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(receiptService.getReceipt(id));
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReceiptResponse> addReceiptToOrder(@RequestBody ReceiptRequest body) {
        System.out.println(body.getOrderId());
        return ResponseEntity.ok(receiptService.addReceiptToOrder(body.getOrderId()));
    }



}
