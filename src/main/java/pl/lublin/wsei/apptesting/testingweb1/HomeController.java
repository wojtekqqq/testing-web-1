package pl.lublin.wsei.apptesting.testingweb1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }

    @RequestMapping(value = "/calculate", method = GET)
    public @ResponseBody String calculate(
            @RequestParam("opcode") String opcode,
            @RequestParam("op1") String op1,
            @RequestParam("op2") String op2) {
        float result=0;
        try {
            String decodedOpcode = URLDecoder.decode(opcode, "UTF-8");
            String decodedOp1 = URLDecoder.decode(op1, "UTF-8");
            String decodedOp2 = URLDecoder.decode(op2, "UTF-8");

            if (decodedOpcode.equals("add")) {
                result = Float.parseFloat(decodedOp1) + Float.parseFloat(decodedOp2);
            } else if (decodedOpcode.equals("subtract")) {
                result = Float.parseFloat(decodedOp1) - Float.parseFloat(decodedOp2);
            } else if (decodedOpcode.equals("multiply")) {
                result = Float.parseFloat(decodedOp1) * Float.parseFloat(decodedOp2);
            } else if (decodedOpcode.equals("divide")) {
                result = Float.parseFloat(decodedOp1) / Float.parseFloat(decodedOp2);
            }
        } catch (UnsupportedEncodingException e) {
            // handle the exception
        }
        return "Wynik operacji:" + String.format("%.2f", result);
    }




}
