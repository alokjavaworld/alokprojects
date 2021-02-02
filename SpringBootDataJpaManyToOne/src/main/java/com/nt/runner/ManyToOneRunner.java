package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.Product;
import com.nt.model.Vendor;
import com.nt.repo.IProductRepo;
import com.nt.repo.IVebdorRepo;

@Component
public class ManyToOneRunner implements CommandLineRunner {

	@Autowired
	private IProductRepo prepo;

	@Autowired
	private IVebdorRepo vrepo;

	@Override
	public void run(String... args) throws Exception {
      Vendor v1=  vrepo.save(new Vendor(101,"A","hyd"));
       Vendor v2=vrepo.save(new Vendor(102,"B","delhi"));
        
        Product p1=prepo.save(new Product(1,"pen",200,"a",v1));
        
        prepo.save(p1);
		 
 	}

}
