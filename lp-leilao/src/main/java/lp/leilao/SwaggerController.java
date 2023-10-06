package lp.leilao;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.Hidden;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@Hidden
public class SwaggerController {

    @Get("/swagger")
    public String getSwaggerJson() throws IOException {
        String swaggerFilePath = "target/classes/META-INF/swagger/swagger.yml";

        return new String(Files.readAllBytes(Paths.get(swaggerFilePath)));
    }
}
