/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.andlucsil.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "probes_idf")
public class ProbesIdf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int id_value;
    @Column(name = "description", nullable = false)
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "probesidf")
    private List<ProbesValues> probesvalues;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "probesidf")
    private List<Alarms> alarms;

    public ProbesIdf() {
    }

    public ProbesIdf(int id_value, String description) {
        this.id_value = id_value;
        this.description = description;
    }

    public int getId_value() {
        return id_value;
    }

    public void setId_value(int id_value) {
        this.id_value = id_value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProbesValues> getProbesvalues() {
        return probesvalues;
    }

    public void setProbesvalues(List<ProbesValues> probesvalues) {
        this.probesvalues = probesvalues;
    }

	public List<Alarms> getAlarms() {
		return alarms;
	}

	public void setAlarms(List<Alarms> alarms) {
		this.alarms = alarms;
	}
	
}