/**
 * Created by Jiessie on 15/5/15.
 */
/*
Determine whether two positive integer numbers are coprime.
Two numbers are coprime if their greatest common divisor equals 1.
scala> 35.isCoprimeTo(64)
res0: Boolean = true
 */
object P33 {
  def isCoprimeTo(a:Int,b:Int):Boolean = P32.gcd(a,b)==1
}
