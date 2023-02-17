package com.ty.com.ty.springboot_hospital_eb9.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.com.ty.springboot_hospital_eb9.dto.Encounter;
import com.ty.com.ty.springboot_hospital_eb9.repository.EncounterRepository;

@Repository
public class EncounterDao {
	@Autowired
	private EncounterRepository encounterRepository;

	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepository.save(encounter);
	}

	public Encounter updateencounter(Encounter encounter, int eid) {
		encounter.setId(eid);
		return encounterRepository.save(encounter);
	}

	public Encounter deleteEncounter(int eid) {
		if (encounterRepository.findById(eid).isPresent()) {
			Encounter encounter = encounterRepository.findById(eid).get();
			encounterRepository.delete(encounter);
			return encounter;
		} else {
			return null;
		}
	}

	public Encounter getEncounterById(int eid) {

		if (encounterRepository.findById(eid).isPresent()) {
			Encounter encounter = encounterRepository.findById(eid).get();
			return encounter;
		} else {
			return null;
		}
	}

}
