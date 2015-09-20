/**
 * Created by Jiessie on 15/5/15.
 */
/*
Determine whether a given integer number is prime.
scala> 7.isPrime
res0: Boolean = true
 */
object P31 {

  def isPrime(number:Int): Boolean = {
    if(Math.abs(number)==1) false else Range.Int.apply(2,Math.sqrt(number).ceil.toInt+1,1).filter(x=>(number%x==0)&&(x!=number)).isEmpty
  }

  def isPrime2(start:Int): Boolean = {
    val primes = Stream.cons(2, Stream.from(3, 2) filter { isPrime2(_) })
    (start > 1) && (primes takeWhile { _ <= Math.sqrt(start) } forall { start % _ != 0 })
  }

  def main(args: Array[String]) {
    println(Range.Int.apply(2,100,1).map(isPrime));
    println(isPrime(4))
    println(isPrime2(10))
  }
}
