/**
 * Created by Jiessie on 13/5/15.
 */
/*
Find out whether a list is a palindrome.
Example:
scala> isPalindrome(List(1, 2, 3, 2, 1))
res0: Boolean = true
 */
object P06 {
  def isPalindrome[T](list:List[T]): Boolean = {
    if(list == Nil) true else {
      val length = list.length
      val half = list.length/2
      var flag = true
      var i=0
      for(i<- 0 until half){
        if(list(i)!=list(length-1-i)) flag = false
      }
      flag
    }
  }

  def isPalindromeBuiltIn[T](list:List[T]):Boolean = list == list.reverse

}
