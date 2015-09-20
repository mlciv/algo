import scala.collection.mutable

/**
 * Created by Jiessie on 19/5/15.
 */
/*
 Gray code.
An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,
n = 1: C(1) = ("0", "1").
n = 2: C(2) = ("00", "01", "11", "10").
n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").
Find out the construction rules and write a function to generate Gray codes.

scala> gray(3)
res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)
See if you can use memoization to make the function more efficient.
 */
object P49 {
  def grayR(n:Int): List[String] = n match{
    case 0 => List("")
    case n => val gn = grayR(n-1);gn.map(x=>"0"+x):::gn.reverse.map(x=>"1"+x)
  }

  def grayM(n:Int): List[String]={
    val a = mutable.Map(0->List(""))
    for(i<-1 to n){
      a(i) = a(i-1).map(x=>"0"+x):::a(i-1).reverse.map(x=>"1"+x)
    }
    a(n)
  }

  def main(args: Array[String]) {
    println(grayR(3))
    println(grayM(3))
  }
}
