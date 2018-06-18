/**
 * Created by pradeepsanchana on 12/04/18.
 */
object MostFrequent {
  def mostFre(a:Array[Int]):Int ={

    var mem = scala.collection.mutable.Map[Int,Int]()
    var max =0
    var ret =0
    for (i <-0 to a.length-1){
      if(!mem.isEmpty && mem.contains(a(i))) {
        mem(a(i)) = mem(a(i))+1
        if(max < mem(a(i))) {
          max = mem(a(i))
          ret = a(i)
        }
      }  else {
        mem(a(i)) = 1
      }
    }


    ret
  }
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var w = new Array[Int](n);
    for(w_i <- 0 to n-1) {
      w(w_i) = sc.nextInt();
    }
    val result = mostFre(w);
    println(result)

  }
}
