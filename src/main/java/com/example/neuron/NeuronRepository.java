package com.example.neuron;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeuronRepository extends JpaRepository<Neuron,Long> {
}
