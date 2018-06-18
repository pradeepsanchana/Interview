package dynamic

/**
 * Created by pradeepsanchana on 02/06/18.
 */
object LongestIncreasingSubLength {
  def LongestIncSubLen(ip:Array[Int]):Int ={
    val T = Array.ofDim[Int](ip.length)
    for(i<-1 to ip.length-1){
      for(j<-0 to i-1) {
        if(ip(i) > ip(j)){
          T(i) = Math.max(T(j) +1 ,T(i))
        }
      }
    }
    T.max + 1
  }
  def main(args: Array[String]):Unit ={
    val ip = Array[Int](3,4,-1,0,6,2,3)
    print(LongestIncSubLen(ip))
  }
}
