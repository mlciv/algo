import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}

/**
 * Created by Jiessie on 15/5/15.
 */
class TestArithmetic  extends FeatureSpec with GivenWhenThen with Matchers{
  feature("P31- isPrime"){
    scenario("check number isPrime by % (2,sqrt(number))"){
      Range.Int.apply(2,7,1).map(P31.isPrime) shouldBe Vector(true, true, false, true, false)
      Range.Int.apply(2,7,1).map(P31.isPrime2) shouldBe Vector(true, true, false, true, false)
      P31.isPrime(1) shouldBe false
      P31.isPrime(2) shouldBe true
    }
  }

  feature("P32- gcd"){
    scenario("P32- Euclid's algorithm"){
      P32.gcd(36,63) shouldBe 9
    }
  }

  feature("P33- coPrime"){
    scenario("P33 -coprime") {
      P33.isCoprimeTo(32, 19) shouldBe true
      P33.isCoprimeTo(24,12) shouldBe false
    }
  }
  feature("P34-toTient"){
    scenario("the number of positive integers r (1 <= r <= m) that are coprime to m"){
      P34.totient(10) shouldBe 4
      P34.totient1(10) shouldBe 4
    }
  }

  feature("P35-primeFactors"){
    scenario("the primeFactors of the number"){
      P35.primeFactors(315) shouldBe List(3,3,5,7)
    }
  }

  feature("P36-primeFactorMultiplicity"){
    scenario("the primeFactorMultiplicity of the number"){
      P36.primeFactorMultiplicity(315) shouldBe  List((3,2), (5,1), (7,1))
    }
  }
}
