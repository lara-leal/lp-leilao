package lp.leilao.exceptions.handler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lp.leilao.exceptions.FailDeleteException;


@Singleton
@Requires(classes = {FailDeleteException.class, ExceptionHandler.class})
public class FailDeleteExceptionHandler implements ExceptionHandler<FailDeleteException, HttpResponse> {
    @Override
    public HttpResponse handle(HttpRequest request, FailDeleteException exception) {
        return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR,
                "It was not possible to proceed with the deletion");
    }
}
