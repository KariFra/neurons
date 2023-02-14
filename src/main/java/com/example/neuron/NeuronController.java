package com.example.neuron;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/impuls")
@RequiredArgsConstructor
public class NeuronController {

    private final NeuronService neuronService;

   @GetMapping(value = "/{id}")
    public ResponseEntity<Neuron> getNeuron(@PathVariable("id") Long id){
      return ResponseEntity.ok(neuronService.getNeuron(id));
    }

    @GetMapping()
    public ResponseEntity<List<Neuron>> getAllNeurons(){
        return ResponseEntity.ok(neuronService.getAll());
    }

    @DeleteMapping()
    public ResponseEntity deleteNeuronsWithIds(@RequestParam List<Long> ids){
       neuronService.deleteNeurons(ids);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Neuron> createNeuron(){
        return ResponseEntity.ok(neuronService.createNeuron());
    }
}
