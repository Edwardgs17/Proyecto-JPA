package com.ecodeup.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.ecodeup.model.PersonaVO;

public class Ejecutable {

	public static void main(String[] args) {
		
		int opcion=0;
		PersonaVO miPersona;
		Logica miLogica=new Logica();
		
		EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

  try {
		
	do {
		opcion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese lo que desea hacer: \n"
		 +"1-Crear Usuario \n"
		 +"2-Consultar Usuario \n"
		 +"3-Editar Usuario \n"
		 +"4-Eliminar Usuario \n"+"5-salir"));

		switch (opcion) {
		case 1:
			
			 miPersona=new PersonaVO();
			 miPersona.setDocumento(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de documento:")));
			 miPersona.setNombre(JOptionPane.showInputDialog("Ingrese el nombre:"));
			 miPersona.setApellidos(JOptionPane.showInputDialog("Ingrese apellidos:"));
			 miPersona.setTelefono(JOptionPane.showInputDialog("Ingrese el telefono:"));
			 miPersona.setCorreo(JOptionPane.showInputDialog("Ingrese el correo:"));
			 miPersona.setSexo(JOptionPane.showInputDialog("Ingrese el sexo:"));
			 miPersona.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Ingrese salario")));
			 miPersona.setTipoEmpleado(JOptionPane.showInputDialog("Ingrese tipo Empleado: A B C"));
			 miLogica.calcularAumento(miPersona);

			 entity.getTransaction().begin();
			 entity.persist(miPersona);
			 entity.getTransaction().commit();
			 JOptionPane.showMessageDialog(null, "Persona Registrada con exito!!");
			
			
			break;
  
		case 2:	
          
			miPersona = new PersonaVO();
			miPersona.setDocumento(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de documento que desea consultar :")));
			
			System.out.println(miPersona.getDocumento());
			miPersona = entity.find(PersonaVO.class, miPersona.getDocumento());
			
			if(miPersona != null) {
				
				System.out.println(miPersona.getApellidos());
				miPersona.imprimirResultados();
			}
			else {
				
				JOptionPane.showMessageDialog(null, "La persona no se encuentra registrada en la base de datos");
				
				List<PersonaVO> listaPersonas = new ArrayList<>();
				
				Query query=entity.createQuery("SELECT p FROM PersonaVO p");
				listaPersonas=query.getResultList();
				for(PersonaVO p : listaPersonas) {
					
					System.out.println(p);
				}
			}
			break;
		
		case 3:
			
			miPersona = new PersonaVO();
			miPersona.setDocumento(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de documento que desea actualizar: ")));
			miPersona = entity.find(PersonaVO.class, miPersona.getDocumento());
		 
			if(miPersona != null) {
				
				System.out.println(miPersona);
				miPersona.setNombre(JOptionPane.showInputDialog("Ingrese nombre :"));
				miPersona.setApellidos(JOptionPane.showInputDialog("Ingrese apellidos: "));
				miPersona.setTelefono(JOptionPane.showInputDialog("Ingrese telefono: "));
				miPersona.setCorreo(JOptionPane.showInputDialog("Ingrese Correo: "));
				miPersona.setSexo(JOptionPane.showInputDialog("Ingrese sexo"));
				entity.getTransaction().begin();
				entity.merge(miPersona);
				entity.getTransaction().commit();
				JOptionPane.showMessageDialog(null, "Datos Actualizados exitosamente!!!!");
			}
			else {
				
				JOptionPane.showMessageDialog(null, "La persona no existe!!");
			}
			break;
			
		case 4:
			
				miPersona = new PersonaVO();
			    miPersona.setDocumento(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de documento que desea eliminar: ")));
			   
			    
			    miPersona= entity.find(PersonaVO.class, miPersona.getDocumento());
			    
			    if(miPersona != null) {
			    	
			    	System.out.println(miPersona);
			    	
			    	entity.getTransaction().begin();
			    	entity.remove(miPersona);
			    	entity.getTransaction().commit();
			    	
			    	JOptionPane.showMessageDialog(null, "Persona eliminada satisfactoriamente!!");
			    }
			    else {
			    	
			    	JOptionPane.showMessageDialog(null, "Este numero de documento no se encuentra registrado!!");
			    }
			break;
			
		case 5:
			entity.close();JPAUtil.shutdown();
		    JOptionPane.showMessageDialog(null, "Hasta Luego!!");
			break;
		}
	}
	while(opcion !=5);
	}
  catch (Exception e) {
	JOptionPane.showMessageDialog(null,"Ingreso texto en vez de numeros","",JOptionPane.WARNING_MESSAGE);
  		}
	}
}
