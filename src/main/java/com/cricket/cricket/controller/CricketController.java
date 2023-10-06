package com.cricket.cricket.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.cricket.entity.CricketEntity;
import com.cricket.cricket.service.CricketService;




@RestController
@RequestMapping(value = "/cricket")
public class CricketController {
	
	@Autowired
	public CricketService cs;
	
	
	@GetMapping
	public String welcome()
	{
		return "Welcome to IPL Cricket";
	}
	
	@GetMapping(value="/getmembers")
	public List<CricketEntity> getmembers()
	{
		List<CricketEntity> c=new ArrayList<CricketEntity>();
		try 
		{
			c=cs.getmembers();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return c;
	}
	
	@PostMapping(value="/insert")
	public CricketEntity insert(@RequestBody CricketEntity cricketentity)
	{
		CricketEntity c=new CricketEntity();
		try {
			c=cs.save(cricketentity);
		}
	  catch (Exception e) 
		{
			e.printStackTrace();
		}
		return c;
	}
	
	//GET BY ID
	@GetMapping(value = "/getPlayerById/{id}")
	public CricketEntity getById(@PathVariable Long id) {
		CricketEntity cricketEntity = new CricketEntity();
		try {
			cricketEntity = cs.getById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cricketEntity;
	}
	
	//UPDATE BY ID
	@PutMapping(value = "/updatePlayer/{id}")
	public CricketEntity updatePlayer(@PathVariable Long id, @RequestBody CricketEntity cricketEntity) {
		CricketEntity cricketEntity2 = new CricketEntity();
		try {
			cricketEntity2 = cs.updatePlayer(id,cricketEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cricketEntity2;
	}
	
	//DELETE BY ID
	@DeleteMapping(value = "/deletePlayer/{id}")
	public String deletePlayer(@PathVariable Long id) {
		try {
			cs.deletePlayer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Data Deleted Successfully";
	}
	
	//Customised Query 
	// @GetMapping(value = "/getPlayerGreaterThan10K")
	// public List<CricketEntity> getPlayersGrtrThanTenK(){
	// 	List<CricketEntity> cricketEntities = new ArrayList<CricketEntity>();
	// 	try {
	// 		cricketEntities = cs.getPlayerGrtrThan10K();
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}
	// 	return cricketEntities;
	// }
	
}
