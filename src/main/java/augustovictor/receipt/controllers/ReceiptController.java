package augustovictor.receipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReceiptController {

    @RequestMapping({"", "/", "/index"})
    public String getIndex() {
        System.out.println("All good..");
        return "index";
    }
}
