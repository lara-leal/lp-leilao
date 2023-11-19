package lp.leilao.exceptions.handler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lp.leilao.exceptions.NoInstitutionFinancialFindException;

@Singleton
@Requires(classes = {NoInstitutionFinancialFindException.class, ExceptionHandler.class})
public class NoInstitutionFinancialFindExceptionHandler
        implements ExceptionHandler<NoInstitutionFinancialFindException, HttpResponse>{
    @Override
    public HttpResponse handle(HttpRequest request, NoInstitutionFinancialFindException exception) {
        return HttpResponse.status(HttpStatus.NOT_ACCEPTABLE).body(
                "Financial Institution specify is not available");
    }
}
