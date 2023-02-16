package example.neuron;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NeuronDto {
    private Long neuronId;
    private String position;
    private boolean isWorking;
}
