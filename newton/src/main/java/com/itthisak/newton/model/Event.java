package com.itthisak.newton.model;

import java.time.LocalDateTime;
import java.util.List;

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
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Camera> cameras;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int camera_id,amount;
    private LocalDateTime created_at;

    public Event(int camera_id, int amount){
        this.camera_id =camera_id;
        this.amount = amount;
        this.created_at = LocalDateTime.now();
    }
}
