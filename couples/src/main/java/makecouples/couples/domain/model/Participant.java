package makecouples.couples.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant {

  @Id
  @JsonIgnore
  private Long id;
  private String name;

}
