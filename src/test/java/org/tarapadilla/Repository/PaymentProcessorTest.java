package org.tarapadilla.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorTest {
    private IPaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;
    @BeforeEach
    public void setup(){
        paymentGateway = Mockito.mock(IPaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_is_correct() {
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
        boolean result = paymentProcessor.makePayment(1000);
        assertTrue(result);
    }

    @Test
    public void payment_is_wrong() {
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
        boolean result = paymentProcessor.makePayment(1000);
        assertFalse(result);
    }



}
