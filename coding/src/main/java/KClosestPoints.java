import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoints {
    public static void main(String[] args){
       Points[] pointsArr = {new Points(13,15),new Points(2,4),new Points(-2,-1),new Points(2,23),new Points(8,19),new Points(20,4),new Points(-1,1)};
       List<Points> resultList =  findKClosestPoints(pointsArr,  3);
       for(Points result : resultList){
           System.out.println(result.toString());
       }

    }

    private static List<Points> findKClosestPoints(Points[] pointsArr, int k){

        PriorityQueue<Points> maxHeap = new PriorityQueue<Points>(Collections.reverseOrder());

        for(Points points : pointsArr){
            if(!maxHeap.isEmpty()){
                System.out.println("peek :"+maxHeap.peek().distanceFromOrigin() + "    Point: "+ points.distanceFromOrigin()+ " compare=>"+maxHeap.peek().compareTo(points));
            }

            if(maxHeap.size() < k) maxHeap.add(points);
            else if(maxHeap.peek().compareTo(points) > 0){
                maxHeap.poll();
                maxHeap.add(points);
            }

        }

        List<Points> resultList = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            resultList.add(maxHeap.poll());
        }
      return resultList;
    }

}
class Points implements Comparable<Points>{
    int x;
    int y;

    public Points(int x, int y){
        this.x = x;
        this.y=y;
    }

    public double distanceFromOrigin(){
        return Math.sqrt(x*x+y*y);
    }

    @Override
    public int compareTo(Points point){
        double diff =this.distanceFromOrigin()-point.distanceFromOrigin();
        if(diff == 0) return 0;
        return diff > 0 ? 1:-1;
    }
    @Override
    public String toString(){
        return "("+x+","+y+")  =>  "+distanceFromOrigin();
    }

}