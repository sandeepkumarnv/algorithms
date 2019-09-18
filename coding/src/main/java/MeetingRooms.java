import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


class MeetingTime{
    int start;
    int end;

    public MeetingTime(int start,int end){
        this.start = start;
        this.end = end;
    }
}

public class MeetingRooms {
    public static void main(String[] args){
        MeetingTime[] meetingTimes = {new MeetingTime(0,10),new MeetingTime(15,20),new MeetingTime(12,50),new MeetingTime(14,25),new MeetingTime(25,30)};
        System.out.print(findNumberOfConfRooms(meetingTimes));
    }
    private static int findNumberOfConfRooms(MeetingTime[] meetingTimes){
        Arrays.sort(meetingTimes, new Comparator<MeetingTime>() {
            @Override
            public int compare(MeetingTime t1, MeetingTime t2) {
                return t1.start-t2.start;
            }
        }
        );
        int count=1;

            PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(Integer.valueOf(meetingTimes[0].end));
        for(int i=1;i<meetingTimes.length;i++){
            if(meetingTimes[i].start < queue.peek()){
                count++;

            }else{
                queue.poll();
            }
            queue.add(meetingTimes[i].end);

        }
        return count;
    }

}


