package makecouples.couples.domain.model;


import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pair {

  List<Participant> pair;

  public Pair(List<Participant> participants) {
    this.pair = new ArrayList<>(participants);
  }

}
