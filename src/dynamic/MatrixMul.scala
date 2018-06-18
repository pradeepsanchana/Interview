package dynamic

/**
 * Created by pradeepsanchana on 01/06/18.
 */
object MatrixMul {
  def main(args:Array[String]): Unit ={
    val ip = Array[(Int,Int)]((2,3),(3,6),(6,4),(4,5))
    print(minMul(ip))
  }
  def minMul(ip:Array[(Int,Int)]):Int = {
    val T = Array.ofDim[Int](ip.length, ip.length)
    for (i <- 1 to ip.length - 1) {
      for (j <- 0 to ip.length - 1)
        if (i + j < ip.length){
           T(j)(j+i) = 100000
             for(k<-j to j+i){
               T(j)(j+i) = Math.min(T(j)(j+i), T(j)(k) + T(k)(j+i-1) + ip(j)._1 *ip(j+i)._1 *ip(j+i)._2)
             }

          //print((j, j + i) + ":" + T(j)(j+i) )
        }
      //println()
  }
        T(0)(ip.length-1)
  }

}
