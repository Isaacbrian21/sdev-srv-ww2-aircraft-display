package com.example.demo.repositories;

import com.example.demo.domain.Aircraft;
import com.example.demo.domain.enums.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long>  {

    List<Aircraft> findByNation(Nation nation);

}
