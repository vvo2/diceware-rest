package edu.cnm.deepdive.diceware;

import java.security.SecureRandom;
import java.util.Random;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope  //supply
public class SecureRandomService implements RngProvider{

  private Random rng = new SecureRandom();

  @Override
  public Random getRnd() {
    return null;
  }
}
