package dynamic

import scala.collection.mutable.HashMap

/**
 * Created by pradeepsanchana on 05/05/18.
 */
object CountSubsetSum {

  def countTotal(A:Array[Int],tot:Int)={
    var h =   HashMap[String,Int]()
    cal(A,tot,A.length-1,h)
  }
  def cal(A:Array[Int],tot:Int,i:Int,h:HashMap[String,Int]):Int={
    var key = tot.toString + ":" + i.toString
    var to_return:Int = 0
    if(h.contains(key))
      return h(key)
    if(tot==0)
      return 1
    else if(tot<0 || i<0)
      return 0
    else if(tot < A(i)){
      to_return = cal(A,tot,i-1,h)
    }
    else{
      to_return = cal(A,tot-A(i),i-1,h) + cal(A,tot,i-1,h)
    }
    h += ((key, to_return))
    to_return

  }
  def main(args: Array[String]) {
    println(countTotal(Array(2,4,6,10),16))
    println(countTotal(Array(1,2,3,4,5,6,7,8,9),9))
  }
}
