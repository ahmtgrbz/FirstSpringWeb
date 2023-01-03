package com.garanti.FirstSpringWeb.repo;

import com.garanti.FirstSpringWeb.model.Ders_Ogrenci;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class Ders_OgrenciRepo {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Ders_Ogrenci> getAll() {
        return jdbcTemplate.query("select * from BILGE.DERS_OGRENCI", BeanPropertyRowMapper.newInstance(Ders_Ogrenci.class));
    }

    public Ders_Ogrenci getById(int id) {
        Ders_Ogrenci dersOgrenci = null;
        String sql = "select * from BILGE.DERS_OGRENCI where ID = :ID";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ID", id);
        dersOgrenci = namedParameterJdbcTemplate.queryForObject(sql, paramMap, BeanPropertyRowMapper.newInstance(Ders_Ogrenci.class));
        return dersOgrenci;
    }

    public boolean save(Ders_Ogrenci dersOgrenci) {
        String sql = "Insert Into BILGE.DERS_OGRENCI (DERS_ID,OGRENCI_ID) values (:DERSID,:OGRENCIID)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("DERSID", dersOgrenci.getDERS_ID());
        paramMap.put("OGRENCIID", dersOgrenci.getOGRENCI_ID());
        return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
    }

    public boolean deleteById(int id) {
        String sql = "delete from BILGE.DERS_OGRENCI where ID = :ID";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ID", id);
        return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
    }

}
