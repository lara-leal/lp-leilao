package lp.leilao.controllers.devices;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.devices.NotebookDTO;
import lp.leilao.entities.devices.Notebook;
import lp.leilao.services.devices.NotebookService;

@Controller("/devices/notebooks")
public class NotebookController {

    @Inject
    private final NotebookService noteService;

    public NotebookController(NotebookService noteService) {
        this.noteService = noteService;
    }

    @Get("/list")
    public Iterable<NotebookDTO> listNotebooks() {
        return noteService.getAllNote();
    }

    @Get("/{id}")
    public NotebookDTO getNotebook(Long id) {

        return noteService.getNoteById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public NotebookDTO createNotebook(@Body @Valid Notebook notebook) {

        return noteService.createNote(notebook);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteNotebook(Long id) {
        noteService.deleteNote(id);
    }
}
