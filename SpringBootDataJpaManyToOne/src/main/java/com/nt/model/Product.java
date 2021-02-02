package com.nt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	
	@Id
	@Column(name = "pid")
	private Integer pid;
	
	@Column(name = "code")
	private String  code;
	
	@Column(name = "cost")
	private float cost;
	
	@Column(name = "model")
	private String model;
	
	 @ManyToOne
     @JoinColumn(name = "vid")
	  private Vendor vendor;

}
