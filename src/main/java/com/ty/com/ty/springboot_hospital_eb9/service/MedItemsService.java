package com.ty.com.ty.springboot_hospital_eb9.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByMedItemsException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByMedOrderException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.NoSuchElementFoundByMedItemsException;
import com.ty.com.ty.springboot_hospital_eb9.dao.MedItemsDao;
import com.ty.com.ty.springboot_hospital_eb9.dao.MedOrderDao;
import com.ty.com.ty.springboot_hospital_eb9.dto.MedItems;
import com.ty.com.ty.springboot_hospital_eb9.dto.MedOrder;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;

@Service
public class MedItemsService {
	

	@Autowired
	private MedItemsDao dao;
	@Autowired
	private MedOrderDao orderDao;
	
	public ResponseEntity<ResponseStructure< MedItems>> saveMedItems(MedItems medItems,int id)
	{   MedOrder order=orderDao.getMedOrderById(id);
	if(order!=null) {
     	medItems.setOrder(order);
		ResponseStructure<MedItems> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("MedItems Is Saved Sucessfully");
		responseStructure.setStatus( HttpStatus.CREATED.value());
		responseStructure.setData( dao.saveMedItems(medItems));
		return new ResponseEntity<ResponseStructure<MedItems>> (responseStructure,HttpStatus.CREATED);	
	}
	else
	{
		throw new IdNotFoundByMedOrderException("pls provide correct medorder id "+id+" to save the medItems");
	}
	}
	public ResponseEntity< ResponseStructure< MedItems>> updateMedItems(int id, MedItems medItems)
	{
		MedItems  dbmedItems=dao.updateMedItems(id, medItems);
		ResponseStructure< MedItems> responseStructure=new ResponseStructure<>();
		if( dbmedItems!= null) {
			
			responseStructure.setMessage("Sucessfully MedItems is Update");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(medItems);
			return new ResponseEntity< ResponseStructure< MedItems>> (responseStructure, HttpStatus.OK);
		}else {
			 throw new IdNotFoundByMedItemsException("pls provide correct meditems id "+id+" to save the medItems");
	}
	}
	
	public ResponseEntity< ResponseStructure< MedItems>> deleteMedItems(int id)
	{ MedItems  dbmedItems=dao.deleteMedItems(id);

		ResponseStructure< MedItems> responseStructure=new ResponseStructure<>();
		if(dbmedItems != null) {
			
			responseStructure.setMessage("Sucessfully MedItems is deleted");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(dbmedItems);
			return new ResponseEntity< ResponseStructure< MedItems>> (responseStructure, HttpStatus.OK);
		}else {
			 throw new IdNotFoundByMedItemsException("pls provide correct meditems id "+id+" to delete the medItems");
	}
	}
	
	public ResponseEntity< ResponseStructure< MedItems>> getMedItemsById(int id)
	{
		MedItems  dbmedItems=dao.getMEdItemsById(id);
		ResponseStructure< MedItems> responseStructure=new ResponseStructure<>();
		if(dbmedItems != null) {
			
			responseStructure.setMessage("Sucessfully MedItems  is Found");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(dbmedItems);
			return new ResponseEntity< ResponseStructure< MedItems>> (responseStructure, HttpStatus.OK);
		}else {
			 throw new  NoSuchElementFoundByMedItemsException("pls provide correct meditems id "+id+" to display the medItems");
	}
		 
	}
	
	
	
	public ResponseEntity<ResponseStructure<List<MedItems>>> getMedItemsByMedORder(int id) {
		 
		List<MedItems> list=dao.getAllMedItemsByMedOrderId(id);
		if( list != null)
		{
			ResponseStructure<List<MedItems>> structure = new ResponseStructure<List<MedItems>>();
		
			structure.setMessage("Sucessfully MedORder  is Found ");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<MedItems>>>(structure, HttpStatus.OK);
			
		}
		else {
			throw new IdNotFoundByMedOrderException("id not found for medorder of id "+id);
		}
	}
	
	
	

}
