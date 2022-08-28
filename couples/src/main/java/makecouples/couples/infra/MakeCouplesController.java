package makecouples.couples.infra;

import java.util.List;
import lombok.RequiredArgsConstructor;
import makecouples.couples.application.MakeCouplesInterface;
import makecouples.couples.domain.model.Groups;
import makecouples.couples.domain.model.Participant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MakeCouplesController {

  private final MakeCouplesInterface makeCouplesInterface;


@GetMapping("/participants")
  public Groups getAllParticipant() {

  return makeCouplesInterface.getAll();
}
}
