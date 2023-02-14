package com.example.neuron;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class NeuronService {

    private final NeuronRepository neuronRepository;

    public Neuron getNeuron(Long id){
        return neuronRepository.getReferenceById(id);
    }

    public Neuron createNeuron(){
        int number = new  Random().nextInt(1663335);
        String position = "somewhere" + number;
        var neuron = new Neuron(position,true);
        return  neuronRepository.save(neuron);
    }

    public List<Neuron> getAll(){
        return neuronRepository.findAll();
    }

    public void deleteNeurons(List<Long> ids){
        neuronRepository.deleteAllById(ids);
    }

}
