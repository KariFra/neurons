package example.neuron;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/neuron")
@RequiredArgsConstructor
public class NeuronController {

    private final NeuronService neuronService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<NeuronDto> getNeuron(@PathVariable("id") Long id) {
        return ResponseEntity.ok(neuronService.getNeuron(id));
    }

    @GetMapping()
    public ResponseEntity<List<NeuronDto>> getAllNeurons() {
        return ResponseEntity.ok(neuronService.getAll());
    }

    @DeleteMapping()
    public ResponseEntity deleteNeuronsWithIds(@RequestParam List<Long> ids) {
        neuronService.deleteNeurons(ids);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity createNeuron() {
        var createdNeuron = neuronService.createNeuron();
        var headers = new HttpHeaders();
        headers.add("location", "http://localhost:8081/api/" + createdNeuron.getNeuronId());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity updateNeuron(@RequestBody NeuronDto neuronDto) {
        neuronService.updateNeuron(neuronDto);
        var headers = new HttpHeaders();
        headers.add("location", "http://localhost:8081/api/" + neuronDto.getNeuronId());
        return new ResponseEntity(headers,HttpStatus.NO_CONTENT);
    }
}
