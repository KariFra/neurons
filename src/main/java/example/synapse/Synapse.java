package example.synapse;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "synapses")
public class Synapse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID synapseId;
    @Column(name = "type")
    private SynapseType type;
    @Column(name = "plasticityChanged")
    private boolean plasticityChanged;
    @Column(name = "transmitterAvailable")
    private boolean transmitterAvailable;
    @Column(name = "voltageDifference")
    private int voltageDifference;
}
