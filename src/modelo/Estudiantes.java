/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ismael
 */
@Entity
@Table(name = "ESTUDIANTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e"),
    @NamedQuery(name = "Estudiantes.findByEstCod", query = "SELECT e FROM Estudiantes e WHERE e.estCod = :estCod"),
    @NamedQuery(name = "Estudiantes.findByEstCedula", query = "SELECT e FROM Estudiantes e WHERE e.estCedula = :estCedula"),
    @NamedQuery(name = "Estudiantes.findByEstPnombre", query = "SELECT e FROM Estudiantes e WHERE e.estPnombre = :estPnombre"),
    @NamedQuery(name = "Estudiantes.findByEstApellidop", query = "SELECT e FROM Estudiantes e WHERE e.estApellidop = :estApellidop"),
    @NamedQuery(name = "Estudiantes.findByEstDireccion", query = "SELECT e FROM Estudiantes e WHERE e.estDireccion = :estDireccion"),
    @NamedQuery(name = "Estudiantes.findByEstCorreo", query = "SELECT e FROM Estudiantes e WHERE e.estCorreo = :estCorreo"),
    @NamedQuery(name = "Estudiantes.findByEstFecha", query = "SELECT e FROM Estudiantes e WHERE e.estFecha = :estFecha"),
    @NamedQuery(name = "Estudiantes.findByEstGenero", query = "SELECT e FROM Estudiantes e WHERE e.estGenero = :estGenero")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EST_COD")
    private BigDecimal estCod;
    @Basic(optional = false)
    @Column(name = "EST_CEDULA")
    private String estCedula;
    @Column(name = "EST_PNOMBRE")
    private String estPnombre;
    @Column(name = "EST_APELLIDOP")
    private String estApellidop;
    @Column(name = "EST_DIRECCION")
    private String estDireccion;
    @Column(name = "EST_CORREO")
    private String estCorreo;
    @Column(name = "EST_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estFecha;
    @Column(name = "EST_GENERO")
    private String estGenero;

    public Estudiantes() {
    }

    public Estudiantes(BigDecimal estCod) {
        this.estCod = estCod;
    }

    public Estudiantes(BigDecimal estCod, String estCedula) {
        this.estCod = estCod;
        this.estCedula = estCedula;
    }

    public BigDecimal getEstCod() {
        return estCod;
    }

    public void setEstCod(BigDecimal estCod) {
        this.estCod = estCod;
    }

    public String getEstCedula() {
        return estCedula;
    }

    public void setEstCedula(String estCedula) {
        this.estCedula = estCedula;
    }

    public String getEstPnombre() {
        return estPnombre;
    }

    public void setEstPnombre(String estPnombre) {
        this.estPnombre = estPnombre;
    }

    public String getEstApellidop() {
        return estApellidop;
    }

    public void setEstApellidop(String estApellidop) {
        this.estApellidop = estApellidop;
    }

    public String getEstDireccion() {
        return estDireccion;
    }

    public void setEstDireccion(String estDireccion) {
        this.estDireccion = estDireccion;
    }

    public String getEstCorreo() {
        return estCorreo;
    }

    public void setEstCorreo(String estCorreo) {
        this.estCorreo = estCorreo;
    }

    public Date getEstFecha() {
        return estFecha;
    }

    public void setEstFecha(Date estFecha) {
        this.estFecha = estFecha;
    }

    public String getEstGenero() {
        return estGenero;
    }

    public void setEstGenero(String estGenero) {
        this.estGenero = estGenero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estCod != null ? estCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.estCod == null && other.estCod != null) || (this.estCod != null && !this.estCod.equals(other.estCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "modelo.Estudiantes[ estCod=" + estCod + " ]";
return estCedula;
    }
    
}
