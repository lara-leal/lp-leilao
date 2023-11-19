package lp.leilao.exceptions.handler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

import lp.leilao.exceptions.ImpossibleDeleteAuctionProductsRegisted;
import lp.leilao.exceptions.InvalidBidException;

@Singleton
@Requires(classes = {InvalidBidException.class, ExceptionHandler.class})
public class InvalidBidExceptionHandler
        implements ExceptionHandler<InvalidBidException, HttpResponse>{
    @Override
    public HttpResponse handle(HttpRequest request, InvalidBidException exception) {
        return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE).body("The bid cannot be lower than the initial bid");
    }
}
