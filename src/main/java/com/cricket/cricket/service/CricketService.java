package com.cricket.cricket.service;

import java.util.List;
import java.util.Optional;

import com.cricket.cricket.entity.CricketEntity;



public interface CricketService {

//	CricketEntity insert(CricketEntity cricketEntity);
//	
//	List<CricketEntity> getAllPlayers();
	
	CricketEntity save(CricketEntity cricketEntity);
	
	List<CricketEntity> getmembers();
	
	CricketEntity getById(Long id);
	
	CricketEntity updatePlayer(Long id,CricketEntity cricketEntity);
	
	String deletePlayer(Long id);

}
