package com.garanti.FirstSpringWeb.repo;

import com.garanti.FirstSpringWeb.model.Ders;
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
public class DersRepo {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Ders> getAll() {
        return jdbcTemplate.query("select * from BILGE.DERS", BeanPropertyRowMapper.newInstance(Ders.class));
    }

    public Ders getById(int id) {
        Ders ders = null;
        String sql = "select * from BILGE.DERS where ID = :ID";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ID", id);
        ders = namedParameterJdbcTemplate.queryForObject(sql, paramMap, BeanPropertyRowMapper.newInstance(Ders.class));
        return ders;
    }

    public boolean save(Ders ders) {

        String sql = "Insert Into BILGE.DERS (OGR_ID,KONU_ID) (:OGRID,:KONUID)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("OGRID", ders.getOGR_ID());
        paramMap.put("KONUID", ders.getKONU_ID());
        return namedParameterJdbcTemplate.update(sql, paramMap) == 1;

    }

    public boolean deleteById(int id) {

        String sql = "delete from BILGE.DERS where ID = :ID";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ID", id);
        return namedParameterJdbcTemplate.update(sql, paramMap) == 1;

    }

    public List<Ders> getAllLike(int konuId) {
        String sql = "select * from BILGE.DERS where KONU_ID = :KONUID";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("KONUID", konuId);
        return namedParameterJdbcTemplate.query(sql, paramMap, BeanPropertyRowMapper.newInstance(Ders.class));
    }
}
