package com.itthisak.newton.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Camera {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String ipaddress;
    private String name;
    private String location;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "camera")
    private List<Event> events;

    

    
}
