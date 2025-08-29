package com.example.demo.service;

import com.example.demo.domain.Aircraft;
import com.example.demo.domain.enums.Nation;
import com.example.demo.exception.AircraftNotFoundException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.AircraftRepository;
import com.example.demo.request.AircraftRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AircraftService {

    private final AircraftRepository repository;


    //    GET
    public List<Aircraft> showAircraftList() {
        List<Aircraft> aircraftList = repository.findAll();

        if (aircraftList.isEmpty()) {
            throw new AircraftNotFoundException("No aircrafts found in the system");
        }
//        aircraftList.stream().map(aircraft -> aircraft.getAircraftType())

        return aircraftList;
    }

    public List<Aircraft> getAircraftsByNation(Nation nation) {
        return repository.findByNation(nation);
    }

    public Aircraft getAircraftById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft not found with ID: " + id));
    }




        //    CREATE
        public Aircraft createAircraft(AircraftRequest request) {
            Aircraft aircraft = new Aircraft();
            aircraft.setName(request.getName());
            aircraft.setNation(request.getNation());
            aircraft.setAircraftType(request.getAircraftType());
            aircraft.setManufacturer(request.getManufacturer());
            aircraft.setFirstFlight(request.getFirstFlight());
            aircraft.setMaxSpeed(request.getMaxSpeed());
            aircraft.setFlyingRange(request.getFlyingRange());
            aircraft.setArmament(request.getArmament());
            aircraft.setCrewSize(request.getCrewSize());
            aircraft.setServiceStart(request.getServiceStart());
            aircraft.setServiceEnd(request.getServiceEnd());

            return repository.save(aircraft);
        }



        //    UPDATE
    public Aircraft updateAircraftInfo(AircraftRequest request, Long id) {
        Aircraft aircraftToBeChanged = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft with ID " + id + " not found"));

        aircraftToBeChanged.setName(request.getName());
        aircraftToBeChanged.setNation(request.getNation());
        aircraftToBeChanged.setAircraftType(request.getAircraftType());
        aircraftToBeChanged.setManufacturer(request.getManufacturer());
        aircraftToBeChanged.setFirstFlight(request.getFirstFlight());
        aircraftToBeChanged.setMaxSpeed(request.getMaxSpeed());
        aircraftToBeChanged.setFlyingRange(request.getFlyingRange());
        aircraftToBeChanged.setArmament(request.getArmament());
        aircraftToBeChanged.setCrewSize(request.getCrewSize());
        aircraftToBeChanged.setServiceStart(request.getServiceStart());
        aircraftToBeChanged.setServiceEnd(request.getServiceEnd());

        return repository.save(aircraftToBeChanged);
    }

//    DELETE
public void deleteAircraft(Long id) {
    Optional<Aircraft> aircraftToBeRemoved = repository.findById(id);

    // Lança exceção personalizada se o avião não for encontrado
    aircraftToBeRemoved.orElseThrow(() -> new AircraftNotFoundException("Aircraft with id " + id + " not found."));

    // Caso contrário, realiza a exclusão
    repository.delete(aircraftToBeRemoved.get());
}



}
