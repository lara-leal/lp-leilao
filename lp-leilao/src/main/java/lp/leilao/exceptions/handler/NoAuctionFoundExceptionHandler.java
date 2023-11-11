package lp.leilao.exceptions.handler;


import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lp.leilao.exceptions.NoAuctionFoundException;

@Singleton
@Requires(classes = {NoAuctionFoundException.class, ExceptionHandler.class})
public class NoAuctionFoundExceptionHandler implements ExceptionHandler<NoAuctionFoundException, HttpResponse> {
    @Override
    public HttpResponse handle(HttpRequest request, NoAuctionFoundException exception) {
        return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE, "The auction id inform is invalid," +
                " is necessary an auction_id valid to register a product");
    }
}
