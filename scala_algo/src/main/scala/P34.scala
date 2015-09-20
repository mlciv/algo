/**
 * Created by Jiessie on 15/5/15.
 */
/*
Calculate Euler's totient function phi(m).
Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
scala> 10.totient
res0: Int = 4
 */
object P34 {
  def totient(start:Int): Int = (1 to start) filter { P33.isCoprimeTo(_,start) } length
  def totient1(start:Int): Int = (1 to start) map(x=>(if(P33.isCoprimeTo(x,start)) 1 else 0)) reduce(_+_)
}
