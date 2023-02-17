package com.ty.com.ty.springboot_hospital_eb9.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByAddressException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.NoSuchElementFoundByAddressException;
import com.ty.com.ty.springboot_hospital_eb9.dao.AddressDao;
import com.ty.com.ty.springboot_hospital_eb9.dto.Address;
 
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;

@Service
public class AddressService  {
	
	@Autowired
	private AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure< Address>> saveAddress(Address address)
	{
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setMessage("Address Is Saved Sucessfully");
		responseStructure.setStatus( HttpStatus.CREATED.value());
		responseStructure.setData( addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>> (responseStructure,HttpStatus.CREATED);	
	}
	public ResponseEntity< ResponseStructure< Address>> updateAddress(int id,  Address address)
	{
		Address addressdb =addressDao.updateAddress(id,  address);
		ResponseStructure< Address> responseStructure=new ResponseStructure<Address>();
		if(addressdb != null) {
			
			responseStructure.setMessage("Sucessfully Address is Update");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity< ResponseStructure< Address>> (responseStructure, HttpStatus.OK);
		}else {
			 throw new IdNotFoundByAddressException("Pls check the address id "+id+" is not exist to update");
	}
	}
	
	public ResponseEntity< ResponseStructure< Address>> deleteAddress(int id)
	{
		Address addressdb =addressDao.deleteAddress(id);
		ResponseStructure< Address> responseStructure=new ResponseStructure<Address>();
		if(addressdb != null) {
			
			responseStructure.setMessage("Sucessfully Address is deleted");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(addressdb);
			return new ResponseEntity< ResponseStructure< Address>> (responseStructure, HttpStatus.OK);
		}else {
			 throw new IdNotFoundByAddressException("Pls check the address id "+id+" is not exist to delete");
	}
	}
	
	public ResponseEntity< ResponseStructure< Address>> getById(int id)
	{
		Address addressdb =addressDao.getById(id);
		ResponseStructure< Address> responseStructure=new ResponseStructure<Address>();
		if(addressdb != null) {
			
			responseStructure.setMessage("Sucessfully Address  is Found");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(addressdb);
			return new ResponseEntity< ResponseStructure< Address>> (responseStructure, HttpStatus.OK);
		}else {
			 throw new  NoSuchElementFoundByAddressException("Pls check the address id "+id+" is not exist to display");
	}
		 
	}
	
	
}
