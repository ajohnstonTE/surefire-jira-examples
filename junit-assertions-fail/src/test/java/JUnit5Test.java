import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUnit5Test {

  /**
   * `mvn -q -Dtest=JUnit5Test#failWithNoParameters test`
   */
  @Test
  void failWithNoParameters() {
    Assertions.fail();
  }

  /**
   * `mvn -q -Dtest=JUnit5Test#failWithNonEmptyParameters test`
   */
  @Test
  void failWithNonEmptyParameters() {
    Assertions.fail("not empty");
  }
}
