
package com.cricket.cricket.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;

//it is used to create a table in the database
@Entity 

//It is used to define getter and setter methods.
@Data
public class CricketEntity {

	//It acts as a primary key
    @Id
    //It helps Id as an auto Incremented value
    @GeneratedValue
	private Long id;
	private String name;
	private int runs;
	private int wickets;
	private String team;
	private String iplTeam;
}


//Step 1: Create spring boot project with dependencies such as MYSQL driver, Spring boot web, Lombok, Spring data JPA
//Step 2: Create a packaging structure
//Step 3: Define database credentials in application.properties.
//Step 4: Add the below three lines in application.properties
	//spring.jpa.show-sql=true
	//spring.jpa.hibernate.ddl-auto=update
	//spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
//Step 5: Run your spring boot project.
//Step 6: Verify the database whether the table is created or not.




