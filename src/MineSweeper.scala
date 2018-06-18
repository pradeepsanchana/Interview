import scala.collection.mutable.Queue
/**
 * Created by pradeepsanchana on 13/04/18.
 */
object MineSweeper {
  def minesweeper(bombs:Array[(Int,Int)], x: Int, y:Int): Unit = {
    var board = Array.ofDim[Int](x, y)
    for (p <- 0 to bombs.length - 1) {
      var t = bombs(p)
      board(t._1)(t._2) = -1
      for (l <- t._1 - 1 to t._1 + 1) {
        for (m <- t._2 - 1 to t._2 + 1) {
          if (l >= 0 && l <= x - 1 && m >= 0 && m <= y - 1 && board(l)(m) != -1) {
            board(l)(m) += 1
          }
        }
      }
    }
    for (i <- 0 to x - 1) {
      for (j <- 0 to y - 1) {
        print(board(i)(j) + " ")
      }
      println()
    }
    board
  }
  def click(b:Array[Array[Int]], x: Int, y:Int, i:Int,j:Int ): Array[Array[Int]] ={
    if(b(i)(j) == -1 || b(i)(j) == 1){
      return b
    }
    var s =   Queue[(Int,Int)]()

    s += ((i ,j))

    while(!s.isEmpty ){
      val (p,q) = s.dequeue
      for (l <- p - 1 to p + 1) {
        for (m <- q - 1 to q + 1) {
          if (l >= 0 && l <= x - 1 && m >= 0 && m <= y - 1 && b(l)(m) == 0) {
            s +=  ((l,m))
            b(l)(m) = -2
          }
        }
      }

    }


    b
  }
def pri(b:Array[Array[Int]], x: Int, y:Int): Unit ={
  for (i <- 0 to x - 1) {
    for (j <- 0 to y - 1) {
      print(b(i)(j) + " ")
    }
    println()
  }
}


  def main(args: Array[String]) {
    var b = Array(Array(0,0,0,0,0),Array(0,1,1,1,0),Array(0,1,-1,1,0))
    click(b,3,5,0,1)
    pri(b,3,5)
    println("----------------")
    b = Array(Array(0,0,0,0,0),Array(0,1,1,1,0),Array(0,1,-1,1,0))
    click(b,3,5,2,2)
    pri(b,3,5)
    println("----------------")
    var bombs1 = Array((0,2),(2,0))
    var s1 = minesweeper(bombs1,3,3)

    println("----------------")
    var bombs2 = Array((0,0),(0,1),(1,2))
    minesweeper(bombs2,3,4)
    println("----------------")
    var bombs3 = Array((1,1),(1,2),(2,2),(4,3))
    minesweeper(bombs3,5,5)
    println("----------------")
  }

}
