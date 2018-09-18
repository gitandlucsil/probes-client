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
    
    private int temp_1;
    private int temp_2;
    private int hum_1;
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
    
}
