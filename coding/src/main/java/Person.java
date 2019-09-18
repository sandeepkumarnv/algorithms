public class Person implements Cloneable{

    private String name = null;
    private Integer age = 0;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

 @Override
 public boolean equals(Object o){
        Person p = (Person) o;
        if(this.age > p.age) return true ;
        else return false;
  }
public Person clone()throws CloneNotSupportedException{
return (Person)super.clone();
}

}
