/**
 * Created by pradeepsanchana on 07/04/18.
 */
object LearningScala4  {

  def count_sets(w: Array[Int],total:Int): Int =  {
    // Complete this function
    var mem = scala.collection.mutable.Map[String,Int]()
    rec(w, total,w.length-1, mem)
  }
  def rec(w:Array[Int], total:Int,i:Int, mem:scala.collection.mutable.Map[String,Int]): Int ={
    var to_ret=0
    val key = total.toString +":" + i.toString
    if(mem.contains(key))
      return mem(key)
    if(total ==0)
      to_ret = 1
    else if (total < 0)
        return 0

     else if(i < 0)
      return 0
    else if(total < w(i))
       to_ret = rec(w, total , i-1 ,mem)
    else
      to_ret = rec(w, total - w(i), i-1,mem) + rec(w, total , i-1 ,mem)
    mem(key) = to_ret
    return to_ret
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var total = sc.nextInt()
    var w = new Array[Int](n);
    for(w_i <- 0 to n-1) {
      w(w_i) = sc.nextInt();
    }
    val result = count_sets(w,total);
    println(result)
  }
}
