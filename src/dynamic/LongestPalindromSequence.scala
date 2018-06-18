package dynamic

/**
 * Created by pradeepsanchana on 02/06/18.
 */
object LongestPalindromSequence {
  def longestPalin(ip:String):Int={
    val T = Array.ofDim[Int](ip.length,ip.length)
    for(i<-0 to ip.length-1){
      T(i)(i) = 1
    }
    for(i<-2 to ip.length)
      for(j<-0 to ip.length){
        if(j+i <= ip.length){
          if(ip(j) == ip(j+i-1))
              T(j)(j+i-1) = T(j+1)(j+i-1) + 2
          else
            T(j)(j+i-1) = Math.max(T(j)(j+i-2), T(j+1)(j+i-1))
        }
      }
    T(0)(ip.length-1)
  }


  def main(args:Array[String]):Unit = {
    var ip = "agbdba"
    print(longestPalin(ip))
  }
}
