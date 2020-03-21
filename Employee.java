package people;

/***********************************
 * Class: Employee class
 *          Defines an "employee" object as
 *          a person with an office, salary,
 *          and a status. Contains
 *          getter and setter methods, a to
 *          string methods, and a payments method.
 *
 ************************************/
public class Employee extends Person {

    private String office;
    private double salary;
    private Status status;

    /***********************************
     * Constructor: Employee
     *              Constructor method with
     *              a String, int, Status, String,
     *              and double parameters.
     *
     ************************************/
    public Employee(String name, int age, String office, double salary) {

        super(name,age);
        this.office = office;
        this.salary = salary;

    }

    public Employee(Person person, String office, double salary) {

        super(person.getName(),person.getAge());
        this.office = office;
        this.salary = salary;

    }

    /***********************************
     * Constructor: Employee
     *              Default constructor method.
     *
     ************************************/
    public Employee() {

    }

    /***********************************
     * Method: getOffice
     *          Returns office string.
     *
     ************************************/
    public String getOffice() {

        return office;

    }

    /***********************************
     * Method: setOffice
     *          Sets office string.
     *          EX: SAM 200
     *
     ************************************/
    public void setOffice(String office) {

        this.office = office;

    }

    /***********************************
     * Method: getSalary
     *          Returns salary.
     *
     ************************************/
    public double getSalary() {

        return salary;

    }

    /***********************************
     * Method: setSalary
     *          Sets the salary.
     *
     ************************************/
    public void setSalary(int salary) {

        this.salary = salary;

    }

    /***********************************
     * Method: toString
     *          Returns the object's variables
     *          as a string.
     *
     ************************************/
    public String toString() {

        return super.toString() +
                "\nOffice: " + getOffice() +
                "\nSalary: " +
                getSalary() + "\n";

    }

    /***********************************
     * Method: getStatus
     *          Returns the status.
     ************************************/
    public Status getStatus() {

        return status;

    }

    /***********************************
     * Method: setStatus
     *          Sets the status.
     ************************************/
    public void setStatus(Status status) {

        this.status = status;

    }

    /***********************************
     * Method: payments
     *          Splits the salary into 24
     *          payments.
     ************************************/
    public double payments() {

        return salary / 24;

    }

    /***********************************
     * Method: printStatus
     *          Returns a the status as a
     *          string.
     ************************************/
    public String printStatus() {

        return "Employee";

    }

    /***********************************
     * Method: toFile()
     *          Returns a String of the
     *          Employee's characteristics
     *          in CSV formatting
     *          for printing to a file.
     ************************************/
    public String toFile() {

        return "Employee" + "," + getName() + "," + getAge() + "," + office + "," + salary;

    }

}
