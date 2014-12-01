
package com.mycompany.sample.vendor.nullPaymentGateway.service.payment;

import org.broadleafcommerce.common.payment.PaymentGatewayType;

public class NullPaymentGatewayType extends PaymentGatewayType {

    public static final PaymentGatewayType NULL_GATEWAY  = new PaymentGatewayType("NULL_GATEWAY", "Null Payment Gateway Implementation");
    public static final PaymentGatewayType NULL_HOSTED_GATEWAY  = new PaymentGatewayType("NULL_HOSTED_GATEWAY", "Null Hosted Payment Gateway Implementation");


}
