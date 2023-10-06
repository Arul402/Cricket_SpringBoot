
package com.cricket.cricket.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cricket.cricket.entity.CricketEntity;



@Repository
public interface CricketRepository extends CrudRepository<CricketEntity, Long>{
	
	
}
