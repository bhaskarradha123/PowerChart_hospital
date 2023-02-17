package com.ty.com.ty.springboot_hospital_eb9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.com.ty.springboot_hospital_eb9.dto.Encounter;

public interface EncounterRepository extends JpaRepository< Encounter, Integer> {

}
