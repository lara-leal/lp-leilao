package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Switch;
import lp.leilao.repositories.SwitchRepository;

@Singleton
public class SwitchService {
    @Inject
    private final SwitchRepository switchRepository;

    public SwitchService(SwitchRepository switchRepository) {
        this.switchRepository = switchRepository;
    }

    public Iterable<Switch> getAllSwitches() {
        return switchRepository.findAll();
    }

    public Switch getSwitchById(Long id) {
        return switchRepository.findById(id).orElse(null);
    }

    public Switch createSwitch(Switch switches) {
        return switchRepository.save(switches);
    }
    public void deleteSwitch(Long id) {
        switchRepository.deleteById(id);
    }
}
