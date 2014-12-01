
package com.mycompany.sample.vendor.nullPaymentGateway.web.controller;

import com.mycompany.sample.payment.service.gateway.NullPaymentGatewayHostedConfiguration;
import com.mycompany.sample.vendor.nullPaymentGateway.service.payment.NullPaymentGatewayConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller("blNullPaymentGatewayHostedProcessorController")
public class NullPaymentGatewayHostedProcessorController {

    @Resource(name = "blNullPaymentGatewayHostedConfiguration")
    protected NullPaymentGatewayHostedConfiguration paymentGatewayConfiguration;

    @RequestMapping(value = "/hosted/null-checkout", method = RequestMethod.POST)
    public @ResponseBody String retrieveHostedEndpoint(HttpServletRequest request){

        Map<String,String[]> paramMap = request.getParameterMap();

        String transactionAmount = "";
        String orderId="";
        String completeCheckoutOnCallback = "true";
        String resultMessage = "Hosted Call Successful";

        if (paramMap.get(NullPaymentGatewayConstants.TRANSACTION_AMT) != null
                && paramMap.get(NullPaymentGatewayConstants.TRANSACTION_AMT).length > 0) {
            transactionAmount = paramMap.get(NullPaymentGatewayConstants.TRANSACTION_AMT)[0];
        }

        if (paramMap.get(NullPaymentGatewayConstants.ORDER_ID) != null
                && paramMap.get(NullPaymentGatewayConstants.ORDER_ID).length > 0) {
            orderId = paramMap.get(NullPaymentGatewayConstants.ORDER_ID)[0];
        }

        if (paramMap.get(NullPaymentGatewayConstants.COMPLETE_CHECKOUT_ON_CALLBACK) != null
                && paramMap.get(NullPaymentGatewayConstants.COMPLETE_CHECKOUT_ON_CALLBACK).length > 0) {
            completeCheckoutOnCallback = paramMap.get(NullPaymentGatewayConstants.COMPLETE_CHECKOUT_ON_CALLBACK)[0];
        }

        StringBuffer response = new StringBuffer();
        response.append("<!DOCTYPE HTML>");
        response.append("<body>");
        response.append("<h1>Mock Hosted Checkout</h1>");
        response.append("<p>NullPayment 3rd party integration.</p>");
        response.append("<form action=\"" +
                paymentGatewayConfiguration.getHostedRedirectReturnUrl() +
                "\" method=\"GET\" id=\"NullPaymentGatewayRedirectForm\" name=\"NullPaymentGatewayRedirectForm\">");
        response.append("<input type=\"hidden\" name=\"" + NullPaymentGatewayConstants.TRANSACTION_AMT
                +"\" value=\"" + transactionAmount + "\"/>");
        response.append("<input type=\"hidden\" name=\"" + NullPaymentGatewayConstants.ORDER_ID
                +"\" value=\"" + orderId + "\"/>");
        response.append("<input type=\"hidden\" name=\"" + NullPaymentGatewayConstants.COMPLETE_CHECKOUT_ON_CALLBACK
                +"\" value=\"" + completeCheckoutOnCallback + "\"/>");
        response.append("<input type=\"hidden\" name=\"" + NullPaymentGatewayConstants.RESULT_MESSAGE
                +"\" value=\"" + resultMessage + "\"/>");

        response.append("<input type=\"submit\" value=\"Please Click Here To Complete Checkout\"/>");
        response.append("</form>");
        response.append("</body>");
        response.append("</html>");

        return response.toString();
    }
}
