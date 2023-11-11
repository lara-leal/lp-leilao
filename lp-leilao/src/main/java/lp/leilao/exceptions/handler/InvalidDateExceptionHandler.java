package lp.leilao.exceptions.handler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lp.leilao.exceptions.InvalidDateException;


@Singleton
@Requires(classes = {InvalidDateException.class, ExceptionHandler.class})
public class InvalidDateExceptionHandler implements ExceptionHandler<InvalidDateException, HttpResponse> {
    @Override
    public HttpResponse handle(HttpRequest request, InvalidDateException exception) {
        return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE, "The date specify is not valid");
    }
}
