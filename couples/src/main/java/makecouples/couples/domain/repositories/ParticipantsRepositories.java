package makecouples.couples.domain.repositories;


import java.util.List;
import makecouples.couples.domain.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantsRepositories extends JpaRepository<Participant, Long> {

  List<Participant> findAll();

}
