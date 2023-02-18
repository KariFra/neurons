package springboot.synapse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SynapseDto {
    private Long synapseId;
    private SynapseType type;
    private boolean plasticityChanged;
    private boolean transmitterAvailable;
    private int voltageDifference;
}
