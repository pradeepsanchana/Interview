package recursion

/**
 * Created by pradeepsanchana on 21/06/18.
 */
object Permutations {
  def main(args:Array[String]):Unit ={
    getPermute(Array(1,2,3))
  }
  def getPermute(a:Array[Int]):Unit = {
    var b= new Array[Int](a.length)
    getPermuteRec(0,a,b)
  }
  def getPermuteRec(s:Int,a:Array[Int],b:Array[Int]):Unit ={
    if(s==a.length) {
      b.foreach(print)
      println
      return
    }
    for(i<-0 to a.length-1){
      if(!isUsed(a(i),b,s)){
        b(s) = a(i)
        getPermuteRec(s+1,a,b)
      }
    }
  }
  def isUsed(u:Int,b:Array[Int],s:Int):Boolean ={
    for(i<-0 to s){
        if(b(i) == u)
          return true
    }
    false
  }
}
