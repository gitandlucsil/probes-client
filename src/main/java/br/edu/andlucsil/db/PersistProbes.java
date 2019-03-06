/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.andlucsil.db;

import br.edu.andlucsil.models.AlarmRegister;
import br.edu.andlucsil.models.Alarms;
import br.edu.andlucsil.models.ProbesValues;
import java.util.List;

/**
 *
 * @author andre
 */
public class PersistProbes {
    
    private final DAO<ProbesValues> probesvaluesDao = new DAO<>(ProbesValues.class);
    private DAO<Alarms> alarmsDao;
    private DAO<AlarmRegister> alarmregiserDAO = new DAO<>(AlarmRegister.class);
    private List<Alarms> alarms;
    
    private void ListAlarms(){
       alarmsDao = new DAO<>(Alarms.class);
       alarms = alarmsDao.findAll();
    }

    public PersistProbes(ProbesValues[] probes_values) {
         ListAlarms();
        /*Persiste sobre as leituras recebidas, inserindo no banco de dados*/
        for (ProbesValues p : probes_values) { 
            /*Necessario fazer um update devido ao valor de chave primaria de probesidf, porem insere em probesvalues*/
            probesvaluesDao.update(p);
            /*Percorre a lista de alarmes*/
            alarms.stream().filter((a) -> (p.getProbesidf().getDescription().equals(a.getProbesidf().getDescription()))).forEachOrdered((a) -> {
                System.out.println(a.getProbesidf().getDescription()+" - "+a.getDescription()+" - "+a.getValue());
                if(a.isType()){ //Se for marcado para ser um alarme de valor maior
                    if(p.getRead_value() >= a.getValue()){
                        AlarmRegister ar = new AlarmRegister(a,p);
                        a.setActive(true);
                        alarmsDao.update(a);
                        alarmregiserDAO.update(ar);
                        System.out.println("É maior!");
                        System.out.println(p.getProbesidf().getDescription()+": "+p.getRead_value()+","+a.getValue()); 
                    } else{
                        a.setActive(false);
                        alarmsDao.update(a);
                    }
                }else{ //Se for marcado para ser um alarme de valor menor
                    if(p.getRead_value() <= a.getValue()){
                        alarmregiserDAO = new DAO<>(AlarmRegister.class);
                        AlarmRegister ar = new AlarmRegister(a,p);
                        a.setActive(true);
                        alarmsDao.update(a);
                        alarmregiserDAO.update(ar);
                        System.out.println("É menor!");
                        System.out.println(p.getProbesidf().getDescription()+": "+p.getRead_value()+","+a.getValue());
                    }else{
                        a.setActive(false);
                        alarmsDao.update(a);
                    }
                }
            });
        }
    }

}
