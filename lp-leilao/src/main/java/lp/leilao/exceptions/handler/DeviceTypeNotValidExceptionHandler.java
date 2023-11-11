package lp.leilao.exceptions.handler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lp.leilao.exceptions.DateAndHourAuctionOccurrenceInvalidException;
import lp.leilao.exceptions.DeviceTypeNotValidException;

@Singleton
@Requires(classes = {DeviceTypeNotValidException.class, ExceptionHandler.class})
public class DeviceTypeNotValidExceptionHandler
        implements ExceptionHandler<DeviceTypeNotValidException, HttpResponse>{

    @Override
    public HttpResponse handle(HttpRequest request, DeviceTypeNotValidException exception) {
        return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE,
                "It was not possible to register a device with this category, inform a valid category");
    }
}
