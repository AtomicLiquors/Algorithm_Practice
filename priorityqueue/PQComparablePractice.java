package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;



public class PQComparablePractice {
    static class Student implements Comparable<Student>{

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

        @Override
        public int compareTo(Student o) {
            if(this.age > o.age)
                return 1;
            else if(this.age == o.age)
                return 0;
            else
                return -1;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(10, "aaa");
        Student s2 = new Student(15, "bbb");
        Student s3 = new Student(3, "ccc");
        Student s4 = new Student(6, "ead");

        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.offer(s1);
        pq.offer(s2);
        pq.offer(s3);
        pq.offer(s4);

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
