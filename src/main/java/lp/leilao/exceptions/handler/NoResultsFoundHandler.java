package lp.leilao.exceptions.handler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lp.leilao.exceptions.NoResultsFound;

@Singleton
@Requires(classes = {NoResultsFound.class, ExceptionHandler.class})
public class NoResultsFoundHandler implements ExceptionHandler<NoResultsFound, HttpResponse> {
    @Override
    public HttpResponse handle(HttpRequest request, NoResultsFound exception) {
        return HttpResponse.noContent().body("Results were not found");
    }
}
