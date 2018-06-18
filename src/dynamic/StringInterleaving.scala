package dynamic

/**
 * Created by pradeepsanchana on 02/06/18.
 */
object StringInterleaving {
  def stringInterleaving(s1:String,s2:String,s3:String):Boolean ={
    val T = Array.ofDim[Boolean](s1.length+1, s2.length+1)
    T(0)(0) = true
    for(i<-1 to s1.length)
      if(s1(i-1) == s3(i-1))
        T(0)(i) = true
      else
        T(0)(i) = false
    for(i<-1 to s2.length)
      if(s2(i-1) == s3(i-1))
        T(i)(0) = true
      else
        T(i)(0) = false
    for(i<-1 to s1.length){
      for(j<-1 to s2.length) {
        if(s3(i+j-1) == s1(i-1))
          T(i)(j) = T(i-1)(j)
        else if(s3(i+j-1) == s2(j-1))
          T(i)(j) = T(i)(j-1)
      }
    }
    T(s1.length)(s2.length)
  }
  def main(args:Array[String]):Unit ={
    val s1 = "aab"
    val s2 = "axy"
    val s3 = "aaxaby"
    print(stringInterleaving(s1,s2,s3))
  }
}
