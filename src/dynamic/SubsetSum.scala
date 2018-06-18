package dynamic

/**
 * Created by pradeepsanchana on 02/06/18.
 */
object SubsetSum {

  def main(args:Array[String]):Unit ={
    val ip = Array[Int](2,3,7,8,10)
    val tot = 11
    print(subSum(ip,tot))
  }

  def subSum(ip:Array[Int], tot:Int):Boolean ={
    val T = Array.ofDim[Boolean](ip.length+1, tot+1)
    for(i<-0 to ip.length)
      T(i)(0) = true
    for(i<-1 to ip.length)
      for(j<-1 to tot){
        if(j < ip(i-1))
          T(i)(j) = T(i-1)(j)
        else
          T(i)(j) = T(i-1)(j) || T(i-1)(j-ip(i-1))
      }
    T(ip.length)(tot)
  }

}
