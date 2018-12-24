package Arrays

/**
 * Created by pradeepsanchana on 22/12/18.
 */
import java.io._

object ArrayManipulation {

  // Complete the arrayManipulation function below.
  def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {
/*
      var res1 = new Array[Long](n)
      var hash = new HashMap[(Int,Int),Int]()
      for(i<-0 to queries.length-1){
        if(hash.size == 0){
          hash += (queries(i)(0) , queries(i)(1)) -> queries(i)(2)
        } else {
          if( < queries(i)(0))
        }
        hash += (queries(i)(0) , queries(i)(1)) -> queries(i)(2)
        for(j<-queries(i)(0) to queries(i)(1)){
          res1(j-1) +=queries(i)(2)
        }
      }
      res1.foreach(println)
*/

  /*  var res1 = new Array[Long](n)
    for(i<-0 to queries.length-1){
      for(j<-queries(i)(0) to queries(i)(1)){
        res1(j-1) +=queries(i)(2)
      }
    }
    res1.foreach(println)
*/

    //sortWith(_(1) < _(1))
    var b = queries.sortWith(_(0) < _(0))
    for(i<-0 to b.length-1){
      println(b(i)(0)+ " "+ b(i)(1) + " " + b(i)(2))
    }
    println("-------------------------------")
    var c = queries.sortWith(_(1) < _(1))
    for(i<-0 to c.length-1){
      println(c(i)(0)+ " "+ c(i)(1) + " " + c(i)(2))
    }
    var res = new Array[Long](n)
    var m = 0L
    for(i<-0 to n-1){
      var j = 0
      while( (j<= b.length-1) && !((i+1 >= b(j)(0)) )) {
        j +=1
      }
      while(j< b.length && (i+1 >= b(j)(0))  ) {
        if((i+1 <= b(j)(1))){
          res(i) += b(j)(2)
        }
        j+=1
        //m = Math.max(m, res(j-1))
      }
      m = Math.max(m, res(i))
    }
    println(m)
    m

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter("OUTPUT_PATH")

    val nm = stdin.readLine.split(" ")

    val n = nm(0).trim.toInt

    val m = nm(1).trim.toInt

    val queries = Array.ofDim[Int](m, 3)

    for (i <- 0 until m) {
      queries(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = arrayManipulation(n, queries)

    printWriter.println(result)

    printWriter.close()
  }
}
