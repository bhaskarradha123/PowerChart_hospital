package com.ty.com.ty.springboot_hospital_eb9.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByBranchException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByEncounterException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByPersonException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.NoSuchElementFoundByEncounterlException;
import com.ty.com.ty.springboot_hospital_eb9.dao.BranchDao;
import com.ty.com.ty.springboot_hospital_eb9.dao.EncounterDao;
import com.ty.com.ty.springboot_hospital_eb9.dao.PersonDao;
import com.ty.com.ty.springboot_hospital_eb9.dto.Branch;
import com.ty.com.ty.springboot_hospital_eb9.dto.Encounter;
import com.ty.com.ty.springboot_hospital_eb9.dto.Person;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterDao;

	@Autowired
	private PersonDao personDao;
	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {
		Person person = personDao.getPersonById(pid);
		Branch branch = branchDao.getBranchById(bid);
		if (person != null ) {
			
			if(branch!=null) {
				encounter.setPerson(person);

				List<Branch> list = new ArrayList<>();
				list.add(branch);
				encounter.setBranches(list);

				ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
				responseStructure.setMessage("saved Encounter");
				responseStructure.setStatus(HttpStatus.CREATED.value());
				responseStructure.setData(encounterDao.saveEncounter(encounter));

				return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.CREATED);
			} 
			else {
				throw new IdNotFoundByBranchException("Pls check the branch id "+bid+" is save the enconter");
			}
			
			
			
		}
		else
		{
			throw new  IdNotFoundByPersonException("Pls check the person id "+pid+" is save the encounter");
		}
}
			
	

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter, int eid, int bid) {

		Encounter encounterdb = encounterDao.getEncounterById(eid);
		Branch branch = branchDao.getBranchById(bid);
		if(encounterdb != null && branch != null) {
		List<Branch> list = encounterdb.getBranches();
		list.add(branch);
		encounter.setBranches(list);
		encounter.setPerson(encounterdb.getPerson());

		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		responseStructure.setMessage("Encounter is Updated");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(encounterDao.updateencounter(encounter, eid));

		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundByEncounterException("Pls check the encounter id "+eid+" is not exist to update");
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int eid) {
		Encounter encounter = encounterDao.deleteEncounter(eid);
		if (encounter != null) {
			ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
			responseStructure.setMessage("Encounter is Deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByEncounterException("Pls check the encounter id "+eid+" is not exist to delete");
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int eid) {
		Encounter encounter = encounterDao.getEncounterById(eid);
		if (encounter != null) {
			ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
			responseStructure.setMessage("Encounter is found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else {
			throw new  NoSuchElementFoundByEncounterlException("Pls check the encounter id "+eid+" is not exist to display");
		}
	}

}
