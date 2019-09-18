//Check whether the String is a rotated string using one is substring call
object StringRotateCheck {
	def main(args : Array[String])={
		rotateCheck("watewbottle","tebottlewa")
	}

	private def rotateCheck(str1 : String, str2 : String){
		val strBuff = new StringBuilder
		val isRotated = isSubstring(strBuff.append(str1).append(str1).toString, str2)
		println(s"rotated check result : $isRotated")
	}

	private def isSubstring(str : String, subst : String)={
	  str.contains(subst)
	}
}