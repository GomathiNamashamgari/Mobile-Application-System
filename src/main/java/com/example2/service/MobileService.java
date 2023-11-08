package com.example2.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example2.model.Mobile;
import com.example2.repository.MobileRepository;


public class MobileService implements MobileRepository
{
	HashMap<Integer,Mobile> h1=new HashMap<Integer, Mobile>();
	int mid=5;
	
	
	public MobileService()
	{
		Mobile m1=new Mobile(1,"Realme","Realme.jpg");
		Mobile m2=new Mobile(2,"Oppo","Oppo.jpg");
		Mobile m3=new Mobile(3,"Iphone","Iphone.jpg");
		Mobile m4=new Mobile(4,"Vivo","Vivo.jpg");
		h1.put(m1.getId(), m1);
		h1.put(m2.getId(), m2);
		h1.put(m3.getId(), m3);
		h1.put(m4.getId(), m4);
	}

	@Override
	public ArrayList<Mobile> getMobiles()
	{
		ArrayList<Mobile> mobiles=new ArrayList<>(h1.values());
		return mobiles;
	}

	@Override
	public Mobile getMobileById(int mobileId)
	{
		Mobile mobile=h1.get(mobileId);
		if(mobile==null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return mobile;
	}
	
	@Override
	public Mobile addMobile(Mobile mobile)
	{
		mobile.setId(mid);
		h1.put(mid, mobile);
		mid=mid+1;
		return mobile;
	}

	@Override
	public Mobile updateMobile(int mobileId, Mobile mobile)
	{
		Mobile existingMobile=h1.get(mobileId);
		if(mobile==null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		if(mobile.getName()!=null)
		{
			existingMobile.setName(mobile.getName());
		}
		if(mobile.getImage()!=null)
		{
			existingMobile.setImage(mobile.getImage());
		}
		return existingMobile;
		
	}

	@Override
	public void deleteMobile(int mobileId) 
	{
		Mobile mobile=h1.get(mobileId);
		if(mobile==null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		else
		{
			h1.remove(mobileId);
		}
	}
}
