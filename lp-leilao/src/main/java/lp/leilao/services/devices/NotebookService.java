package lp.leilao.services.devices;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.devices.NotebookDTO;
import lp.leilao.entities.devices.Notebook;
import lp.leilao.repositories.devices.NotebookRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class NotebookService {
    @Inject
    private final NotebookRepository noteRepository;

    public NotebookService(NotebookRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Iterable<NotebookDTO> getAllNote() {

        return toNotebookDTOList(noteRepository.findAll());
    }

    public NotebookDTO getNoteById(Long id) {
        return noteRepository.findById(id)
                .map(this::toNotebookDTO)
                .orElse(null);
    }

    public NotebookDTO createNote(Notebook notebook) {
        return toNotebookDTO(noteRepository.save(notebook));
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    private NotebookDTO toNotebookDTO(Notebook notebook) {
        NotebookDTO dto = new NotebookDTO();
        dto.setSpecification(notebook.getSpecification());
        return dto;
    }

    private Iterable<NotebookDTO> toNotebookDTOList(Iterable<Notebook> notebooks) {
        List<NotebookDTO> dtos = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            dtos.add(toNotebookDTO(notebook));
        }
        return dtos;
    }
}
