package edu.cnm.deepdive.diceware;

import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diceware")
public class DicewareController {

  @Autowired
  private PassphraseService service;

  @GetMapping(produces = "text/plain")  // (produces is a content negotiation)
  public String generate(
      @RequestParam(value = "length", defaultValue = "6") int length,
      @RequestParam(value = "delimiter", defaultValue = " ") String delimiter,
      @RequestParam(value = "duplicates", defaultValue = "true") boolean duplicatesAllowed) {
    return service.generate(length, delimiter, duplicatesAllowed);
  }

  //@RequestMapping(value = "/diceware/raw", method = RequestMethod.GET)
  @GetMapping(produces = "application/json")
  public String[] generate( // (produces is a content negotiation)
      @RequestParam(value = "length", defaultValue = "6") int length,
      @RequestParam(value = "duplicates", defaultValue = "true") boolean duplicatesAllowed) {
    return service.generate(length, duplicatesAllowed);
  }
}
