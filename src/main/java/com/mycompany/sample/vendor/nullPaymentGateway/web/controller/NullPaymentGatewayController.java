
package com.mycompany.sample.vendor.nullPaymentGateway.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration;
import org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponseService;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.sample.vendor.nullPaymentGateway.service.payment.NullPaymentGatewayConstants;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller("blNullPaymentGatewayController")
@RequestMapping("/" + NullPaymentGatewayController.GATEWAY_CONTEXT_KEY)
public class NullPaymentGatewayController extends PaymentGatewayAbstractController {

    protected static final Log LOG = LogFactory.getLog(NullPaymentGatewayController.class);
    protected static final String GATEWAY_CONTEXT_KEY = "null-checkout";

    @Resource(name = "blNullPaymentGatewayWebResponseService")
    protected PaymentGatewayWebResponseService paymentGatewayWebResponseService;

    @Resource(name = "blNullPaymentGatewayConfiguration")
    protected PaymentGatewayConfiguration paymentGatewayConfiguration;

    @Override
    public void handleProcessingException(Exception e, RedirectAttributes redirectAttributes) throws PaymentException {
        redirectAttributes.addAttribute(PAYMENT_PROCESSING_ERROR, getProcessingErrorMessage());
    }

    @Override
    public void handleUnsuccessfulTransaction(Model model, RedirectAttributes redirectAttributes,
                                              PaymentResponseDTO responseDTO) throws PaymentException {
        redirectAttributes.addAttribute(PAYMENT_PROCESSING_ERROR,
                responseDTO.getResponseMap().get(NullPaymentGatewayConstants.RESULT_MESSAGE));
    }

    @Override
    public String getGatewayContextKey() {
        return GATEWAY_CONTEXT_KEY;
    }

    @Override
    public PaymentGatewayWebResponseService getWebResponseService() {
        return paymentGatewayWebResponseService;
    }

    @Override
    public PaymentGatewayConfiguration getConfiguration() {
        return paymentGatewayConfiguration;
    }

    @Override
    @RequestMapping(value = "/return", method = RequestMethod.POST)
    public String returnEndpoint(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes,
                                 Map<String, String> pathVars) throws PaymentException {
        return super.process(model, request, redirectAttributes);
    }

    @Override
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorEndpoint(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes,
                                Map<String, String> pathVars) throws PaymentException {
        redirectAttributes.addAttribute(PAYMENT_PROCESSING_ERROR,
                request.getParameter(PAYMENT_PROCESSING_ERROR));
        return getOrderReviewRedirect();
    }


}
