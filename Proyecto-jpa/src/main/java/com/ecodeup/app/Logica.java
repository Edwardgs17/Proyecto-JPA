package com.ecodeup.app;

import com.ecodeup.model.PersonaVO;

public class Logica {

	PersonaVO miPersona;
	public void calcularAumento(PersonaVO miPersona) {
		
		if(miPersona.getTipoEmpleado().equalsIgnoreCase("A")) {
			
			 miPersona.setSalarioTotal(miPersona.getSalario()+(miPersona.getSalario()*0.20));
		}
		else 
			if(miPersona.getTipoEmpleado().equalsIgnoreCase("B")) {
				
				miPersona.setSalarioTotal(miPersona.getSalario()+(miPersona.getSalario()*0.10));
				
			}
			else 
				if(miPersona.getTipoEmpleado().equalsIgnoreCase("C")) {
					
					miPersona.setSalarioTotal(miPersona.getSalario()+(miPersona.getSalario()*0.05));
					
				}
		}
	 
}
