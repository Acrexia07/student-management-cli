package model;

@SuppressWarnings("ALL")
public abstract class Person {

    // Initialization: Instance fields (Attributes)
    private final String name;
    private final int age;
    private final String gender;

    // Definition: Constructor Declaration
    protected Person (String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /* ----- Getter Methods ----- */

    //Method: Name
    public String getName () {
        return this.name;
    }

    //Method: Age
    public int getAge () {
        return this.age;
    }

    //Method: Gender
    public String getGender () {
        return this.gender;
    }

    // Method: Abstracted
    abstract void displayPersonalInformation();
    abstract String displayStudentNameAndAverage();
}
