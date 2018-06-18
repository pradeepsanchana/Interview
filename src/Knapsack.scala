/**
 * Created by pradeepsanchana on 26/04/18.
i/p:
 1
4 5
1 8
2 4
3 0
2 5
2 3
o/p:13
 */

object Knapsack {
  def FuncKnapsack(total:Int, weightDetails: Array[Array[Int]]):Int = {
    var kArray = Array.ofDim[Int]( weightDetails.length+1, total+1)
    for(i<-1 to weightDetails.length){
      for(j<-1 to total){
        if(j< weightDetails(i-1)(0)) {
          kArray(i)(j) = kArray(i-1)(j)
        } else {
          kArray(i)(j) = Math.max(kArray(i-1)(j),weightDetails(i-1)(1) + kArray(i-1)(j-weightDetails(i-1)(0)))
        }
      }
    }
    kArray(weightDetails.length)(total)
    //store.max
  }



  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val testCount = stdin.readLine.trim.toInt
    for(i<-0 to testCount-1){
      val tmp = stdin.readLine.split(" ")
      val total = tmp(0).toInt
      val weightCount = tmp(1).toInt



      val weightDetails = Array.ofDim[Int](weightCount,2)

      for (weight <- 0 until weightCount) {
        val wightValueItem = stdin.readLine.split(" ")
        weightDetails(weight)(0) = wightValueItem(0).toInt
        weightDetails(weight)(1) = wightValueItem(1).toInt}

      println(FuncKnapsack(total, weightDetails))

    }
  }

}
