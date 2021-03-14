package com.example.demo;

import com.example.demo.entity.Delivery;
import com.example.demo.entity.Plant;
import com.example.demo.repository.PlantRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
public class ApplicationTests {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PlantRepository plantRepository;

    @Test
    public void testDeliveryCompleted() {
        Plant p = testEntityManager.persist(new Plant("Baz Root", 9.99));
        Delivery d = testEntityManager.persist(new Delivery("Leonard Bernstein", "234 West Side", LocalDateTime.now()));

        d.setPlants(Lists.newArrayList(p));
        p.setDelivery(d);


        Assertions.assertFalse(plantRepository.deliveryCompleted(p.getId()));
        d.setCompleted(true);

        Assertions.assertTrue(plantRepository.deliveryCompleted(p.getId()));

    }



}
