package search

/**
 * Created by pradeepsanchana on 15/07/18.
 */
object IcecreamParlor {
  def main(args: Array[String]) {
    println(icecreamParlor(4,Array(2,2,4,3)).mkString(" "))
  }
  def icecreamParlor(m: Int, arr: Array[Int]): Array[Int] = {
    var res = Array[Int]()
    for(i<-0 to arr.length-2){
      for(j<-i+1 to arr.length-1){
        if((arr(i) + arr(j)) == m){
          res ++= Array(i+1,j+1)
        }
      }
    }
    res
  }

}
