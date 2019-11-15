package com.je.spring.rest.dao;

import com.je.spring.rest.model.Pasien;
import java.util.List;

import java.io.Serializable;

public interface PasienDao {
    public List<Pasien>getAll();
    public Pasien getById_pasien(int id_pasien);
    public void insert(Pasien pasien);
    public void update(Pasien pasien);
    public void delete(Pasien pasien);
    public long count();
}
