package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Notebook;
import lp.leilao.repositories.NotebookRepository;

@Singleton
public class NotebookService {
    @Inject
    private final NotebookRepository noteRepository;

    public NotebookService(NotebookRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Iterable<Notebook> getAllNote() {
        return noteRepository.findAll();
    }

    public Notebook getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Notebook createNote(Notebook note) {
        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
