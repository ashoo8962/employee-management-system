package com.empapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InformationesDto {
	private Integer informationesId;
	private String gender;
	private String email;
	private String details;

}
