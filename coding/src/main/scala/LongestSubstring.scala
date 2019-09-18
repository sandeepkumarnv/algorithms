/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

object LongestSubstring {

  def lengthOfLongestSubstring(s: String): Int = {
        var maxSubStrLength = 0
        var runningStrLength = 0
        val charSet= scala.collection.mutable.Set[Char]()
        var j=0
        for(i <- 0 to s.length-1){
            if(!charSet.contains(s(i))){
                runningStrLength +=1
                maxSubStrLength = if(maxSubStrLength < runningStrLength) runningStrLength else maxSubStrLength
                charSet += s(i)
            }else{
                while(!charSet.isEmpty && charSet.contains(s(i))){
                    charSet -= s(j)
                    j +=1
                    runningStrLength -= 1
                }
                charSet += s(i)
                runningStrLength +=1
            }
        }

        maxSubStrLength

    }

}

