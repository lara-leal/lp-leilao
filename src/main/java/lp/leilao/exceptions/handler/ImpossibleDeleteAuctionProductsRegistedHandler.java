package lp.leilao.exceptions.handler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lp.leilao.exceptions.ImpossibleDeleteAuctionProductsRegisted;

@Singleton
@Requires(classes = {ImpossibleDeleteAuctionProductsRegisted.class, ExceptionHandler.class})
public class ImpossibleDeleteAuctionProductsRegistedHandler
        implements ExceptionHandler<ImpossibleDeleteAuctionProductsRegisted, HttpResponse> {
    @Override
    public HttpResponse handle(HttpRequest request, ImpossibleDeleteAuctionProductsRegisted exception) {
        return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE,
                "It was not possible to delete auction because they have products registered," +
                        " the auction status has been changed to inactive");
    }
}
