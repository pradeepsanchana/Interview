/**
 * Created by pradeepsanchana on 12/04/18.
 */
object OneWayString {
  def oneWay(a:String, b:String): Boolean ={
    var di =0
    if(a.length == b.length){
      for(i <-0 to a.length-1){
        if(a(i) != b(i)){
          di +=1
        }
      }
      if(di == 1 || di ==0)
        true
      else
        false
    } else if(a.length-1 == b.length){
      var j = 0
      var onlyonce = 0
      for(i <-0 to a.length-1){
        if(j != a.length-1 && a(j) != b(i)){
          j +=1
          onlyonce += 1
        }
        j +=1

      }
      if(onlyonce == 1 || j == a.length)
        true
      else
        false

    } else if (a.length == b.length-1){
      var j = 0
      var onlyonce = 0
      for(i <-0 to a.length-1){
        if(j != b.length-1 && a(i) != b(j)){
          j +=1
          onlyonce += 1
        }
        j +=1

      }
      if(onlyonce == 1 || j == b.length)
        true
      else
        false

    } else {
      false
    }
  }

  def main(args: Array[String]) {
    var in = new java.util.Scanner(System.in)
    var a = in.next()
    var b = in.next()
    println(oneWay(a,b))
  }

}
