package com.cricket.cricket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.cricket.entity.CricketEntity;
import com.cricket.cricket.repository.CricketRepository;


@Service
public class CricketServiceee implements CricketService{

	@Autowired
	public CricketRepository crepo;
	
	public List<CricketEntity> getmembers()
	{
		List<CricketEntity> ce=new ArrayList<CricketEntity>();
		try {
			ce=(List<CricketEntity>) crepo.findAll();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ce;
	}
	@Override
	public CricketEntity save(CricketEntity cricketentity)
	{
		CricketEntity c=new CricketEntity();
		try {
		   crepo.save(cricketentity);
		}
	  catch (Exception e) 
		{
			e.printStackTrace();
		}
		return c;  
	}
	
	@Override
	public CricketEntity getById(Long id) {
		CricketEntity c = new CricketEntity();
		try {
			c = crepo.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	@Override
	public CricketEntity updatePlayer(Long id,CricketEntity cricketEntity) {
		CricketEntity cricketEntity2 = new CricketEntity();
		try {
			if(id >0) {
				cricketEntity2 = crepo.findById(id).get();
				if(cricketEntity2 != null) {
					cricketEntity2.setName(cricketEntity.getName());
					cricketEntity2.setTeam(cricketEntity.getTeam());
					cricketEntity2.setIplTeam(cricketEntity.getIplTeam());
					cricketEntity2.setRuns(cricketEntity.getRuns());
					cricketEntity2.setWickets(cricketEntity.getWickets());
					crepo.save(cricketEntity2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cricketEntity2;
	}
	
	@Override
	public String deletePlayer(Long id) {
		try {
			if(id > 0) {
				crepo.deleteById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Data deleted successfully";
	}
	
	// @Override
	// public List<CricketEntity> getPlayerGrtrThan10K(){
	// 	List<CricketEntity> cricketEntities = new ArrayList<CricketEntity>();
	// 	try {
	// 		cricketEntities = crepo.getPlayerGreaterThan10K();
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}
	// 	return cricketEntities;
	// }
	
	//update
	//Pre-defined Methods 
	//Save and update don't have separate ones 
	//save method will act as Insert and Update
	//1. need to check whether the id is present or not
	//2. If id is present then assign the values in the requestBody to new Object
}
