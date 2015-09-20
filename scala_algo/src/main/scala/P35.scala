/**
 * Created by Jiessie on 18/5/15.
 */
/*
 Determine the prime factors of a given positive integer.
Construct a flat list containing the prime factors in ascending order.
scala> 315.primeFactors
res0: List[Int] = List(3, 3, 5, 7)
 */
object P35 {
  def primeFactors(number:Int): List[Int] ={
    (2 to number) filter({x=>P31.isPrime(x)&&number%x==0}) flatMap(x=>{
      var tempNumber = number
      var list = List.newBuilder[Int]
      while(tempNumber%x==0){
        tempNumber = tempNumber/x
        list+=x
      }
      list.result()
    }) toList
  }

  def main(args: Array[String]) {
    println(primeFactors(315))
  }
}
