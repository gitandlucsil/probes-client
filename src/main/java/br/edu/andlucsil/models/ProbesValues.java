/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.andlucsil.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "probes_values")
public class ProbesValues implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    //@Column(name = "id_value", nullable = false)
    //private int id_value;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "probesidf")
    private ProbesIdf probesidf;
    @Column(name = "read_value", nullable = false)
    private int read_value;
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date read_date;
    @Column(name = "time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date read_time;

    public ProbesValues() {
        this.read_date = new Date(System.currentTimeMillis());
        this.read_time = new Date(System.currentTimeMillis());
    }

    /*public int getId_value() {
        return id_value;
    }

    public void setId_value(int id_value) {
        this.id_value = id_value;
    }*/
    public int getRead_value() {
        return read_value;
    }

    public void setRead_value(int read_value) {
        this.read_value = read_value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRead_date() {
        return read_date;
    }

    public void setRead_date(Date read_date) {
        this.read_date = read_date;
    }

    public Date getRead_time() {
        return read_time;
    }

    public void setRead_time(Date read_time) {
        this.read_time = read_time;
    }

    public ProbesIdf getProbesidf() {
        return probesidf;
    }

    public void setProbesidf(ProbesIdf probesidf) {
        this.probesidf = probesidf;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.probesidf);
        hash = 59 * hash + this.read_value;
        hash = 59 * hash + Objects.hashCode(this.read_date);
        hash = 59 * hash + Objects.hashCode(this.read_time);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProbesValues other = (ProbesValues) obj;
        if (this.read_value != other.read_value) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.probesidf, other.probesidf)) {
            return false;
        }
        if (!Objects.equals(this.read_date, other.read_date)) {
            return false;
        }
        if (!Objects.equals(this.read_time, other.read_time)) {
            return false;
        }
        return true;
    }

    
    


    
}
