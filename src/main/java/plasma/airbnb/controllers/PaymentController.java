package plasma.airbnb.controllers;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import plasma.airbnb.dto.request.PaymentRequest;
import plasma.airbnb.service.PaymentService;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/create-intent")//        Возможно другой импорт из REQUESTBODY
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentRequest paymentRequest) {
        try {
            PaymentIntent paymentIntent = paymentService.createPaymentIntent(paymentRequest.getAmount(),
                    paymentRequest.getCurrency());
            return ResponseEntity.ok(paymentIntent.getClientSecret());
        } catch (StripeException e) {
            // Обработка ошибки
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/confirm")
    public ResponseEntity<String> confirmPayment(@RequestParam("paymentIntentId") String paymentIntentId) {
        try {
            PaymentIntent paymentIntent = paymentService.confirmPayment(paymentIntentId);
            return ResponseEntity.ok(paymentIntent.getStatus());
        } catch (StripeException e) {
            // Обработка ошибки
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}