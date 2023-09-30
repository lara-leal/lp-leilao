package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.DispositivoInformaticaDTO;
import lp.leilao.entities.devices.Notebook;
import lp.leilao.services.NotebookService;

@Controller("/dispositivos/notebooks")
public class NotebookController {

    @Inject
    private final NotebookService noteService;

    public NotebookController(NotebookService noteService) {
        this.noteService = noteService;
    }

    @Get("/list")
    public Iterable<DispositivoInformaticaDTO> listarNotebooks() {
        return noteService.getAllNote();
    }

    @Get("/{id}")
    public DispositivoInformaticaDTO getNotebook(Long id) {

        return noteService.getNoteById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public DispositivoInformaticaDTO criarNotebook(@Body @Valid Notebook notebook) {
        return noteService.createNote(notebook);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deletarDispositivo(Long id) {
        noteService.deleteNote(id);
    }
}
