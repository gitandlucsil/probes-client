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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "probesidf")
    private ProbesIdf probesidf;
    @Column(name = "read_value", nullable = false)
    private int read_value;
    @Column(name = "read_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date read_date;
    @Column(name = "read_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date read_time;
    @OneToOne(mappedBy = "probesvalues", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
    private AlarmRegister alarm;

    public ProbesValues() {
        this.read_date = new Date(System.currentTimeMillis());
        this.read_time = new Date(System.currentTimeMillis());
    }

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
 
    public AlarmRegister getAlarm(){
        return alarm;
    }
    
    public void setAlarm(AlarmRegister alarm){
        this.alarm = alarm;
    }
    
}