/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.andlucsil.model;
/**
 *
 * @author andre
 */
public class Probe {
    
    private int id;
    private int read_value;

    public Probe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRead_value() {
        return read_value;
    }

    public void setRead_value(int read_value) {
        this.read_value = read_value;
    }
    
}
