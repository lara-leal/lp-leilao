package lp.leilao.services.devices;

import jakarta.inject.Singleton;

@Singleton
public class MonitorService {
//    private final MonitorRepository monitorRepository;
//
//    private final AuctionService auctionService;
//
//    @Inject
//    public MonitorService(MonitorRepository monitorRepository, AuctionService auctionService) {
//        this.monitorRepository = monitorRepository;
//        this.auctionService = auctionService;
//    }
//
//    public List<Monitor> getAllMonitor() {
//        try {
//            List<Monitor> monitor = monitorRepository.findAll();
//            if (monitor.isEmpty()){
//                throw new NoResultsFound();
//            }
//            return monitor;
//        } catch (NoResultsFound e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public Monitor getMonitorById(Long id) {
//        try {
//            return monitorRepository.findById(id)
//                    .orElseThrow(NoResultException::new);
//        }catch (RuntimeException e) {
//            throw new NoResultsFound();
//        }
//    }
//
//    public void createMonitor(Monitor monitor) {
//        try{
//            //auctionService.getAuctionById(null);
//            monitorRepository.save(monitor);
//        }catch (RuntimeException e) {
//            throw new NoAuctionFoundException();
//        }
//
//    }
//
//    public void updateMonitor(Long id, Monitor updatedMonitor) {
//        try {
//            Monitor existingMonitor = monitorRepository.findById(id).orElseThrow(NoResultsFound::new);
//            updateMapper(existingMonitor, updatedMonitor);
//
//            monitorRepository.update(existingMonitor);
//        }catch (RuntimeException e){
//            throw new NoResultsFound();
//        }
//    }
//
//    public void deleteMonitor(Long id) {
//        try{
//            monitorRepository.deleteById(id);
//        }catch (FailDeleteException e){
//            throw new RuntimeException() ;
//        }
//    }
//
//
//
//    private Monitor updateMapper(Monitor existingMonitor, Monitor monitor) {
//        try {
//            existingMonitor.setRefreshRate(monitor.getRefreshRate() != null ? monitor.getRefreshRate() : existingMonitor.getRefreshRate());
//            existingMonitor.setScreenSize(monitor.getScreenSize() != null ? monitor.getScreenSize()  : existingMonitor.getScreenSize());
//
//            return existingMonitor;
//        }catch (RuntimeException e){
//            throw new UpdateObjectException();
//        }
//
//    }
}
