package springboot.neuron;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NeuronRepository extends JpaRepository<Neuron, UUID> {

    Optional<Neuron> getByNeuronId(UUID id);
}
