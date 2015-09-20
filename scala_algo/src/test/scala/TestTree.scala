import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}

/**
 * Created by Jiessie on 29/5/15.
 */
class TestTree extends FeatureSpec with GivenWhenThen with Matchers{

  feature("cBalance"){
    scenario("even nodes") {
      Tree.cBalanced(4, "x").toString shouldBe "List(T(x T(x . .) T(x . T(x . .))), T(x T(x . T(x . .)) T(x . .)), T(x T(x . .) T(x T(x . .) .)), T(x T(x T(x . .) .) T(x . .)))"
    }
  }

  feature("isSymmetric"){
    scenario("recursive"){
      Tree.Node('a', Tree.Node('b'), Tree.Node('c')).isSymmetric shouldBe true
    }
  }

  feature("binary search tree"){
    scenario("bin search tree"){
      Tree.fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric shouldBe true
    }
  }

  feature("generate and test symmetrical"){
    scenario("using isSymmetric and cBalanced"){
      Tree.symmetricBalancedTrees(5, "x").toString shouldBe "List(T(x T(x . T(x . .)) T(x T(x . .) .)), T(x T(x T(x . .) .) T(x . T(x . .))))"
    }
  }
}
