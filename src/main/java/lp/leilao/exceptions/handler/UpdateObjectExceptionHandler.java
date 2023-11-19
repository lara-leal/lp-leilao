package lp.leilao.exceptions.handler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lp.leilao.exceptions.UpdateObjectException;

@Singleton
@Requires(classes = {UpdateObjectException.class, ExceptionHandler.class})
public class UpdateObjectExceptionHandler implements ExceptionHandler<UpdateObjectException, HttpResponse>{

    @Override
    public HttpResponse handle(HttpRequest request, UpdateObjectException exception) {
        return HttpResponse.status(HttpStatus.NOT_MODIFIED, "Error during the object update");
    }
}
