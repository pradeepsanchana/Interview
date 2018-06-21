package recursion

/**
 * Created by pradeepsanchana on 21/06/18.
 */
object GenBinarySeq {
  def main(args:Array[String])={
    genBinary(4)
  }

  def genBinary(x:Int):Unit={
    val a = new Array[Int](x)
    genBinRec(0,x,a)
  }
  def genBinRec(x:Int,n:Int,a:Array[Int]):Unit={
    if(x==n) {
      a.foreach(print)
      println
      return
    }
    for(j<-0 to 1){
      a(x) = j
      genBinRec(x+1 ,n,a)
    }
  }

}
