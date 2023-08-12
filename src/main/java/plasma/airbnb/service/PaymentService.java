package plasma.airbnb.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;

import java.math.BigDecimal;

public class PaymentService {
    private static final String STRIPE_SECRET_KEY = "sk_test_51NeED4Li9TxZbmphhNQSMsL3rCopLYB4FWWv6WEfFR07eUVkS3ZPcUIZdqMUMsmBalQ1zFV79uIfV49kAGCQfafQ00XJbQ19FB";
    public PaymentIntent createPaymentIntent(BigDecimal amount, String currency) throws StripeException {
        Stripe.apiKey = STRIPE_SECRET_KEY;

        PaymentIntentCreateParams params = new PaymentIntentCreateParams.Builder()
                .setAmount(amount.multiply(BigDecimal.valueOf(100)).longValue())  // Сумма в центах
                .setCurrency(currency)
                .build();

        return PaymentIntent.create(params);
    }

    public PaymentIntent confirmPayment(String paymentIntentId) throws StripeException {
        Stripe.apiKey = STRIPE_SECRET_KEY;

        PaymentIntent paymentIntent = PaymentIntent.retrieve(paymentIntentId);
        PaymentIntentConfirmParams params = new PaymentIntentConfirmParams.Builder()
                .setPaymentMethod(paymentIntent.getPaymentMethod())
                .build();

        return paymentIntent.confirm(params);
    }
}
