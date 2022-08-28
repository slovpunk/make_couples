package makecouples.couples.domain.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Triple {

  List<Participant> triple;

  public Triple(List<Participant> participants) {
    this.triple = new ArrayList<>(participants);
  }

}
