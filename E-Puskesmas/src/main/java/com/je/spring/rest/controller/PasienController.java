/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.controller;

import com.je.spring.rest.model.Pasien;
import com.je.spring.rest.service.PasienService;
import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author AJ.P
 */
@Controller
public class PasienController {
    
    @Autowired
    private PasienService pasienService;
   @RequestMapping(value = "/master/pasien", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll() {
            
         Map<String, Object> response = new HashMap<String, Object>();
         
        try{
            
         List<Pasien> pasienList = pasienService.getAll();
         long count = pasienService.count();
             
         response.put(Constants.LIST, pasienList);
         response.put(Constants.TOTAL, count);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    	
        return response;
    	
    } 

    
    @RequestMapping(value = "/master/pasien/{id_pasien}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById_pasien(@PathVariable("id_pasien") final int id_pasien) {

         Map<String, Object> response = new HashMap<String, Object>();
         
         try{
             
              Pasien pasien = pasienService.getById_pasien(id_pasien);
              
              response.put(Constants.PASIEN_KEY, pasien);
             
         }catch(Exception e){
             e.printStackTrace();
         }
         
         return response;
    }
    
    @RequestMapping(value = "/master/pasien", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request) {
        
        Map<String, Object> response = new HashMap<String, Object>();
    	Map<String, Object> pasienMap = (Map<String, Object>) request.get(Constants.PASIEN_KEY);
        Pasien pasien = new Pasien();
        
        try{
           
        pasien.setPasien_nama((String) pasienMap.get("pasien_nama"));
        pasien.setPasien_alamat((String) pasienMap.get("pasien_alamat"));
        pasien.setPasien_tgllahir((String) pasienMap.get("pasien_tgllahir"));
        pasien.setPasien_notlp((String) pasienMap.get("pasien_notlp"));
        pasien.setPasien_jenkel((String) pasienMap.get("pasien_jenkel"));
        pasien.setPasien_agama((String) pasienMap.get("pasien_agama"));
        
        pasienService.insert(pasien);
        
        response.put(Constants.STATUS, Constants.OK);
            
        }catch(Exception e){
            
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
            
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/pasien/{id_pasien}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Map<String, Object> update(@PathVariable("id_pasien") final int id_pasien,
           @RequestBody final Map<String, Object> request) {

    	Map<String, Object> response = new HashMap<String, Object>();
    	Map<String, Object> pasienMap = (Map<String, Object>) request.get(Constants.PASIEN_KEY);
        Pasien pasien = new Pasien();
        
        try{
        
        pasien.setId_pasien(id_pasien);
        pasien.setPasien_nama((String) pasienMap.get("pasien_nama"));
        pasien.setPasien_alamat((String) pasienMap.get("pasien_alamat"));
        pasien.setPasien_tgllahir((String) pasienMap.get("pasien_tgllahir"));
        pasien.setPasien_notlp((String) pasienMap.get("pasien_notlp"));
        pasien.setPasien_jenkel((String) pasienMap.get("pasien_jenkel"));
        pasien.setPasien_agama((String) pasienMap.get("pasien_agama"));
        
        pasienService.update(pasien);
        
        response.put(Constants.STATUS, Constants.OK);
            
        }catch(Exception e){
            
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
            
        }
        
        return response;

    }
    
    @RequestMapping(value = "/master/pasien/{id_pasien}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Map<String, Object> delete(@PathVariable("id_pasien") final int id_pasien) {
    	
    	
    	Map<String, Object> response = new HashMap<String, Object>();
        Pasien pasien = new Pasien();
        
        try{
        
        pasien.setId_pasien(id_pasien);
        
        pasienService.delete(pasien);
        
        response.put(Constants.STATUS, Constants.OK);
            
        }catch(Exception e){
            
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
            
        }
        
        return response;

    }
    
}
