package makecouples.couples.domain.repositories;

import makecouples.couples.domain.model.Checking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsequenceRepository extends JpaRepository<Checking, Long> {

}
