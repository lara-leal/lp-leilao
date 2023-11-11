package lp.leilao.services.vehicles;

import jakarta.inject.Singleton;

@Singleton
public class UtilityVehicleService {
//    @Inject
//    private final UtilityVehicleRepository utilityVehicleRepository;

//    public UtilityVehicleService(UtilityVehicleRepository utilityVehicleRepository) {
//        this.utilityVehicleRepository = utilityVehicleRepository;
//    }
//
//    public Iterable<UtilityVehicleDTO> getAllUtilityVehicles() {
//        return toUtilityVehicleDTOList(utilityVehicleRepository.findAll());
//    }
//
//    public UtilityVehicleDTO getUtilityVehicleById(Long id) {
//        return utilityVehicleRepository.findById(id)
//                .map(this::toUtilityVehicleDTO)
//                .orElse(null);
//    }
//
//    public UtilityVehicleDTO createUtilityVehicle(UtilityVehicle utilityVehicle) {
//        return toUtilityVehicleDTO(utilityVehicleRepository.save(utilityVehicle));
//    }
//
//    public UtilityVehicleDTO updateUtilityVehicle(Long id, UtilityVehicleDTO updatedUtilityVehicleDTO) {
//        UtilityVehicle existingUtilityVehicle = utilityVehicleRepository.findById(id).orElse(null);
//        if (existingUtilityVehicle != null) {
//            existingUtilityVehicle.setBrand(updatedUtilityVehicleDTO.getBrand());
//            existingUtilityVehicle.setManufactureYear(updatedUtilityVehicleDTO.getManufactureYear());
//            existingUtilityVehicle.setModel(updatedUtilityVehicleDTO.getModel());
//            existingUtilityVehicle.setDescription(updatedUtilityVehicleDTO.getDescription());
//            existingUtilityVehicle.setColor(updatedUtilityVehicleDTO.getColor());
//            existingUtilityVehicle.setGroundClearance(updatedUtilityVehicleDTO.getGroundClearance());
//            existingUtilityVehicle.setTractionType(updatedUtilityVehicleDTO.getTractionType());
//
//            UtilityVehicle updatedUtilityVehicle = utilityVehicleRepository.update(existingUtilityVehicle);
//            return toUtilityVehicleDTO(updatedUtilityVehicle);
//        }
//        return null;
//    }
//
//    public void deleteUtilityVehicle(Long id) {
//        utilityVehicleRepository.deleteById(id);
//    }
//
//    private UtilityVehicleDTO toUtilityVehicleDTO(UtilityVehicle utilityVehicle) {
//        UtilityVehicleDTO dto = new UtilityVehicleDTO();
//        dto.setBrand(utilityVehicle.getBrand());
//        dto.setManufactureYear(utilityVehicle.getManufactureYear());
//        dto.setModel(utilityVehicle.getModel());
//        dto.setDescription(utilityVehicle.getDescription());
//        dto.setColor(utilityVehicle.getColor());
//        dto.setGroundClearance(utilityVehicle.getGroundClearance());
//        dto.setTractionType(utilityVehicle.getTractionType());
//
//        return dto;
//    }
//
//    private Iterable<UtilityVehicleDTO> toUtilityVehicleDTOList(Iterable<UtilityVehicle> utilitys) {
//        List<UtilityVehicleDTO> dtos = new ArrayList<>();
//        for (UtilityVehicle utility : utilitys) {
//            dtos.add(toUtilityVehicleDTO(utility));
//        }
//        return dtos;
//    }
}
