package com.example.demo.DAO;

import com.example.demo.entity.CandyData;

import java.util.List;

public interface CandyDAO {

    List<CandyData> list();
    void addToDelivery(Long candyId, Long deliveryid);
    List<CandyData> findByDelivery(Long deliveryId);
}
