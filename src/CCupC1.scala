/**
 * Created by pradeepsanchana on 29/04/18.
 */
object CCupC1 {
  def isUnique(str :String)={
    var check:Int =0
    var ret = true
    for(i<-str;if(i-'a' >=0  && i-'a' <26)){
      if((check & 1<<(i-'a'))>0) {
        ret = false
      }
        check = check | (1<<(i-'a'))
      }
        ret
    }

  def permute(str1:String,str2: String) ={
    str1.toCharArray.sorted.sameElements(str2.toCharArray.sorted)
  }

  def replace(str :String) = {
    str.trim().replace(" ","%20")
  }

  def compressString(str:String):String= {
    var cstr = ""
    var c =1
    var last:Char = ' '
    for(j <-0 to str.length-2) {
      last = str(j + 1)
      if (str(j) == str(j + 1)) {
        c += 1
      }
      else {
        cstr += str(j) + c.toString
        c = 1
      }
    }
    cstr += last + c.toString
    if(str.length  < cstr.length){
      return str
    }
    else {
      return cstr
    }
  }

  def rotate(mat: Array[Array[Int]],n:Int):Array[Array[Int]] = {

    for(i<-0 to n/2){
      var first = i
      var last = n-1-i
      for(j<-first to last-1){
       var off = j-first
       var tmp= mat(first)(j)
        mat(first)(j) = mat(last-off)(first)
        mat(last-off)(first) = mat(last)(last-off)
        mat(last)(last-off) = mat(j)(last)
        mat(j)(last)  = tmp
      }
    }
    mat
  }
  def setZero(mat: Array[Array[Int]],n:Int):Array[Array[Int]] = {
    var modMat = Array.ofDim[Int](n, n)
    var rows = new  Array[Int](n)
    var cols = new Array[Int](n)
    for (i <- 0 to n - 1) {
      for (j <- 0 to n - 1) {
        if(mat(i)(j) == 0){
          rows(i) = 1
          cols(j) = 1
        }
        modMat(i)(j) = mat(i)(j)

      }
    }
    for (i <- 0 to n - 1) {
      for (j <- 0 to n - 1) {
        if (rows(i) == 1 || cols(j) == 1) {
          modMat(i)(j) = 0
        }
      }
    }
    modMat
  }

  def isRotation(str1:String, str2:String):Boolean ={
    if(str1.length == str2.length && str1.length >0){
      return (str1+str1).contains(str2)
    }
    false
  }

  def main(args: Array[String]) {
    var a = "abcdea"
    println("uniq:"+a+":" +isUnique(a))
    println("uniq:"+"abcde"+":" +isUnique("abcde"))
    var a1= "abcdef"
    var b1= "fedcba"
    println("a:"+a1+": is permute of b:" +b1+ ":"+ permute(a1,b1))
    var a3= "Mr Pradeep San  "
    println("a:"+a3+": replace space with %20:" + replace(a3))
    var a4= "aaaaabbbcabbdddccd"
    println("a:"+a4+":compress :" + compressString(a4))
    a4 = "abcdeff"
    println("a:"+a4+":compress :" + compressString(a4))
    a4 = "aabbccddeeff"
    println("a:"+a4+":compress :" + compressString(a4))
    var a5 =Array(Array(1,2,3),Array(4,5,6),Array(7,8,9))

    printArr(a5)
    rotate(a5,3)
    println("After Rotate")
    printArr(a5)
    println("------------")
    var a6 =Array(Array(1,2,3),Array(4,0,6),Array(7,8,9))
    printArr(setZero(a6,3))
    var a7 = "abcdef"
    var a8 = "fabcde"
    println(a7+"::"+a8 + "::Isrotation :"+isRotation(a7,a8))

  }
  def printArr(a5: Array[Array[Int]])={
    for(i<-0 to a5.length-1){
      for(j<-0 to a5.length-1 ){
        print(a5(i)(j)+" ")
      }
      println
    }
  }

}
