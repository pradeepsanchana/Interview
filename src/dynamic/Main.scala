package dynamic

/**
 * Created by pradeepsanchana on 29/07/18.
 */
object Main {
  def main (args: Array[String]) = {
    val _no_of_in = scala.io.StdIn.readInt
    for(ij <- 0 until _no_of_in) {
      val _arr_size = scala.io.StdIn.readInt

      val _arr = scala.io.StdIn.readLine.split(" ").map(_.trim.toInt)


      println(LongestGoodSubArray(_arr))
    }

    //    println(LongestGoodSubArray(Array(2,5,1,6,4,7)))
    //    println(LongestGoodSubArray(Array(4,4, 6, 3, 4, 7, 3, 5, 5)))

  }
  def LongestGoodSubArray(in:Array[Int]):Int ={
    var res = Array.ofDim[Int](in.length+1,in.length+1)
    for(i<-0 to in.length-1){
      for(j<-0 to in.length-1){
        if(i+j <= in.length-1){
          //println("("+ j+(i+j)+")")
          if(in(j) >= in(j+i) ){
            res(j)(j+i) = i+1
          } else{
            res(j)(j+i) = Math.max(res(j)(j+i-1),res(j+1)(j+i))
          }
        }
      }
    }
    res(0)(in.length-1)
  }
}
