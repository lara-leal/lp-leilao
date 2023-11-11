package lp.leilao.services.devices;

import jakarta.inject.Singleton;

@Singleton
public class SwitchService {

//    private final SwitchRepository switchRepository;
//    private final AuctionService auctionService;
//
//    @Inject
//    public SwitchService(SwitchRepository switchRepository, AuctionService auctionService) {
//        this.switchRepository = switchRepository;
//        this.auctionService = auctionService;
//    }
//
//    public List<Switch> listSwitch() {
//        try {
//            List<Switch> switches = switchRepository.findAll();
//            if (switches.isEmpty()){
//                throw new NoResultsFound();
//            }
//            return switches;
//        } catch (NoResultsFound e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public Switch getSwitchById(Long id) {
//        try {
//            return switchRepository.findById(id)
//                    .orElseThrow(NoResultException::new);
//        }catch (RuntimeException e) {
//            throw new NoResultsFound();
//        }
//    }
//
//    public void createSwitch(Switch newSwitch) {
//        try{
//            auctionService.getAuctionById(null);
//            switchRepository.save(newSwitch);
//        }catch (RuntimeException e) {
//            throw new NoAuctionFoundException();
//        }
//
//    }
//
//    public void updateSwitch(Long id, Switch updatedSwitch) {
//        try {
//            Switch existingSwitch = switchRepository.findById(id).orElseThrow(NoResultsFound::new);
//            updateMapper(existingSwitch, updatedSwitch);
//
//            switchRepository.update(existingSwitch);
//        }catch (RuntimeException e){
//            throw new NoResultsFound();
//        }
//    }
//
//    public void deleteSwitch(Long id) {
//        try{
//            switchRepository.deleteById(id);
//        }catch (FailDeleteException e){
//            throw new RuntimeException() ;
//        }
//    }
//
//
//
//    private Switch updateMapper(Switch existingSwitch, Switch updateSwitch) {
//        try {
//            existingSwitch.setFirmwareVersion(updateSwitch.getFirmwareVersion() != null ?
//                    updateSwitch.getFirmwareVersion() : existingSwitch.getFirmwareVersion());
//            existingSwitch.setInitialValue(updateSwitch.getInitialValue() != null ?
//                    updateSwitch.getInitialValue()  : existingSwitch.getInitialValue());
//            existingSwitch.setDescription(updateSwitch.getDescription() != null ?
//                    updateSwitch.getDescription() : existingSwitch.getDescription());
//
//            return existingSwitch;
//        }catch (RuntimeException e){
//            throw new UpdateObjectException();
//        }
//
//    }

}
