
package com.je.spring.rest.dao.impl;

import com.je.spring.rest.dao.PasienDao;
import com.je.spring.rest.model.Pasien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("pasienDao")
public class PasienDaoImpl implements PasienDao {
    private static final String SQL_INSERT_PASIEN = "INSERT INTO _pasien (id_pasien,pasien_nama,pasien_alamat,pasien_tgllahir,pasien_notlp,pasien_jenkel,pasien_agama) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_PASIEN_BY_ID_PASIEN = "SELECT id_pasien,pasien_nama,pasien_alamat,pasien_tgllahir,pasien_notlp,pasien_jenkel,pasien_agama FROM _pasien WHERE id_pasien = ?";
    private static final String SQL_SELECT_PASIEN_ALL = "SELECT id_pasien,pasien_nama,pasien_alamat,pasien_tgllahir,pasien_notlp,pasien_jenkel,pasien_agama FROM _pasien ";
    private static final String SQL_UPDATE_PASIEN = "UPDATE _pasien SET id_pasien=? ,pasien_nama=? ,pasien_alamat=? ,pasien_tgllahir=? ,pasien_notlp=? ,pasien_jenkel=? ,pasien_agama=? WHERE id_pasien=? ";
    private static final String SQL_DELETE_PASIEN = "DELETE FROM _pasien WHERE id_pasien = ?";
    private static final String SQL_COUNT_PASIEN = "SELECT COUNT(*) FROM _pasien ";
    
     @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Pasien> getAll() {
    List<Pasien> pasienList = null;
        try{
    	
            	pasienList = jdbcTemplate.query(SQL_SELECT_PASIEN_ALL, new Object[]{}, new BeanPropertyRowMapper(Pasien.class));      
            
            
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
        
        return pasienList;
    }
    

    @Override
    public Pasien getById_pasien(int id_pasien) {
    Pasien pasien = null;
    	try{
    		
    		  
    		   pasien = (Pasien) jdbcTemplate.queryForObject(SQL_SELECT_PASIEN_BY_ID_PASIEN,new Object[]{id_pasien},new RowMapper<Pasien>(){
                        public Pasien mapRow(ResultSet rs, int rowNum)throws SQLException {
	        				Pasien pasien = new Pasien();
	        				pasien.setId_pasien(rs.getInt("id_pasien"));
	        				pasien.setPasien_nama(rs.getString("pasien_nama"));
	        				pasien.setPasien_alamat(rs.getString("pasien_alamat"));
	        				pasien.setPasien_tgllahir(rs.getString("pasien_lahir"));
                                                pasien.setPasien_notlp(rs.getString("pasien_notlp"));
                                                pasien.setPasien_jenkel(rs.getString("pasien_jenkel"));
                                                pasien.setPasien_agama(rs.getString("pasien_agama"));
                                                
                                                return pasien;
	        			}
                   });
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return pasien;
    }

    @Override
    public void insert(Pasien pasien) {
         try{
    		 jdbcTemplate.update(SQL_INSERT_PASIEN, new Object[]{pasien.getId_pasien(),pasien.getPasien_nama(),pasien.getPasien_alamat(),pasien.getPasien_tgllahir(),pasien.getPasien_notlp(),pasien.getPasien_jenkel(),pasien.getPasien_agama()});  	
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
    }

    @Override
    public void update(Pasien pasien) {
        
         try{
    		 jdbcTemplate.update(SQL_UPDATE_PASIEN, new Object[]{pasien.getPasien_nama(),pasien.getPasien_alamat(),pasien.getPasien_tgllahir(),pasien.getPasien_notlp(),pasien.getPasien_jenkel(),pasien.getPasien_agama(),pasien.getId_pasien()});  	
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
    }

    @Override
    public void delete(Pasien pasien) {
        try{
			jdbcTemplate.update(SQL_DELETE_PASIEN, new Object[]{pasien.getId_pasien()});
		 }catch(Exception e){
			 e.printStackTrace();
		 }
    }

    @Override
    public long count() {
           long count = 0;
            try{


                    count = jdbcTemplate.queryForObject(SQL_COUNT_PASIEN, null,Long.class);

            }catch(Exception e){
                    e.printStackTrace();
            }
            return count;
    }
    
}

