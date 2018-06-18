package dynamic
import java.io.PrintWriter
/**
 * Created by pradeepsanchana on 03/06/18.
 */
object findnum {
  def main (args: Array[String]) {
    val fw = new PrintWriter(sys.env("OUTPUT_PATH"));

    val _arr_size = scala.io.StdIn.readInt
    val _arr = Array.ofDim[Int](_arr_size)

    for (_arr_i <- 0 until _arr_size)
      _arr(_arr_i) = scala.io.StdIn.readInt


    val _k = scala.io.StdIn.readInt

    val res = findNumber(_arr, _k)
    fw.println(res)
    println(res)
    fw.close();
  }
  def findNumber(arr: Array[Int], k: Int): String = {
    for(i<-0 to arr.length){
      if(arr(i) == k)
        return "YES"

    }
    "NO"
  }
  def oddNumbers(l: Int, r: Int): Array[Int] = {
    var res =  Array.ofDim[Int]((r-l)/2+1)
    var j =0
    for(i<-l to r){

      if(i %2 == 1){
        res(j) = i
        j +=1
      }
    }
    res
  }

}
