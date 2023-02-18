package springboot.neuron;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NeuronDto {
    private UUID neuronId;
    private String position;
    private boolean isWorking;
}
