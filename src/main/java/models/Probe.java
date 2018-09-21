/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name="probe")
public class Probe implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "temp_1", nullable = false)
    private int temp_1;
    @Column(name = "temp_2", nullable = false)
    private int temp_2;
    @Column(name = "hum_1", nullable = false)
    private int hum_1;
    @Column(name = "hum_2", nullable = false)
    private int hum_2;

    public Probe() {
    }

    public int getTemperature1() {
        return temp_1;
    }

    public void setTemperature1(int temperature1) {
        this.temp_1 = temperature1;
    }

    public int getHumidity1() {
        return hum_1;
    }

    public void setHumidity1(int humidity1) {
        this.hum_1 = humidity1;
    }

    public int getTemperature2() {
        return temp_2;
    }

    public void setTemperature2(int temperature2) {
        this.temp_2 = temperature2;
    }

    public int getHumidity2() {
        return hum_2;
    }

    public void setHumidity2(int humidity2) {
        this.hum_2 = humidity2;
    }

    public int getTemp_1() {
        return temp_1;
    }

    public void setTemp_1(int temp_1) {
        this.temp_1 = temp_1;
    }
    
}
