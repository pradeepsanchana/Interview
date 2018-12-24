package Arrays
/**
 * Created by pradeepsanchana on 12/12/18.
 */
object Choas {
  def main(args: Array[String]) {
    //minimumBribes(Array(2,1,5,3,4))
    //minimumBribes(Array(2,5,1,3,4))
    minimumBribes(Array(1,2,5,3,7,8,6,4))

  }
  def minimumBribes(a:Array[Int]): Unit ={
    var r = 0
    var tmp = 0
    for(i<-0 to a.length-1){
      for(j<-1 to a.length-i-1){
        if(a(j-1) > a(j) ) {
          tmp = a(j-1)
          a(j-1) = a(j)
          a(j) = tmp
          r +=1
        }
      }
    }
    /*for(i<-0 to a.length-1) {
      if ((a(i) - i - 1) > 2) {
        r = 0
      }
    }*/
    if( r == a.length-1){
      println("Too chaotic")
    } else {
      println(r)
    }

  }

/*      for(i<-0 to a.length-1){
        if((a(i) - i - 1) > 2 ) {
          r =0
        } else {
          r += Math.abs(a(i) - i - 1)
        }
      }
    }
  */


}
