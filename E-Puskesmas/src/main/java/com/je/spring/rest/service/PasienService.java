/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.service;

import com.je.spring.rest.model.Pasien;
import java.util.List;

/**
 *
 * @author AJ.P
 */
public interface PasienService {
    public List<Pasien>getAll();
    public Pasien getById_pasien(int id_pasien);
    public void insert(Pasien pasien);
    public void update(Pasien pasien);
    public void delete(Pasien pasien);
    public long count();
}
