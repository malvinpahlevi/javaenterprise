/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.service.impl;

import com.je.spring.rest.dao.PasienDao;
import com.je.spring.rest.model.Pasien;
import com.je.spring.rest.service.PasienService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author AJ.P
 */
@Service("pasienService")
public class PasienServiceImpl implements PasienService{

    @Autowired
    PasienDao pasienDao;

    @Override
    public List<Pasien> getAll() {
        List<Pasien> pasienList = new ArrayList<Pasien>();
            pasienList = pasienDao.getAll();
            return pasienList;
    }

    @Override
    public Pasien getById_pasien(int id_pasien) {
        Pasien pasien = new Pasien();
        pasien = pasienDao.getById_pasien(id_pasien);
        
        return pasien;
    }

    @Override
    public void insert(Pasien pasien) {
        pasienDao.insert(pasien);
    }

    @Override
    public void update(Pasien pasien) {
        pasienDao.update(pasien);
    }

    @Override
    public void delete(Pasien pasien) {
        pasienDao.delete(pasien);
    }

    @Override
    public long count() {
        return pasienDao.count();
    }  
}
