package recursion

/**
 * Created by pradeepsanchana on 04/06/18.
 */
object permute {
  def main (args: Array[String]) {
    val ip = Array[Int](1,2,3)
    //val z = ip.toList.permutations
    perm(ip)
  }
  def perm(ip:Array[Int]):Unit = {
    per(ip,0,ip.length-1)
  }
  def per(ip:Array[Int],s:Int, e:Int):Unit = {
    var in = ip
    if(s == e) {
      in.foreach(print)
      println
      //return
    } else {
      for(i<-s to e){
        in = swap(in,s,i)
        per(in,s+1,e)
        in = swap(in,s,i)
      }
    }

  }
  def swap(ip:Array[Int], s:Int,e:Int): Array[Int] ={
    val t = ip(s)
    ip(s) = ip(e)
    ip(e) = t
    ip
  }
}
