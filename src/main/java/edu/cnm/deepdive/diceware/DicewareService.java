package edu.cnm.deepdive.diceware;

import edu.cnm.deepdive.security.Diceware;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DicewareService implements PassphraseService {

  @Autowired
  private RngProvider provider;

  private Diceware diceware;

  @PostConstruct //run after autowire and automaticly invoke init
  private void init() {
    diceware = new Diceware();
    diceware.setRng(provider.getRnd());
  }

  @Override
  public String generate(int length, String delimiter, boolean duplicatesAllowed) {
    return diceware.generate(length, delimiter, duplicatesAllowed);
  }

  @Override
  public String[] generate(int length, boolean duplicatesAllowed) {
    return diceware.generate(length, duplicatesAllowed);
  }
}
