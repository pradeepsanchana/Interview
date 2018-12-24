package Arrays

/**
 * Created by pradeepsanchana on 01/12/18.
 */
import java.io._

import scala.io._




object CountDup {

  /*
   * Complete the 'countDuplicates' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY numbers as parameter.
   */

  def countDuplicates(numbers: Array[Int]): Int = {
    // Write your code here
    var c =0
    var n= numbers.length-1
    var h:collection.mutable.Map[Int,Int] = collection.mutable.Map()
    for (j<-0 to n-1){
      if (h.contains(numbers(j))) {
        val b = h(numbers(j))
        h += (numbers(j) -> (b + 1))
      } else {
        h += (numbers(j) -> 1)
      }
    }
    for(i<-h.keySet){
      if(h(i) >= 2)
        c += 1
    }
    c

  }

}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val numbersCount = StdIn.readLine.trim.toInt

    val numbers = Array.ofDim[Int](numbersCount)

    for (i <- 0 until numbersCount) {
      val numbersItem = StdIn.readLine.trim.toInt
      numbers(i) = numbersItem
    }

    val result = CountDup.countDuplicates(numbers)

    printWriter.println(result)

    printWriter.close()
  }
}

