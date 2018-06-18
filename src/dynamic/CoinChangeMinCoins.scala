package dynamic

/**
 * Created by pradeepsanchana on 02/06/18.
 */
object CoinChangeMinCoins {
  def minCoins(ip:Array[Int], tot:Int ):Int ={
    val T = Array.ofDim[Int](ip.length, tot+1)
    T(0)(ip(0)) = 1
    for(i<-2 to tot)
      T(0)(i) = T(0)(i-ip(0)) +1
    for(i<-1 to ip.length-1)
      for(j<-1 to tot){
        if(j >= ip(i-1))
          T(i)(j) = Math.min(T(i-1)(j), T(i)(j-ip(i-1))+1 )
        else
          T(i)(j) = T(i-1)(j)
      }
    T(ip.length-1)(tot)
  }

  def main(args:Array[String]):Unit ={
    val ip = Array[Int](1,5,6,8)
    val tot = 11
    print(minCoins(ip, tot))
  }

}
