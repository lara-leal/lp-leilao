package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.ComputingDeviceDTO;
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

    public Iterable<ComputingDeviceDTO> getAllNote() {
        return toComputingDeviceDTOList(noteRepository.findAll());
    }

    public ComputingDeviceDTO getNoteById(Long id) {
        return noteRepository.findById(id)
                .map(this::toComputingDeviceDTO)
                .orElse(null);
    }

    public ComputingDeviceDTO createNote(Notebook notebook) {
        return toComputingDeviceDTO(noteRepository.save(notebook));
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    private ComputingDeviceDTO toComputingDeviceDTO(Notebook notebook) {
        ComputingDeviceDTO dto = new ComputingDeviceDTO();
        dto.setSpecification(notebook.getSpecification());
        return dto;
    }

    private Iterable<ComputingDeviceDTO> toComputingDeviceDTOList(Iterable<Notebook> notebooks) {
        List<ComputingDeviceDTO> dtos = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            dtos.add(toComputingDeviceDTO(notebook));
        }
        return dtos;
    }
}
