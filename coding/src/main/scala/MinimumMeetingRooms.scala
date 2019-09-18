object MinimumMeetingRooms{

	def main(args : Array[String]):Unit={
			 val input = Array((5,15),(10,35),(30, 40),(35,45),(50,65),(55,65))

	   val numMeetingRooms = findNumbrOfMeetingRooms(input)
	   println(numMeetingRooms)
	}

	def findNumberOfMeetingRooms1(minutes : Array[(Int,Int)]):Int={
		var numberOfRooms = 1
		 val meetingCal = new scala.collection.mutable.ArrayBuffer[Int]()
		 var endTime = minutes(0)._2

		 meetingCal += endTime
		for(i <- 1 to minutes.length-1){
		    var meetingRoomFound = false
		    var j=0
			while(!meetingRoomFound && j < meetingCal.length){
				if(minutes(i)._1 >= meetingCal(j)) {
				  meetingCal(j) = minutes(i)._2
				  meetingRoomFound = true
        }
        j += 1
			}
			if(!meetingRoomFound)  meetingCal.append(minutes(i)._2)
		}

		meetingCal.length
	}


	def findNumbrOfMeetingRooms(minutes : Array[(Int,Int)]):Int={
        if(minutes == null || minutes.length == 0) return 0
		val meetingFreeCal = scala.collection.mutable.ArrayBuffer.fill(24*12)(true)
        var rooms = 1
		for(i <- 0 to minutes.length-1){
			val overLap = fillCalender(minutes(i),meetingFreeCal)
			if(overLap) rooms += 1
		}
    rooms

	}

	def fillCalender(minute : (Int,Int), cal : scala.collection.mutable.ArrayBuffer[Boolean]):Boolean={
		val start = minute._1/5
		val end = minute._2/5
		var freeFlag = true
			for(i <- start to end-1){
				freeFlag = freeFlag & cal(i)
				cal(i) = false
			}
		freeFlag
	}

}