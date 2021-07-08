package com.plugchecker.backend.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlugRepository extends JpaRepository<Plug, Integer> {
    List<Plug> findByElectricity(Boolean electricity);
    Optional<Plug> findByName(String name);
}
