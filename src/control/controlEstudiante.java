/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import examenm3bcaso1salvadormariscal.ManagerFactory;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Estudiantes;
import modelo.EstudiantesJpaController;
import vista.viewMenu;

/**
 *
 * @author Ismael
 */
public class controlEstudiante extends javax.swing.JFrame {

    private ManagerFactory manager;
    private viewMenu vista;
    private EstudiantesJpaController modeloEstudiante;
    Estudiantes estudiante;
    
    ControlTabla modeloTablaEstudiante;
    ListSelectionModel listaEstudiantemodel;

    
    public controlEstudiante(viewMenu vista, ManagerFactory manager, EstudiantesJpaController modeloEstudiante, Estudiantes estudiante) {
        this.vista = vista;
        this.manager = manager;
//        this.vista.setExtendedState(MAXIMIZED_BOTH);
        this.estudiante = estudiante;
        
//        this.vista.getjTableCrearEstudiante().setModel(modeloTablaEstudiante);
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        iniciarControl();
    }
    
    
    public void iniciarControl() {
        this.vista.getBtnRegistrar().addActionListener(l -> guardarEstudiante());
        this.vista.getBtnEditar().addActionListener(l -> editarEstudiante());
        this.vista.getBtnEliminar().addActionListener(l -> eliminarEstudiante());
        this.vista.getjTableCrearEstudiante().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaEstudiantemodel = this.vista.getjTableCrearEstudiante().getSelectionModel();
        listaEstudiantemodel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    EstudianteSeleccionado();
                }
            }

        });

        this.vista.getBtnEliminar().setEnabled(false);
        this.vista.getBtnEditar().setEnabled(false);
        this.vista.getBtnLimpiar().addActionListener(l -> limpiar());
        this.vista.getBtnLimpiatxt().addActionListener(l -> limpiarbuscador());
        this.vista.getBtnBuscar().addActionListener(l -> buscarusuario());
        this.vista.getjCheckMostrar().addActionListener(l -> buscarusuario());
        this.vista.getBtnReportes().addActionListener(l -> reporteGeneral());
    }

    public void salir() {
        this.vista.dispose();
    }

    //GUARDAR PERSONA
    public void guardarEstudiante() {
        try {
            estudiante = new Estudiantes();
            estudiante.setEstCedula(this.vista.getTxtCedula().getText());
            estudiante.setEstPnombre(this.vista.getTxtNombres().getText());
            estudiante.setEstApellidop(this.vista.getTxtApellidos().getText());
            estudiante.setEstCorreo(this.vista.getTxtCorreo().getText());
            estudiante.setEstDireccion(this.vista.getTxtDireccion().getText());
            estudiante.setEstFecha(this.vista.getJDCFechaNac().getDate());
            estudiante.setEstGenero((String)this.vista.getCbxGenero().getSelectedItem());
            modeloEstudiante.create(estudiante);
            modeloTablaEstudiante.agregar(estudiante);

            Resouces.success("Alerta!!", "ESTUDIANTE GENERADO CORRECTAMENTE");
//            JOptionPane.showMessageDialog(panelEscritorio, "PERSONA CREADA CORRECTAMENTE");
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(controlEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//
//    //EDITAR Estudiante
    public void editarEstudiante() {
        if (estudiante != null) {
            estudiante.setEstPnombre(this.vista.getTxtNombres().getText());
            estudiante.setEstApellidop(this.vista.getTxtApellidos().getText());
            estudiante.setEstCorreo(this.vista.getTxtCorreo().getText());
            estudiante.setEstDireccion(this.vista.getTxtDireccion().getText());
            estudiante.setEstFecha(this.vista.getJDCFechaNac().getDate());
            estudiante.setEstGenero((String) this.vista.getCbxGenero().getSelectedItem());
            Resouces.success("Atención!!", "ESTUDIANTE EDITADA CORECTAMENTE");
            try {
                modeloEstudiante.edit(estudiante);
                modeloTablaEstudiante.eliminar(estudiante);
                modeloTablaEstudiante.actualizar(estudiante);

                limpiar();

            } catch (Exception ex) {

                Logger.getLogger(controlEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Resouces.success("Atención!!", ":-");
        }

    }
//
    //ELIMINAR PERSONA
    public void eliminarEstudiante() {
        if (estudiante != null) {
            try {
                modeloEstudiante.destroy(estudiante.getEstCod());
                limpiar();
            } catch (Exception ex) {
                Logger.getLogger(controlEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                limpiar();
            }
            modeloTablaEstudiante.eliminar(estudiante);

            Resouces.success("ALERTA!!", "ESTUDIANTE ELIMINADO CORECTAMENTE");
        }
    }
//
    public void limpiar() {
        this.vista.getTxtCedula().setText("");
        this.vista.getTxtApellidos().setText("");
        this.vista.getTxtNombres().setText("");
        this.vista.getTxtDireccion().setText("");
        this.vista.getTxtCorreo().setText("");
        this.vista.getCbxGenero().setSelectedItem("SELECCIONE");
        this.vista.getBtnEliminar().setEnabled(false);
        this.vista.getBtnEditar().setEnabled(false);
        this.vista.getBtnRegistrar().setEnabled(true);
        this.vista.getjTableCrearEstudiante().getSelectionModel().clearSelection();
    }
//
    public void EstudianteSeleccionado() {
        if (this.vista.getjTableCrearEstudiante().getSelectedRow() != -1) {
            estudiante = modeloTablaEstudiante.getFilas().get(this.vista.getjTableCrearEstudiante().getSelectedRow());
            this.vista.getTxtCedula().setText(estudiante.getEstCedula());
            this.vista.getTxtNombres().setText(estudiante.getEstPnombre());
            this.vista.getTxtApellidos().setText(estudiante.getEstApellidop());
            this.vista.getTxtCorreo().setText(estudiante.getEstCorreo());
            this.vista.getTxtDireccion().setText(estudiante.getEstDireccion());
            this.vista.getCbxGenero().setSelectedItem(estudiante.getEstGenero());
            this.vista.getBtnEliminar().setEnabled(true);
            this.vista.getBtnEditar().setEnabled(true);
            this.vista.getBtnRegistrar().setEnabled(false);
        }
    }

    public void limpiarbuscador() {
        this.vista.getTxtBuscar().setText("");
        modeloTablaEstudiante.setFilas(modeloEstudiante.findEstudiantesEntities());
        modeloTablaEstudiante.fireTableDataChanged();
    }

    public void buscarusuario() {
        if (this.vista.getjCheckMostrar().isSelected()) {
            modeloTablaEstudiante.setFilas(modeloEstudiante.findEstudiantesEntities());
            modeloTablaEstudiante.fireTableDataChanged();
            limpiarbuscador();

        } else {
            if (!this.vista.getTxtBuscar().getText().equals("")) {
                modeloTablaEstudiante.setFilas(modeloEstudiante.buscarEstudiantes(this.vista.getTxtBuscar().getText()));
                modeloTablaEstudiante.fireTableDataChanged();
                System.out.println("llego");
            } else {

            }

        }

    }
//

    //llamar
    public void reporteGeneral() {
        Resouces.imprimirReeporte(ManagerFactory.getConnection(manager.getentityManagerFactory().createEntityManager()), "/reportes/Estudiante.jasper", new HashMap());
    }

}
