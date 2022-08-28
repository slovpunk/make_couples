package makecouples.couples.domain.repositories;

import makecouples.couples.domain.model.ConsequenceOfParticipants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsequenceRepository extends JpaRepository<ConsequenceOfParticipants, Long> {

}
