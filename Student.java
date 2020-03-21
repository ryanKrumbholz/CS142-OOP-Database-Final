package people;

import database.DatabaseStorage;

/***********************************
 * Class: Student class
 *          Defines a student object
 *          as a person object with a
 *          status, gpa, and major.
 *
************************************/
public class Student extends Person {

    private Status status;
    private double gpa;

    /***********************************
     * Constructor: Student
     *              Constructor method with
     *              String, int, String, Status,
     *              and double parameters.
     *
     ************************************/
    public Student(String name, int age, Status status, double gpa) {

        super(name, age);
        this.status = status;
        this.gpa = gpa;

    }
    public Student(Person person, Status status, double gpa) {

        super(person.getName(), person.getAge());
        this.status = status;
        this.gpa = gpa;

    }

    /***********************************
     * Constructor: Student
     *              Default constructor method.
     *
     ************************************/
    public Student() {

    }

    /***********************************
     * Method: getStatus
     *          Returns the status of the student.
     *          EX. FRESHMAN
     *
     ************************************/
    public Status getStatus() {

        return status;

    }

    /***********************************
     * Method: setStatus
     *          Sets the status of the student.
     *
     ************************************/
    public void setStatus(Status status) {

        this.status = status;

    }

    /***********************************
     * Method: setGpa
     *          Sets the GPA, a double, of
     *          the student.
     *
     ************************************/
    public void setGpa(double gpa) {

        this.gpa = gpa;

    }

    /***********************************
     * Method: getGpa
     *          Returns the gpa of the student
     *          as a double.
     *
     ************************************/
    public double getGpa() {

        return gpa;

    }

    /***********************************
     * Method: printStatus
     *          Returns the status of the
     *          student object as a string.
     *
     ************************************/
    public String printStatus() {

        return "Student";

    }

    /***********************************
     * Method: toString
     *          Returns the variables of the class
     *          as a string.
     *
     ************************************/
    public String toString() {

        return super.toString() +
                "\nClass: " + getStatus() +
                "\nGPA: " + getGpa() + "\n";

    }

    /***********************************
     * Method: isOnProbation
     *          Determines whether the student
     *          is either on probation or not,
     *          then returns boolean.
     *
     ************************************/
    public boolean isOnProbation() {

        boolean bool = false;

        if (gpa < 2.0) {

            bool = true;

        }

        return bool;

    }

    /***********************************
     * Method: toFile()
     *          Returns a String of the
     *          Student's characteristics
     *          in CSV formatting
     *          for printing to a file.
     ************************************/
    public String toFile() {

        return "Student" + "," + getName() + "," + getAge() + "," + status + "," + gpa;

    }

}
