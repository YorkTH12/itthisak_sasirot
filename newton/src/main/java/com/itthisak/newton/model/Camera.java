package com.itthisak.newton.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Camera {

    @ManyToOne
    @JoinColumn(name="camera_id")
    private Event event;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ip_address, name, location;

    public Camera(String ip_address, String name, String location){
        this.ip_address = ip_address;
        this.name = name;
        this.location =location;
    }
}
