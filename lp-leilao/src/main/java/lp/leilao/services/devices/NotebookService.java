package lp.leilao.services.devices;

import jakarta.inject.Singleton;

@Singleton
public class NotebookService {

//    private final NotebookRepository notebookRepository;
//
//    private final AuctionService auctionService;
//
//    @Inject
//    public NotebookService(NotebookRepository notebookRepository, AuctionService auctionService) {
//        this.notebookRepository = notebookRepository;
//        this.auctionService = auctionService;
//    }
//
//    public List<Notebook> getAllNotebook() {
//        try {
//            List<Notebook> notebooks = notebookRepository.findAll();
//            if (notebooks.isEmpty()){
//                throw new NoResultsFound();
//            }
//
//            return notebooks;
//        }catch (NoResultsFound e){
//            throw new RuntimeException();
//        }
//
//    }
//
//    public Notebook getNotebookById(Long id) {
//        try {
//            return notebookRepository.findById(id).orElseThrow(NoResultsFound::new);
//        }catch (NoResultsFound e){
//            throw new NoResultsFound();
//        }
//    }
//
//    public void createNote(Notebook notebook) {
//        try {
//            //TODO: AJUSTAR LOGICA DE VERIFICAÇÃO DE LEILAO EXISTENTE
//            Auction auction = auctionService.getAuctionById(null);
//
//            notebookRepository.save(notebook);
//        }catch (NoAuctionFoundException e){
//            throw new NoAuctionFoundException();
//        }
//    }
//
//    public void updateNotebook(Long id, Notebook updateNotebook) {
//        try {
//            Notebook existingNotebook = notebookRepository.findById(id).orElseThrow(NoResultsFound::new);
//            updateMapper(existingNotebook, updateNotebook);
//        }catch (RuntimeException e){
//            throw new RuntimeException();
//        }
//
//    }
//
//    public void deleteNote(Long id) {
//        try{
//            notebookRepository.deleteById(id);
//        }catch (FailDeleteException e){
//            throw new RuntimeException() ;
//        }
//    }
//
//
//    private Notebook updateMapper(Notebook existingNotebook, Notebook notebook) {
//        try {
//            existingNotebook.setBrand(notebook.getBrand() != null ? notebook.getBrand() : existingNotebook.getBrand());
//            existingNotebook.setSpecification(notebook.getSpecification() != null ?
//                    notebook.getSpecification()  : existingNotebook.getSpecification());
//            existingNotebook.setInitialValue(notebook.getInitialValue() != null ? notebook.getInitialValue() : existingNotebook.getInitialValue());
//
//            return existingNotebook;
//        }catch (RuntimeException e){
//            throw new UpdateObjectException();
//        }
//
//    }
}
