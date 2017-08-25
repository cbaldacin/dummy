package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/boleto-check")
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Greeting check(@RequestParam(value="numero_pedido", required=false, defaultValue="Stranger") String orderNumber,
            @RequestParam(value="token", required=true) String token) {
        return new Greeting(counter.incrementAndGet(), String.format(template, orderNumber+":"+token));
    }

}
