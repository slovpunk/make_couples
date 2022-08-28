package makecouples.couples.infra;

import lombok.RequiredArgsConstructor;
import makecouples.couples.application.MakeCouplesService;
import makecouples.couples.domain.model.Groups;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MakeCouplesController {

  private final MakeCouplesService makeCouplesService;


@GetMapping("/participants")
  public Groups getResult() {

  return makeCouplesService.getGroupsOfParticipants();
}
}
