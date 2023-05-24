package org.aoizora.controller;

import lombok.extern.slf4j.Slf4j;
import org.aoizora.model.tacos.TacoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/order")
@SessionAttributes("tacoOrder")
public class OrderController
{
    @GetMapping("/current")
    public String orderForm()
    {
        return "order";
    }

    @PostMapping
    public String processOrder(TacoOrder order, SessionStatus sessionStatus)
    {
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
