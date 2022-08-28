package makecouples.couples.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Класс, который отвечает за сохранение последовательности случайного порядка участников
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "checking")
public class ConsequenceOfParticipants {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String consequence;

  public ConsequenceOfParticipants(String consequence) {
    this.consequence = consequence;
  }

}
