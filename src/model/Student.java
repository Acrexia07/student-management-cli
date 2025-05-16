package model;

import java.util.List;

public class Student extends Person{

    //Initialization: Instance fields (Attributes)
    private final List<Double> gradeList;
    private final double averageGrade;

    //Definition: Constructor
    public Student (String name, int age, String gender, List<Double> gradeList, double averageGrade) {
        super(name, age, gender);
        this.gradeList = gradeList;
        this.averageGrade = averageGrade;
    }

    // Method: Getter - Grade
    public List<Double> getGradeList () {
        return this.gradeList;
    }

    // Method: Getter - Average Grade
    public double getAverageGrade () {
        return this.averageGrade;
    }

    //Method: Override (Person class) - Display Personal Information
    @Override
    public void displayPersonalInformation (){
        System.out.println("\n*-----* Student Information *-----* ");
        System.out.printf("Name: %s\n", this.getName());
        System.out.printf("Age: %d years old\n", this.getAge());
        System.out.printf("Gender: %s\n", this.getGender());
        System.out.println("List of Grades: " + this.getGradeList());
        System.out.printf("Average Grade: %.2f%%\n", this.getAverageGrade());
    }

    // Method: Overridden (toString) - Display student Information in designated format
    @Override
    public String toString () {
        return String.format("Name: %s | Age: %d | Gender: %s | Grade/s: %s | Average: %.2f%%",
                this.getName(),
                this.getAge(),
                this.getGender(),
                this.getGradeList().toString(),
                this.getAverageGrade());
    }
}
