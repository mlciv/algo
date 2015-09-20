/**
 * Created by Jiessie on 7/5/15.
 */

import java.util.NoSuchElementException

import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}

class TestList extends FeatureSpec with GivenWhenThen with Matchers{

  val list= List(1,2,3,4,5)
  feature("P01-last"){
    scenario("create a list with 1,2,3,4,5"){
      Given("using recursive and :: , match,case")
      P01.lastBuiltin(list) shouldBe 5
      P01.lastRecursive(list) shouldBe 5
    }
  }

  feature("P02-lastNth"){
    scenario("create a list with 1,2,3,4,5, using recursive and :: , match,case"){
      Given("using recursive and :: , match,case")
      P02.lastNthIndex(list,3) shouldBe 3
      P02.lastNthRecursive(list,3) shouldBe 3
    }
    scenario("N> length"){
      try {
        Given("assert excpetion")
        P02.lastNthRecursive(list, 6)
        fail("not throw NoSuchElementException")
      }catch {
        case e:NoSuchElementException => assert(true)
      }

      // assert exception
      intercept[NoSuchElementException]{
        Given("assert excpetion")
        P02.lastNthRecursive(list, 6)
        fail("not throw NoSuchElementException")
      }
    }
  }

  feature("P03-Nth"){
    scenario("N<length"){
      Given("head::tail, pair")
      P03.NthBuiltIn(list,1) shouldBe 2
      P03.NthRecursive(list,1) shouldBe 2
    }
    scenario("N>length"){
      try {
        P03.NthRecursive(list, 6)
        fail("not throw NoSuchElementException for index 6 of length 5")
      }catch {
        case e:NoSuchElementException => assert(true)
      }
    }
  }

  feature("P04-length"){
    scenario("common not empty case"){
      Given("using while")
      P04.lengthBuiltIn(list) shouldBe 5
      P04.lengthCount(list) shouldBe 5
      P04.lengthRecursive(list) shouldBe 5
    }
    scenario("empty case"){
      P04.lengthRecursive(List()) shouldBe 0
      P04.lengthRecursive(Nil) shouldBe 0
    }
  }

  feature("P05-reserved"){
    scenario("reserved a list"){
      Given("using reserve, while,:::")
      P05.reverseBuiltIn(list) shouldBe List(5,4,3,2,1)
      P05.reverseRecursive(list) shouldBe List(5,4,3,2,1)
      P05.reverseInternal(list) shouldBe List(5,4,3,2,1)
    }
  }

  feature("P06-isPalindrome"){
    scenario("check isPalindrome"){
      Given("using reserve, for until, to ")
      P06.isPalindrome(List(1,2,3,2,1)) shouldBe true
      P06.isPalindromeBuiltIn(List(1,2,3,2,1)) shouldBe true
      P06.isPalindrome(List(1,2,3,3,2,1)) shouldBe true
      P06.isPalindrome(List(1)) shouldBe true
      P06.isPalindrome(List()) shouldBe true
    }
  }

  feature("P07-flatten"){
    scenario("make list flatten"){
      Given("using flatMap")
      P07.flatten(List(1,2,List(3,List(4,5,6)),List(7,8,9))) shouldBe List(1,2,3,4,5,6,7,8,9)
    }
  }

  feature("P08-compress"){
    scenario("distinct list"){
      Given("using foldLeft, foldRight")
      P08.compressBuiltIn(List(1,2,3,2,4,3,5)) shouldBe List(1,2,3,4,5)
      P08.compressInternal(List(1,2,3,2,4,3,5)) shouldBe List(1,2,3,4,5)
      P08.compressFunctional(List(1,2,3,2,4,3,5)) shouldBe List(1,2,3,4,5)
    }
  }

  feature("P09-pack sublist"){
    scenario("span sublist"){
      Given("using span")
      P09.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
    }
  }

  feature("P10-lengthEncode"){
    scenario("using pack or span"){
      Given("using span ,::")
      P10.encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
      P10.encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
    }
  }

