package dynamic

/**
 * Created by pradeepsanchana on 02/06/18.
 */
object MinEditDistance {
  def MinEditDis(s1:String, s2:String):Int = {
    val T = Array.ofDim[Int](s2.length+1,s1.length+1)
    for(i<-1 to s2.length)
        T(i)(0) = i
    for(i<-0 to s1.length)
        T(0)(i) = i
    for(i<-1 to s2.length)
      for(j<-1 to s1.length){
        if(  s1(j-1) == s2(i-1))
          T(i)(j) = T(i-1)(j-1)
        else
          T(i)(j) = Math.min(Math.min(T(i-1)(j), T(i-1)(j-1)),T(i)(j-1)) + 1
      }

    T(s2.length)(s1.length)
  }
  def main(args:Array[String]):Unit ={
    val s1 = "abcdef"
    val s2 = "azced"
    print(MinEditDis(s1,s2))
  }
}
