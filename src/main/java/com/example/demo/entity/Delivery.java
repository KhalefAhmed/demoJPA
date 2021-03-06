package com.example.demo.entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NamedQuery(name = "Delivery.findByName",
        query = "select d from Delivery d where d.name = :name")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Nationalized
    private String name;

    @Column(name = "address_full", length = 500)
    private String address;

    private LocalDateTime deliveryTime; // includes both date and time - simpler than having two separate fields

    @Type(type = "yes_no")
    private Boolean completed= false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Plant> plants;

    public Delivery(String name, String address, LocalDateTime deliveryTime) {
        this.name = name;
        this.address = address;
        this.deliveryTime = deliveryTime;
    }

    public Delivery() {

    }

    public Long getId() {
        return id;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
