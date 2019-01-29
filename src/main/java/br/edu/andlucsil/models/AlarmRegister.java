package br.edu.andlucsil.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alarm_register")
public class AlarmRegister implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "alarm")
    private Alarms alarm;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "probes_values_id")
    private ProbesValues probesvalues;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Alarms getAlarm() {
		return alarm;
	}
	public void setAlarm(Alarms alarm) {
		this.alarm = alarm;
	}
	public ProbesValues getProbesvalues() {
		return probesvalues;
	}
	public void setProbesvalues(ProbesValues probesvalues) {
		this.probesvalues = probesvalues;
	}
	
}
