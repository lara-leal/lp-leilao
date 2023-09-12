package lp.leilao;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class hellocontroller {

    @Get("/message")
    public String message(){return "finalmente puta";}
}
