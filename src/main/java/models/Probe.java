/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author andre
 */
public class Probe {
    
    private int temperature1;
    private int temperature2;
    private int humidity1;
    private int humidity2;

    public Probe() {
    }

    public int getTemperature1() {
        return temperature1;
    }

    public void setTemperature1(int temperature1) {
        this.temperature1 = temperature1;
    }

    public int getHumidity1() {
        return humidity1;
    }

    public void setHumidity1(int humidity1) {
        this.humidity1 = humidity1;
    }

    public int getTemperature2() {
        return temperature2;
    }

    public void setTemperature2(int temperature2) {
        this.temperature2 = temperature2;
    }

    public int getHumidity2() {
        return humidity2;
    }

    public void setHumidity2(int humidity2) {
        this.humidity2 = humidity2;
    }
    
}
