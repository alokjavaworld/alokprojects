package com.nt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vendor {
	@Id
	@Column(name = "vid")
   private Integer vid;
	

	@Column(name = "vcode")
   private String vCode;
	

	@Column(name = "vloc")
   private String vLoc;
   
}
