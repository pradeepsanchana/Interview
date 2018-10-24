/*
i/p
2
3
4 2 1
6
1 1 5 4 3 2
 */

 object RainHarvest {

  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val in = scala.io.StdIn
    val n = in.readLine.trim.toInt

    for( i<-0 to n-1 ){
      in.readLine
      val ip = in.readLine.split(" ").map(_.trim.toInt)
      //ip.foreach(print)
      println(rainHarvest(ip))
    }
  }
  def rainHarvest(ip:Array[Int]): Long ={
    var l_max =0
    var r_max =0
    var l = 0
    var r = ip.length-1
    var a:Long =0
    while( l<r){
      if(ip(l) < ip(r)){
        if(ip(l) <= l_max){
          a += l_max
          l += 1
        }
        else {
          l_max = ip(l)
        }
      } else {
        if(ip(r) <= r_max){
          a += r_max
          r-=1
        } else {
          r_max = ip(r)
        }
      }
    }
    a
/*    val assen = new Array[Int](ip.length)
    assen(0) = ip(0)
    for(i<-1 to ip.length-1) {
      assen(i) = Math.max(assen(i-1),ip(i))
    }
    /*println("ass")
    assen.foreach(print)
    */
    val des = new Array[Int](ip.length)
    des(ip.length-1) = ip(ip.length-1)
    for(i<-ip.length-2 to 0 by -1) {
      des(i) = Math.max(des(i+1),ip(i))
    }
    /*
    println()
    println("des")
    des.foreach(print)
    */
    var area = 0
    //var tmp = new Array[Int](ip.length)
    for(i<-0 to ip.length-1) {
      assen(i) = Math.min(assen(i),des(i))
    }
    for(i<-1 to ip.length-1){
      area += Math.min(assen(i),assen(i-1))
    }

    area*/
  }
}