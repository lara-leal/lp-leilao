package lp.leilao.exceptions.handler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lp.leilao.exceptions.InvalidCategoryException;
import lp.leilao.exceptions.InvalidStatusFromRegister;

@Singleton
@Requires(classes = {InvalidCategoryException.class, ExceptionHandler.class})
public class InvalidCategoryExceptionHandler implements ExceptionHandler<InvalidStatusFromRegister, HttpResponse>{
    @Override
    public HttpResponse handle(HttpRequest request, InvalidStatusFromRegister exception) {
        return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE, "The auction cannot receive new product with this category");
    }
}
