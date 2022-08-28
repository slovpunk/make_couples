package makecouples.couples.domain.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Groups {

  List<Pair> pairs;
  Triple triple;

  public Groups(List<Pair> participants, Triple triple) {
    this.pairs = new ArrayList<>(participants);
    this.triple = triple;
  }
}
