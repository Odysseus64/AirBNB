package plasma.airbnb.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private Long id;
    private BigDecimal amount;
    private LocalDateTime currency;
}
