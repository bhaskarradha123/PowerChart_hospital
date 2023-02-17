package com.ty.com.ty.springboot_hospital_eb9.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.com.ty.springboot_hospital_eb9.dto.MedItems;
import com.ty.com.ty.springboot_hospital_eb9.dto.MedOrder;

public interface MedItemsRepository extends JpaRepository<MedItems, Integer> {
 
	@Query("select a from MedItems a where a.order=?1")
	public List<MedItems>getMedItemsByMedOrderId(MedOrder order);
	
}
