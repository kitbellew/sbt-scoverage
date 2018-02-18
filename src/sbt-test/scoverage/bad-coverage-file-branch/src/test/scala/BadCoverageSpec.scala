import org.specs2.mutable._

/**
 * Created by tbarke001c on 7/8/14.
 */
class BadCoverageSpec extends Specification {

  "BadCoverage" should {
    "sum two numbers" in {
      one.BadCoverage.sum(1, 2) mustEqual 3
      one.BadCoverage.sum(0, 3) mustEqual 3
      one.BadCoverage.sum(3, 0) mustEqual 3
      two.BadCoverage.sum(1, 2) mustEqual 3
      two.BadCoverage.sum(3, 0) mustEqual 3
    }
  }
}
