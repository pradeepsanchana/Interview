/**
 * Created by pradeepsanchana on 12/04/18.
 */
object IsRotationArray {
  def isRotation(a:Array[Int], b:Array[Int]): Boolean ={
    var s = b(0)
    var i =0
    var j =0
    if ( a.length != b.length)
      false
    while(i<a.length-1 && a(i) != s){
      i +=1
    }
    if(a(i) == s){
      j= i;
    }

    if(i == a.length){
      false
    }
    i = 0
    while(i < b.length-1 ){
      if(a(i) != b((i+j+1)% b.length)){
        return false
      }
      i +=1
    }
    true
  }
  def main(args: Array[String]) {
    var a = Array(1,2,3,4,5,6,7)
    var b = Array(4,5,6,7,1,2,3)
    println("is rotation array:" + isRotation(a,b))
  }

}
