package springboot.neuron;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NeuronService {

    private final NeuronRepository neuronRepository;
    private final ObjectMapper objectMapper;

    public NeuronDto getNeuron(UUID id) {
        return objectMapper.convertValue(neuronRepository.getByNeuronId(id), NeuronDto.class);
    }

    public NeuronDto createNeuron() {
        int number = new Random().nextInt(1663335);
        var position = "somewhere" + number;
        var neuron = new Neuron(position, true, OffsetDateTime.now(),null);
        return objectMapper.convertValue(neuronRepository.save(neuron), NeuronDto.class);
    }

    public void updateNeuron(NeuronDto neuronDto) {
        var existingNeuron = neuronRepository.findById(neuronDto.getNeuronId());
        existingNeuron.ifPresentOrElse(neuron -> {
                    neuron.setWorking(neuronDto.isWorking());
                    neuron.setPosition(neuronDto.getPosition());
                    neuron.setModified(OffsetDateTime.now());
                    neuronRepository.save(neuron);
                }, () -> {
                    throw new EntityNotFoundException();
                }
        );
    }

    public List<NeuronDto> getAll() {
        return neuronRepository.findAll().stream()
                .map(neuron -> objectMapper.convertValue(neuron, NeuronDto.class))
                .collect(Collectors.toList());
    }

    public void deleteNeurons(List<UUID> ids) {
        neuronRepository.deleteAllById(ids);
    }

}
