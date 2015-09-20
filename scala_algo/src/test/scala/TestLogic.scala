import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}

/**
 * Created by Jiessie on 15/5/15.
 */
class TestLogic  extends FeatureSpec with GivenWhenThen with Matchers{
  feature("P49- gray"){
    scenario(" pay attention to rules"){
      P49.grayM(3) shouldBe List("000", "001", "011", "010", "110", "111", "101", "100")
      P49.grayR(3) shouldBe List("000", "001", "011", "010", "110", "111", "101", "100")
    }
  }
}
