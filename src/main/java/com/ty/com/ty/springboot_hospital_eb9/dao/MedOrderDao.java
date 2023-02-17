package com.ty.com.ty.springboot_hospital_eb9.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.com.ty.springboot_hospital_eb9.dto.MedOrder;
import com.ty.com.ty.springboot_hospital_eb9.repository.MedOrderRepository;

@Repository
public class MedOrderDao {
	@Autowired
	private MedOrderRepository repository;
	
	
	public MedOrder saveMedOrder(MedOrder medOrder)
	{
		return repository.save(medOrder);
	}
	public MedOrder updateMedOrder(int id, MedOrder medORder)
	{ 
		 
	   
		if(repository.findById( id).isPresent())
		{
			medORder.setId(id);
			
			return repository.save(medORder);
		}else {
			return null;
		}
		
	}
	
	public MedOrder deleteMedOrder(int id)
	{
		if(repository.findById( id).isPresent())
		{
			MedOrder order=repository.findById(id).get();
			 repository.delete(order);
			return order;
		}
		else {
			return null;
		}
	}
	
	public MedOrder getMedOrderById(int id)
	{
		if(repository.findById( id).isPresent())
		{
			MedOrder order=repository.findById(id).get();
			return order;
		}
		else {
			return null;
		}
	}
	
	public List<MedOrder> getAllMedOrder()
	{
		return repository.findAll();
	}
	
	
	

}
