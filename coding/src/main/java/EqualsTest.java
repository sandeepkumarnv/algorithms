public class EqualsTest {

    public static void main(String[] args) throws Exception{
        Person p1 = new Person("abc",10);
         Person p2 = new Person("def",20);
         System.out.println(p2.equals(p1));
         Person p3= p2.clone();
         System.out.println(p3.equals(p1));


    }
}
