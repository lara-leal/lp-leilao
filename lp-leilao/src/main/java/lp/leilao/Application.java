package lp.leilao;

import io.micronaut.runtime.Micronaut;
import io.micronaut.serde.annotation.SerdeImport;
import lp.leilao.entities.DispositivoInformatica;
import lp.leilao.entities.Notebook;

public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

}