  feature("P11-ModifiedLengthEncode"){
    scenario("using span"){
      P11.encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
      P11.encodeModifiedWithPack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
    }
  }

  feature("P12-decode"){
    scenario("using flatMap"){
      P12.decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) shouldBe  List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    }
  }

  feature("P13-decode"){
    scenario("using P13"){
      P13.encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
    }
  }

  feature("P14-duplicate"){
    scenario("using flatMap"){
      P14.duplicate(List('a, 'b, 'c, 'c, 'd)) shouldBe List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
    }
  }

  feature("P15-duplicate"){
    scenario("using flatMap and for"){
      Given("using flatMap and for")
      P15.duplicateN(3,List('a, 'b, 'c, 'c, 'd)) shouldBe List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
      P15.duplicateNBuiltin(3,List('a, 'b, 'c, 'c, 'd)) shouldBe List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
    }
  }

  feature("P16-dropEveryN"){
    scenario("using drop"){
      Given("using zipWith, map, recursive and tail recursive")
      P16.dropEveryN(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
      P16.dropEveryNTail(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
      P16.dropFunctional(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
    }
  }

  feature("P17-split at index "){
    scenario("using tailrec or splitAt"){
      P17.split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List(List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      P17.splitBuiltin(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List(List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    }
  }

  feature("P18-slice between range"){
    scenario("using zipWithIndex,map, and builtin slice"){
      P18.slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List('d, 'e, 'f, 'g)
      P18.sliceBuiltin(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List('d, 'e, 'f, 'g)
    }
  }

  feature("P19-rotate at N"){
    scenario("using splitAt and rotate"){
      P19.rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
      P19.rotate2(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
    }
  }

  feature("P20-removeAt"){
    scenario("using removeAt"){
      P20.removeAt(1, List('a, 'b, 'c, 'd)) shouldBe (List('a, 'c, 'd),'b)
      P20.removeAtRecursive(1, List('a, 'b, 'c, 'd)) shouldBe (List('a, 'c, 'd),'b)
    }
  }

  feature("P21-insertAt"){
    scenario("using splitAt and :::, ::"){
      P21.insertAt('new, 1, List('a, 'b, 'c, 'd)) shouldBe List('a, 'new, 'b, 'c, 'd)
    }
  }

  feature("P22-range"){
    scenario("using List.range"){
      P22.rangeBuiltin(4, 9) shouldBe List(4, 5, 6, 7, 8, 9)
      P22.rangeRecursive(4, 9) shouldBe List(4, 5, 6, 7, 8, 9)
      P22.rangeRecursive2(4, 9) shouldBe List(4, 5, 6, 7, 8, 9)
    }
  }

  feature("P23-randomselect"){
    scenario("using removeAt"){
      P23.randomSelect(3,List(1,2,3,4,5)).length shouldBe 3
    }
  }

  feature("P24-randomselect"){
    scenario("using dinstin"){
      P24.lotto(4,10).distinct.length shouldBe 4
    }
  }

  feature("P25-randomPermute"){
    scenario("using randomSelect"){
      println(P25.randomPermute(List(1,2,3,4,5)))
    }
  }

  feature("P26-combination and permute"){
    scenario("using combination"){
      P26.combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)).length shouldBe 20
      P26.permute(3, List('a, 'b, 'c, 'd, 'e, 'f)).length shouldBe 120
    }
  }

  feature("P27-disjointGroup"){
    scenario("using disjoint"){
      Given("shouldBe ((9*8/2)*(7*6/2)) =  "+((9*8/2)*(7*6/2)))
      P27.group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")).length shouldBe ((9*8/2)*(7*6/2))
    }
  }

  feature("P28-lsort, lsortfreq"){
    scenario("using foldLeft,map,HashMap"){
      P28.lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) shouldBe List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
      P28.lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) shouldBe List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('m, 'n))
    }
  }
}
