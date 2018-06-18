/**
 * Created by pradeepsanchana on 27/04/18.
 */
object MatrixChainMul {
  def matrixMul(mArray: Array[Array[Int]]): Int = {
    var mulA = Array.ofDim[Int](mArray.length, mArray.length)
    var min = 0
    for (a <- 2 to mArray.length ) {
      for (i <- 0 to mArray.length - a) {
        var j = i + 1
        for (k <- 0 to mArray.length - 1) {

          mulA(i)(j)  = 1000000
          for (k <- i + 1 to j) {
            mulA(i)(j)  = Math.min(mulA(i)(k) + mulA(k)(j) + mArray(i)(0) * mArray(k)(1) * mArray(j)(1), mulA(i)(j) )
          }
        }
      }
    }
    mulA(0)(mArray.length - 1)
  }


  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val testCount = stdin.readLine.trim.toInt
    for (i <- 0 to testCount - 1) {
      val weightCount = stdin.readLine.trim.toInt.toInt



      val mArray = Array.ofDim[Int](weightCount, 2)

      for (no <- 0 until weightCount) {
        val wightValueItem = stdin.readLine.split(" ")
        mArray(no)(0) = wightValueItem(0).toInt
        mArray(no)(1) = wightValueItem(1).toInt
      }

      println(matrixMul(mArray))

    }
  }
}
