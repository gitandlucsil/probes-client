/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import br.edu.andlucsil.serial.SerialComm;
import junit.framework.TestCase;

/**
 *
 * @author andre
 */
public class SerialTest extends TestCase{
    
    private SerialComm serialComm;
    
    @Override
    protected void setUp() throws Exception{
        super.setUp();
        //Cria o "bean" pelo Spring
        serialComm = (SerialComm) SpringUtil.getInstance().getBean(SerialComm.class);
    }
}
