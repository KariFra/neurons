package com.example.neuron;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "neurons")
public class Neuron {

    @Id
    @GeneratedValue(generator="my_seq_gen")
    @SequenceGenerator(name="my_seq_gen", sequenceName="neuronal_seq", allocationSize=1)
    private Long id;
    @Column(name = "position")
    private String position;
    @Column(name = "isWorking")
    private boolean isWorking;

    public Neuron(String position, boolean isWorking) {
        this.position = position;
        this.isWorking = isWorking;
    }
}
