package dynamic

/**
 * Created by pradeepsanchana on 02/06/18.
 */
object OptimalBinarySearchTree {
  
  def main(args:Array[String]):Unit ={
    val nodes = Array[Int](10, 12, 16, 21)
    val freq = Array[Int](4, 2, 6, 3)
    print(optimalBinaryTree(nodes, freq))
  }

  def optimalBinaryTree(nodes:Array[Int], freq:Array[Int]): Int ={
    val T = Array.ofDim[Int](nodes.length, nodes.length)
    for(j<-0 to nodes.length-1){
      T(j)(j) = freq(j)
    }
    for(i<-1 to nodes.length) {
      for (j <- 0 to nodes.length) {
        if ((j + i) < nodes.length){
          var s = 0
          T(j)(j+i) = 100000 // minimum val
          for(k<-j+1 to j+i+1) {
            s += freq(k-1)
          }
          for(k<-j to j+i) {
            var left = 0
            var right = 0
            if(k-1 >= j)
              left = T(j)(k-1)
            if(k+1 <= j+i)
              right = T(k+1)(j+i)
            T(j)(j+i) = Math.min(T(j)(j+i) , s + left +right)
          }
        }
          //print((j, j + i) + " ")
      }
      //println()
    }
    T(0)(nodes.length-1)
  }

}
