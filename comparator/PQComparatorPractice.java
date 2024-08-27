package comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

class Student {

    int age;
    String name;

    public Student(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString(){
        return age + " " + name;
    }
}

class StudentComp implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.age > o2.age){
            return 1;
        }else if (o1.age == o2.age){
            return 0;
        }else{
            return -1;
        }
    }
}

public class PQComparatorPractice {

    public static void main(String[] args) {
        Student s1 = new Student(10, "aaa");
        Student s2 = new Student(15, "bbb");
        Student s3 = new Student(3, "ccc");
        Student s4 = new Student(6, "ead");

        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComp());

        pq.offer(s1);
        pq.offer(s2);
        pq.offer(s3);
        pq.offer(s4);

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
