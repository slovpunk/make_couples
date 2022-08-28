package makecouples.couples.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import makecouples.couples.domain.model.Checking;
import makecouples.couples.domain.model.Groups;
import makecouples.couples.domain.model.Pair;
import makecouples.couples.domain.model.Participant;
import makecouples.couples.domain.model.Triple;
import makecouples.couples.domain.repositories.ConsequenceRepository;
import makecouples.couples.domain.repositories.ParticipantsRepositories;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MakeCouplesInterfaceImpl implements
    MakeCouplesInterface {


  private final ParticipantsRepositories repositories;
  private final ConsequenceRepository consequenceRepository;
  private List<Participant> participants = new ArrayList<>();

  private boolean check() {

    participants = repositories.findAll();
    Collections.shuffle(participants);
    var numberOfSequence = participants.stream().map(e -> {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(e.getId());
      return stringBuilder.toString();
    }).reduce((x, y) -> x + y);

    var sequences = consequenceRepository.findAll();

    if (sequences.stream().anyMatch(e -> e.getConsequence().equals(numberOfSequence.get()))
        && sequences.size() > 500) {
      return false;
    }
    consequenceRepository.save(new Checking(numberOfSequence.get()));
    return true;
  }


  public Groups getAll() {

    while(check()) {

    }

    var firstPair = participants.stream().limit(2).collect(Collectors.toList());
    var pair1 = new Pair(firstPair);
    participants.removeAll(firstPair);

    var secondPair = participants.stream().limit(2).collect(Collectors.toList());
    var pair2 = new Pair(secondPair);
    participants.removeAll(secondPair);


    var remains = participants.stream().limit(3).collect(Collectors.toList());
    var triple = new Triple(remains);


    List<Pair> commonPairsList = new ArrayList<>();
    commonPairsList.add(pair1);
    commonPairsList.add(pair2);

    return new Groups(commonPairsList, triple);
  }

}
