package com.empapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Informationes {
	@Id
	@GeneratedValue(generator = "informationes_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "informationes_gen",sequenceName = "informationes_seq", initialValue = 21,allocationSize = 1)
	private Integer informationesId;
	private String gender;
	private String email;
	private String details;
	

}
