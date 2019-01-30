package br.edu.andlucsil.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alarms")
public class Alarms implements Serializable{
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column (name = "value", nullable = false)
    private int value;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "alarm")
    private List<AlarmRegister> alarm;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "probesidf")
    private ProbesIdf probesidf;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
        
        public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public List<AlarmRegister> getAlarm() {
		return alarm;
	}
	public void setAlarm(List<AlarmRegister> alarm) {
		this.alarm = alarm;
	}
	public ProbesIdf getProbesidf() {
		return probesidf;
	}
	public void setProbesidf(ProbesIdf probesidf) {
		this.probesidf = probesidf;
	}
    
}
