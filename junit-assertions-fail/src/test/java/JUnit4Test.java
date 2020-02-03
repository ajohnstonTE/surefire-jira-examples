import org.junit.Assert;
import org.junit.Test;

public class JUnit4Test {

  /**
   * `mvn -q -Dtest=JUnit4Test#failWithNoParameters test`
   */
  @Test
  public void failWithNoParameters() {
    Assert.fail();
  }

  /**
   * `mvn -q -Dtest=JUnit4Test#failWithNonEmptyParameters test`
   */
  @Test
  public void failWithNonEmptyParameters() {
    Assert.fail("not empty");
  }
}
