package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.DispositivoInformaticaDTO;
import lp.leilao.entities.devices.Notebook;
import lp.leilao.repositories.NotebookRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class NotebookService {
    @Inject
    private final NotebookRepository noteRepository;

    public NotebookService(NotebookRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Iterable<DispositivoInformaticaDTO> getAllNote() {
        return toDispositivoInformaticaDTOList(noteRepository.findAll());
    }

    public DispositivoInformaticaDTO getNoteById(Long id) {
        return noteRepository.findById(id)
                .map(this::toDispositivoInformaticaDTO)
                .orElse(null);
    }

    public DispositivoInformaticaDTO createNote(Notebook notebook) {
        return toDispositivoInformaticaDTO(noteRepository.save(notebook));
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    private DispositivoInformaticaDTO toDispositivoInformaticaDTO(Notebook notebook) {
        DispositivoInformaticaDTO dto = new DispositivoInformaticaDTO();
        dto.setSpecification(notebook.getSpecification());
        return dto;
    }

    private Iterable<DispositivoInformaticaDTO> toDispositivoInformaticaDTOList(Iterable<Notebook> notebooks) {
        List<DispositivoInformaticaDTO> dtos = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            dtos.add(toDispositivoInformaticaDTO(notebook));
        }
        return dtos;
    }
}
