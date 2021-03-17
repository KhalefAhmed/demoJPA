package com.example.demo.DAO;

import com.example.demo.entity.CandyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CandyDAOImpl implements CandyDAO{

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final String CANDY_ID = "candyId";
    private static final String DELIVERY_ID = "deliveryId";

    private static final String SELECT_ALL_CANDY = "SELECT * FROM candy";

    private static final RowMapper<CandyData> candyDataRowMapper =
            new BeanPropertyRowMapper<>(CandyData.class);

    @Override
    public List<CandyData> list() {
        return jdbcTemplate.query(SELECT_ALL_CANDY, candyDataRowMapper);
    }

    @Override
    public void addToDelivery(Long candyId, Long deliveryid) {

    }

    @Override
    public List<CandyData> findByDelivery(Long deliveryId) {
        return null;
    }
}
