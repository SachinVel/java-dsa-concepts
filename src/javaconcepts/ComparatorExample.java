package javaconcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 theory - https://www.javatpoint.com/difference-between-comparable-and-comparator
 */

class Student implements Comparable<Student>{
    String name;
    int age;

    Student( String name, int age ){
        this.name = name;
        this.age = age;
    }
    public int compareTo(Student anotherStudent){
        return anotherStudent.age-this.age;
    }

    public String toString(){
        return "Name : "+this.name+" age : "+this.age;
    }
}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2 ){
        return s1.name.compareTo(s2.name);
    }

}
public class ComparatorExample {
    public static void main(String args[]){

        List<Student> listOfStudents = new ArrayList<Student>();

        Student s1 = new Student("Sachin",24);
        Student s2 = new Student("Swathi",23);
        Student s3 = new Student("Calvin",26);
        Student s4 = new Student("Bharath",25);

        listOfStudents.add(s1);
        listOfStudents.add(s2);
        listOfStudents.add(s3);
        listOfStudents.add(s4);

        System.out.println(listOfStudents);
        Collections.sort(listOfStudents,new NameComparator());
        System.out.println(listOfStudents);



    }
}
