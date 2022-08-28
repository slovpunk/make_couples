package makecouples.couples.infra.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import makecouples.couples.application.MakeCouplesService;
import makecouples.couples.domain.model.ConsequenceOfParticipants;
import makecouples.couples.domain.model.Groups;
import makecouples.couples.domain.model.Pair;
import makecouples.couples.domain.model.Participant;
import makecouples.couples.domain.model.Triple;
import makecouples.couples.domain.repositories.ConsequenceRepository;
import makecouples.couples.domain.repositories.ParticipantsRepositories;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MakeCouplesServiceImpl implements
    MakeCouplesService {


  private final ParticipantsRepositories repositories;
  private final ConsequenceRepository consequenceRepository;

  private List<Participant> getRandomListOfUsers() {

    List<ConsequenceOfParticipants> allConsequences = consequenceRepository.findAll();
    List<Participant> allParticipants = repositories.findAll();
    Collections.shuffle(allParticipants);
    var consequencesOfId = makeConsequenceOfUserId(allParticipants);
    while (checkExistConsequence(allConsequences, consequencesOfId)) {
      getRandomListOfUsers();
    }
    consequenceRepository.save(new ConsequenceOfParticipants(consequencesOfId.get()));
    return allParticipants;
  }

  private boolean checkExistConsequence(List<ConsequenceOfParticipants> consequence,
      Optional<String> sequencesOfId) {

    return sequencesOfId.filter(
        s -> consequence.stream().anyMatch(e -> e.getConsequence().equals(s))).isPresent();
  }

  private Optional<String> makeConsequenceOfUserId(List<Participant> participants) {

    return participants.stream().map(e -> {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(e.getId());
      return stringBuilder.toString();
    }).reduce((x, y) -> x + y);

  }


  public Groups getGroupsOfParticipants() {

    var participants = getRandomListOfUsers();

    var firstPair = participants.stream().limit(2).collect(Collectors.toList());
    var pair1 = new Pair(firstPair);
    participants.removeAll(firstPair);

    var secondPair = participants.stream().limit(2).collect(Collectors.toList());
    var pair2 = new Pair(secondPair);
    participants.removeAll(secondPair);

    var triple = new Triple(participants.stream().limit(3).collect(Collectors.toList()));

    List<Pair> allPairs = new ArrayList<>();
    allPairs.add(pair1);
    allPairs.add(pair2);

    return new Groups(allPairs, triple);
  }

}
