/**
 * Created by pradeepsanchana on 14/04/18.
 */
object RotationOfArray {
  def rotate90(a:Array[Array[Int]], n:Int){
    var b = Array.ofDim[Int](3,3)
    for(i<-0 to n-1){
      for(j<-0 to n-1){
        b(j)(n-i-1) = a(i)(j)
      }
    }
    print_arr(b,3)
  }
  def print_arr(a:Array[Array[Int]], n:Int){
    for(i<-0 to n-1){
      for(j<-0 to n-1){
        print(a(i)(j)+ "  ")
      }
      println
    }
  }
  def rotate_sub(i:Int,j:Int,n:Int){
    (j,n-1-i)
  }
  def inPlaceRotate90(a:Array[Array[Int]], n:Int): Unit ={
    for(i<-0 to n/2) {
      var first = i
      var last = n-1-i
      for (j <- first to last -1 ) {
        var off = j-first
        var tmp = a(first)(j)
        a(first)(j) = a(last-off)(first)
        a(last-off)(first) = a(last)(last-off)
        a(last)(last-off) = a(j)(last)
        a(j)(last) = tmp
      }
    }

    print_arr(a,3)

  }
  def main(args: Array[String]) {
    //var b=  Array.ofDim[Int](3,3)
    //b= ((1,2,3),(4,5,6),(7,8,9))
    var a = Array(Array(1,2,3),Array(4,5,6),Array(7,8,9))
    //rotate90(a,3)
    inPlaceRotate90(a,3)
  }
}
