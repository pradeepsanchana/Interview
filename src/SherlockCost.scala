

object SherlockCost {

  // Complete the cost function below.
  def cost(B: Array[Int]): Int = {


    var A = new Array[Int](B.length+1)
    A = 0 +: B
    var mD = new Array[Int](B.length+1)
    var mD2 = new Array[Int](B.length+1)

    for(i<-B.length to 1 by -1){
      if(Math.abs(A(i-1)- 1) < Math.abs(A(i-1) - A(i))){
        mD(i) = A(i)
      } else{
        mD(i) = 1
      }

    }
    //mD2(1) = 1
    for(i<-1 to B.length){
      if(Math.abs(mD2(i-1)-A(i)) <= Math.abs(A(i) - 1)){
        mD2(i) = A(i)
      } else{
        mD2(i) = 1
      }

    }


    var totmD =0
    var totmD2 =0
    for(i<-1 to mD.length-2){
      totmD += Math.abs(mD(i)-mD(i+1))
      totmD2 += Math.abs(mD2(i)-mD2(i+1))
    }
    Math.max(totmD,totmD2)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    var x =Array(1,2,3,4,5)
    var y= new Array[Int](5)
    for(i<- 0 to x.length-1){
       y(i) = x((i+4)%x.length)

    }
    print(y.mkString(" "))
   var a= "KXzQ"
    var b="K"
    /*if(a.toUpperCase().contains(b) ) {
      a.toUpperCase().filter()
      for(i<- 0 to a.length-1){
        for(j<-0  to b.length-1){

        }
      }
      print("Yes")
    } else {
      print("No")
    }*/
    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = stdin.readLine.trim.toInt

      val B = stdin.readLine.split(" ").map(_.trim.toInt)
      val result = cost(B)

      //printWriter.println(result)
      println(result)
    }

    //printWriter.close()
  }
}
