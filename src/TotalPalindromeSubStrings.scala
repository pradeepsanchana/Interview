/**
 * Created by pradeepsanchana on 24/06/18.
 */
object TotalPalindromeSubStrings {
  def main(args: Array[String]) {
    val i = "agbdbga"
    print(countPalindrome(i))
  }
  def countPalindrome(i:String):Int ={
    var c = 0
    for(a<-0 to i.length-2) {
      for(b<-a+2 to i.length){
        if(palindrome(i.substring(a,b))){
          c += 1
          //println(i.substring(a,b))
        }
      }
    }
    return c + i.length
  }
  def palindrome(a:String):Boolean ={
    for(i<-0 to a.length/2){
      if(a(i) != a(a.length-i-1))
        return false
    }
    true
  }
}
