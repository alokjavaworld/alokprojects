package com.nt.test;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.LoanAmtCalculator;
import com.nt.beans.LoanAmtDetails;
import com.nt.editors.LoanAmtDetailEditors;

public class Test {

	public static void main(String[] args) {
	DefaultListableBeanFactory factory =null;
	XmlBeanDefinitionReader reader=null;
	LoanAmtCalculator calculator=null;
	
	//cerate ioc container 
   factory=new DefaultListableBeanFactory();
   reader=new XmlBeanDefinitionReader(factory);
   reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
   //get bean
   factory.addPropertyEditorRegistrar(new CustomRegistrar());
   calculator=factory.getBean("lacalculator",LoanAmtCalculator.class);
   //invoke method
   System.out.println("Amt :"+calculator.calculateAmt());
	}

	
	//nested inner class /static inner class
		private static class  CustomRegistrar  implements PropertyEditorRegistrar{

			@Override
			public void registerCustomEditors(PropertyEditorRegistry registry) {
				System.out.println("PropertyEditorSupport.CustomRegistrar.registerCustomEditors()");
			   registry.registerCustomEditor(LoanAmtDetails.class,new LoanAmtDetailEditors());  // (property type, CustomPE class obj)
			   
			} //method
		}//inner class
}
