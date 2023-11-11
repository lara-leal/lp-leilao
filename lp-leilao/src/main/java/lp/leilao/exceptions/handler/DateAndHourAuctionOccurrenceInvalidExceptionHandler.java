package lp.leilao.exceptions.handler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lp.leilao.exceptions.DateAndHourAuctionOccurrenceInvalidException;

@Singleton
@Requires(classes = {DateAndHourAuctionOccurrenceInvalidException.class, ExceptionHandler.class})
public class DateAndHourAuctionOccurrenceInvalidExceptionHandler
        implements ExceptionHandler<DateAndHourAuctionOccurrenceInvalidException, HttpResponse>{
    @Override
    public HttpResponse handle(HttpRequest request, DateAndHourAuctionOccurrenceInvalidException exception) {
        return HttpResponse.status(HttpStatus.BAD_REQUEST,
                "It was not possible to register an auction in this hour and day");
    }
}
