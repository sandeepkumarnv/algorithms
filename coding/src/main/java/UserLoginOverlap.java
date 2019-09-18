import java.sql.Time;
import java.util.*;

/*
Given input which is vector of log entries of some online system each entry is something like (user_name, login_time, logout_time), come up with an algorithm with outputs number of users logged in the system at each time slot in the input, output should contain only the time slot which are in the input. For the example given below output should contain timeslots
[(1.2, 1), (3.1, 2), (4.5, 1), (6.7, 0), (8.9, 1), (10.3,0)]

/*
[
("Jane", 1.2, 4.5),
("Jin", 3.1, 6.7),
("June", 8.9, 10.3)
]

=>

[(1.2, 1), (3.1, 2), (4.5, 1), (6.7, 0), (8.9, 1), (10.3, 0)]

        */
class UserLogin{
    String name;
    Double login;
    Double logout;
    public UserLogin(String name,Double login,Double logout){
        this.name = name;
        this.login = login;
        this.logout = logout;
    }
}

class TimeLogin implements Comparable<TimeLogin>{
    Double time ;
    boolean isLogin;

    public TimeLogin( Double time,boolean isLogin){
        this.time = time;
        this.isLogin = isLogin;
    }

    public int compareTo(TimeLogin t){
        int diff = Double.valueOf(this.time-t.time).intValue();
        return diff;
    }
}
class TimeUserCount{
    Double time ;
    int count;
    public TimeUserCount(Double time, int count){
        this.time = time;
        this.count = count;
    }
}
public class UserLoginOverlap {

    public static void main(String[] args){



        UserLogin[] inputArray = {new UserLogin("Jane",1.2D,4.5D),new UserLogin("Jin",3.1D,6.7D),new UserLogin("June",8.9D,10.3D)};

        List<TimeUserCount>  timeUserCountist = createTimeSlotMapOptimized(inputArray);
        for(TimeUserCount timeUserCount:timeUserCountist){
            System.out.println(timeUserCount.time + " "+timeUserCount.count );
        }



    }
    private static List<TimeUserCount> createTimeSlotMapOptimized(UserLogin[] inputArray){
       List<TimeUserCount> output = new LinkedList<>();

       List<TimeLogin> timeLoginList = new ArrayList<>();
       for(UserLogin userLogin:inputArray){
           timeLoginList.add(new TimeLogin(userLogin.login,true));
           timeLoginList.add(new TimeLogin(userLogin.logout,false));
       }
        Collections.sort(timeLoginList);
        int count = 0;
        for(TimeLogin timeLogin : timeLoginList){
            if(timeLogin.isLogin) {
                count++;
                output.add(new TimeUserCount(timeLogin.time,count));
            }else{
                count--;
                output.add(new TimeUserCount(timeLogin.time,count));
            }
        }

       return output;
    }

}
