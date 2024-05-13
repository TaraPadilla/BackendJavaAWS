package org.tarapadilla.Repository;

public interface IPaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
