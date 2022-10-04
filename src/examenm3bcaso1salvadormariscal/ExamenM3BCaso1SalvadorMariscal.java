/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenm3bcaso1salvadormariscal;

import control.controlEstudiante;
import modelo.Estudiantes;
import modelo.EstudiantesJpaController;
import vista.viewMenu;

/**
 *
 * @author Ismael
 */
public class ExamenM3BCaso1SalvadorMariscal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ManagerFactory manager = new ManagerFactory();
        
        viewMenu vista = new viewMenu();
        Estudiantes estudiante = new Estudiantes();

        EstudiantesJpaController modelo = new EstudiantesJpaController(manager.getentityManagerFactory());
        controlEstudiante controlador = new controlEstudiante(vista,manager, new EstudiantesJpaController(manager.getentityManagerFactory()), estudiante);
    }
    
}
