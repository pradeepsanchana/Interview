package recursion

import scala.collection.mutable._
/**
 * Created by pradeepsanchana on 25/08/18.
 */
object UniqPermute {
  def main(args:Array[String]):Unit ={

    print(solution(1003))
  }
  def solution(a:Int):Int = {
    var  orig =a
    var alen =0

    var h =   HashMap[Int,Int]()
    var key = orig/10
    h += ((key, 1))
    while(orig!= 0){
      alen += 1
      key= orig/10
      if(h.contains(key)){
        var count = h(key)
        h += ((key,count+1))
      } else {
        h += ((key, 1))
      }
      orig /=10
    }
    var res = 1
    for(touple <- h){
      res *= factorial(touple._2)
    }
    //if(h.get
    safeDiv(factorial(alen),res) - factorial(h.get(0).get)
  }
  def factorial(n: Int): Int = {
    if (n == 0)
      return 1
    else
      return n * factorial(n-1)
  }
  def safeDiv: PartialFunction[(Int, Int), Int] = {
    case(a,b) if b != 0.0 => a/b

  }
}