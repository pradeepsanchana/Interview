import scala.collection.mutable.HashMap
object Solution1 {
  def tot_count(A:Array[Int] ,tot:Int, h:HashMap[String,Int]):Int={
    return cal(A,tot,A.length-1,h)
  }
  def cal (A:Array[Int], tot:Int, i:Int, h:HashMap[String,Int]):Int ={
    //val key = tot.toString + ":" + i.toString
    //if(h.contains(key))
    //  return h(key)
    var to_ret:Int=0
    if(tot ==0){
     // println("I am last:"+i)
      return 0

    }
    else if(tot <0 || i<0)
      return 0
    else if(tot < A(0) && i != 0)
      return 1
    else if(tot < A(i)){
      return cal (A,tot,i-1,h)
      //      to_ret = cal (A,tot,i-1,h)
   //   if(tot <= A.min)
   //     return i+1
   //   else

    }

    else
//      to_ret = cal(A,tot-A(i),i-1,h) + 1
     return Math.min(cal(A,tot-A(i),i-1,h) + 1 +cal (A,tot,i-1,h) , cal(A,tot-A(i),i-1,h))

    //h += ((key,to_ret))
    return to_ret
  }

  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val stdin = scala.io.StdIn
    val eleCount = stdin.readLine.trim.toInt
    var A:Array[Int] = Array[Int](eleCount)

    A  = stdin.readLine.split(" ").map(_.trim.toInt)

    val testCount = stdin.readLine.trim.toInt
    var T:Array[Int] = new Array[Int](testCount)
    for(i<-0 to testCount-1){
      T(i) = stdin.readLine.trim.toInt
    }
    var h= HashMap[String,Int]()
    var totA:Int = A.sum
    for(i<-0 to testCount -1 ){
      if(T(i) > A.sum){
        println(-1)
      } else {
        var res= tot_count(A.sorted,T(i),h)
        println(res)

      }
    }
  }
}