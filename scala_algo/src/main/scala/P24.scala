import scala.collection.immutable.HashSet
import scala.collection.mutable.ListBuffer

/**
 * Created by Jiessie on 14/5/15.
 */
/*
 Lotto: Draw N different random numbers from the set 1..M.
Example:
scala> lotto(6, 49)
res0: List[Int] = List(23, 1, 17, 33, 21, 37)
 */
object P24 {
  def lotto(N:Int,M:Int): List[Int] = {
    if(N>M) throw new NullPointerException
    var seen = HashSet[Int]()
    var list = ListBuffer[Int]()
    val r =  util.Random
    for(i<- 0 until N){
      var number = r.nextInt(M)+1
      while(seen(number)){
        number = r.nextInt(M)+1
      }
      seen+=number
      list+=number
    }
    list.toList
  }

  import P23.randomSelect
  def lottoSelect(count: Int, max: Int): List[Int] =
    randomSelect(count, List.range(1, max + 1))
}
