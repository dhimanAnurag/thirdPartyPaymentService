package com.dhiman.paymentserviceaugust25mfweve.controller;

import com.dhiman.paymentserviceaugust25mfweve.dtos.CreatePaymentLinkRequestDto;
import com.dhiman.paymentserviceaugust25mfweve.services.PaymentService;
import com.razorpay.RazorpayException;
import com.razorpay.Webhook;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String createPaymentLink(CreatePaymentLinkRequestDto request) throws RazorpayException {
        String link = paymentService.createPaymentLink(request.getOrderId());
        return link;
    }

    @PostMapping("/webhook")
    public void handleWebhookEvent(@RequestBody Webhook webhook) {
        System.out.println(webhook.toString());
    }
}
