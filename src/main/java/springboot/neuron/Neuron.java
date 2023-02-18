package springboot.neuron;


import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "neurons")
public class Neuron {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID neuronId;
    @Column(name = "position")
    private String position;
    @Column(name = "isWorking")
    private boolean isWorking;
    @Column(name = "created")
    private OffsetDateTime created;
    @Column(name = "modified")
    private OffsetDateTime modified;

    public Neuron(String position, boolean isWorking, OffsetDateTime created, OffsetDateTime modified) {
        this.position = position;
        this.isWorking = isWorking;
        this.created = created;
        this.modified = modified;
    }
}
