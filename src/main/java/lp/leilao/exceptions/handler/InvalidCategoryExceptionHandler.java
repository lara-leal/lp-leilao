package lp.leilao.exceptions.handler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lp.leilao.exceptions.InvalidCategoryException;

@Singleton
@Requires(classes = {InvalidCategoryException.class, ExceptionHandler.class})
public class InvalidCategoryExceptionHandler implements ExceptionHandler<InvalidCategoryException, HttpResponse>{
    @Override
    public HttpResponse handle(HttpRequest request, InvalidCategoryException exception) {
        return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE)
                .body("This category is not valid");
    }
}
