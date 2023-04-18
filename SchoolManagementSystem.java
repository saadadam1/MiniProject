/*Your program should have the following classes:
Teacher: This class should have private fields for the teacher's name and subject, as well as getters and setters for these fields.
Student: This class should have private fields for the student's name and grade level, as well as getters and setters for these fields.
School: This class should have private fields for the list of Teachers and the list of Students, as well as methods to add and remove Teachers and Students from the lists, and methods to print the lists of Teachers and Students. Additionally, this class should have methods to find a Teacher or Student by name and to remove a Teacher or Student from the School.
Your program should have a main method that allows users to interact with the School object and perform the actions listed above. The program should continue running until the user chooses to exit.*/

import java.util.ArrayList;
import java.util.Scanner;

class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

class Student {
    private String name;
    private int gradeLevel;

    public Student(String name, int gradeLevel) {
        this.name = name;
        this.gradeLevel = gradeLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
}

class School {
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(String name) {
        for (Teacher teacher : teachers) {
            if (teacher.getName().equals(name)) {
                teachers.remove(teacher);
                break;
            }
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                students.remove(student);
                break;
            }
        }
    }

  public void displayTeachers() {
        System.out.println("Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getName() + " (" + teacher.getSubject() + ")");
        }
    }

    public void displayStudents() {
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student.getName() + " (Grade " + student.getGradeLevel() + ")");
        }
    }

    public void searchTeacher() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter Teachers name to find");
      String findTeacher = scanner.nextLine();

      ArrayList<Teacher> foundTeacher = new ArrayList<Teacher>();
      for(Teacher teacher : teachers){
        if (teacher.getName().equals(findTeacher)){
          foundTeacher.add(teacher);
        }
      }
      if(foundTeacher.size()>0){
         for(Teacher teacher : foundTeacher){
           System.out.println(teacher.getName()+" is present and has handles the subject "+teacher.getSubject());
         }
      }
      else{
        System.out.println("The teacher is not present");
      }
    }

  public void searchStudent() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter Student name to find");
      String findStudent = scanner.nextLine();

      ArrayList<Student> foundStudent = new ArrayList<Student>();
      for(Student student : students){
        if (student.getName().equals(findStudent)){
          foundStudent.add(student);
        }
      }
      if(foundStudent.size()>0){
         for(Student student : foundStudent){
           System.out.println(student.getName()+" is present and has the grade "+student.getGradeLevel());
         }
      }
      else{
        System.out.println("The Student is not present");
      }
    }

   
}

public class SchoolManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        School school = new School();

        while (true) {
            System.out.println("Select an action:");
            System.out.println("1. Add Teacher");
            System.out.println("2. Remove Teacher");
            System.out.println("3. Add Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Print Teachers");
            System.out.println("6. Print Students");
            System.out.println("7. Find Teacher");
            System.out.println("8. Find Student");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter teacher's name:");
                    String teacherName = scanner.nextLine();
                    System.out.println("Enter teacher's subject:");
                    String teacherSubject = scanner.nextLine();
                    Teacher teacher = new Teacher(teacherName, teacherSubject);
                    school.addTeacher(teacher);
                    System.out.println("Teacher Added");
                break;

            case 2:
                System.out.println("Enter teacher's name:");
                String teacherToRemove = scanner.nextLine();
                school.removeTeacher(teacherToRemove);
                  System.out.println("Teacher Removed");
                break;
                
            case 3:
                System.out.println("Enter student's name:");
                String studentName = scanner.nextLine();
                System.out.println("Enter student's grade level:");
                int studentGradeLevel = scanner.nextInt();
                scanner.nextLine();
                Student student = new Student(studentName, studentGradeLevel);
                school.addStudent(student);
                
                break;
                
            case 4:
                System.out.println("Enter student's name:");
                String studentToRemove = scanner.nextLine();
                school.removeStudent(studentToRemove);
                System.out.println("Student removed");
                break;
                
            case 5:
                school.displayTeachers();
                break;
                
            case 6:
                school.displayStudents();
                break;
                
            case 7:
                school.searchTeacher();
                break;
                
            case 8:
                school.searchStudent();
                break;
            
            case 9:
                System.out.println("ThankYouu !");
                System.exit(0);

            default:
            System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
                
                
          