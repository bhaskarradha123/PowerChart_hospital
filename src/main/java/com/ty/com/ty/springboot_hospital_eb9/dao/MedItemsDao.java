package com.ty.com.ty.springboot_hospital_eb9.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.com.ty.springboot_hospital_eb9.dto.MedItems;
import com.ty.com.ty.springboot_hospital_eb9.dto.MedOrder;
import com.ty.com.ty.springboot_hospital_eb9.repository.MedItemsRepository;
@Repository
public class MedItemsDao {

	@Autowired
	private MedItemsRepository medItemsRepository;
	@Autowired
	private MedOrderDao dao;
	
	public MedItems saveMedItems(MedItems medItems)
	{
		return medItemsRepository.save(medItems);
	}
	public MedItems updateMedItems(int id, MedItems medItems)
	{
		
		if(medItemsRepository.findById( id).isPresent())
		{
			medItems.setId(id);
			return medItemsRepository.save(medItems);
		}else {
			return null;
		}
		
	}
	
	public MedItems deleteMedItems(int id)
	{
		if(medItemsRepository.findById( id).isPresent())
		{
			MedItems medItems=medItemsRepository.findById(id).get();
			 medItemsRepository.delete(medItems);
			return medItems;
		}
		else {
			return null;
		}
	}
	
	public MedItems getMEdItemsById(int id)
	{
		if(medItemsRepository.findById( id).isPresent())
		{
			MedItems medItems=medItemsRepository.findById(id).get();
			return medItems;
		}
		else {
			return null;
		}
	}
	
	public List<MedItems> getAllMedItemsByMedOrderId(int id)
	{
		MedOrder order=dao.getMedOrderById(id);
		if(order!=null) {
			return medItemsRepository.getMedItemsByMedOrderId(order);
		}
		return null;
	}
	
	
	

	
	
}
