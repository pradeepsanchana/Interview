/**
 * Created by pradeepsanchana on 26/04/18.
 */
object SubSequence {
  def longestCommonSubsequence(a: Array[Int], b: Array[Int]): Array[Int] =  {
    // Complete this function
    var subSeqArray = Array.ofDim[Int](a.length+1, b.length+1)
    var maxlen = 0
    var maxLenPosX = 0
    var maxLenPosY = 0
    for(i<-1 to a.length){
      for(j<-1 to b.length){
        subSeqArray(i)(j)  = if(a(i-1) == b(j-1)){
           1 + subSeqArray(i-1)(j-1)
        } else {
          Math.max(subSeqArray(i-1)(j), subSeqArray(i)(j-1))
        }
      }
      maxlen = Math.max(maxlen,subSeqArray(i).max)
      maxLenPosX = i
      maxLenPosY = subSeqArray(i).indexOf( maxlen)
    }
    var maxString = new Array[Int](maxlen)
    var z = maxlen
    var x= maxLenPosX
    var y = maxLenPosY

    while(z > 0 && x >0) {



      if(subSeqArray(x-1)(y-1) == subSeqArray(x)(y-1)){

          maxString(z-1) = b(y-1)
          z -= 1
          x-=1
          y-=1

      } else {
        //y-=2
        y-=1
      }

    }
    maxString
  }
  //27 76 88 55 94 42 56 74 69 7 94 41 8 71 15 43 3 23 49 84 98 89 24 20 14 88

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt()
    var m = sc.nextInt()
    var a = new Array[Int](n)
    for(a_i <- 0 to n-1) {
      a(a_i) = sc.nextInt()
    }
    var b = new Array[Int](m)
    for(b_i <- 0 to m-1) {
      b(b_i) = sc.nextInt()
    }
    val result = longestCommonSubsequence(a, b)
    println (result.mkString(" "))


  }

}
