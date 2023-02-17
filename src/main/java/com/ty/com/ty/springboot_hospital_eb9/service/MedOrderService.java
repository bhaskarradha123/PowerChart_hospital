package com.ty.com.ty.springboot_hospital_eb9.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByEncounterException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByMedOrderException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.NullPointerExceptionByMedORder;
import com.ty.com.ty.springboot_hospital_eb9.dao.EncounterDao;
import com.ty.com.ty.springboot_hospital_eb9.dao.MedOrderDao;
import com.ty.com.ty.springboot_hospital_eb9.dto.Encounter;
import com.ty.com.ty.springboot_hospital_eb9.dto.MedOrder;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;

@Service
public class MedOrderService {
	@Autowired
	private MedOrderDao medOrderDao;
	@Autowired
	private EncounterDao dao;

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder order, int eid)

	{

		Encounter encounterDao = dao.getEncounterById(eid);
        if(encounterDao!=null) {
		order.setEncounter(encounterDao);
		MedOrder medorder = medOrderDao.saveMedOrder(order);

		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("saved  Medorder Sucessfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(medOrderDao.saveMedOrder(medorder));
		return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.CREATED);
        }
        else
        	throw new IdNotFoundByEncounterException("Pls check the encounter id "+eid+" is save the medorder");
	}

	
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int id, MedOrder medOrder) {
		MedOrder medOrder2 = medOrderDao.getMedOrderById(id);
		if (medOrder2 != null) {
		medOrder.setEncounter(medOrder2.getEncounter());

		MedOrder updateMedOrder = medOrderDao.updateMedOrder(id, medOrder);

		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
	

			responseStructure.setMessage("Sucessfully MedOrder is Update");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(updateMedOrder);
			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.OK);
		} else {
			
			throw new  NullPointerExceptionByMedORder("pls check the medorder id");
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(int id) {
		MedOrder order = medOrderDao.deleteMedOrder(id);

		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
		if (order != null) {

			responseStructure.setMessage("Sucessfully MedOrder is deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(order);
			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByMedOrderException("pls check the medorder id "+id+"to delete");
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int id) {
		MedOrder order = medOrderDao.getMedOrderById(id);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
		if (order != null) {

			responseStructure.setMessage("Sucessfully MedOrder  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(order);
			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByMedOrderException("pls check the medorder id "+id+"to display");
		}

	}

}
