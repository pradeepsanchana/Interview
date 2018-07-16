package Arrays

/**
 * Created by pradeepsanchana on 14/07/18.
 */
object FullCountingSort {
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt
    var arr = Array[(Int,String)]()
    for (nItr <- 1 to n) {
      val xs = stdin.readLine.split(" ")

      val x = xs(0).trim.toInt

      val s = xs(1)
      arr +:= (x,s)
    }
    val myOrdering: Ordering[( Int, String)] = Ordering.Tuple2(Ordering.Int, Ordering.String)
    var asort = arr.sorted
    var res = Array.ofDim[String](arr.length)
    for(i<-0 to arr.length-1){
      if(i<arr.length/2 && arr(i) == asort(i)) {
        res(i) = "-"
      } else {
        res(i) = arr(i)._2
      }
    }

    res.foreach(print)
  }

}
