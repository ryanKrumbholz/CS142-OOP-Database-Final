package people;

/***********************************
 * Class: Person class
 *          Defines a "person" object
 *          with a name and age. Contains
 *          getter and setter methods, a
 *          to string method, and print
 *          status method.
 *
 ************************************/
public class Person {

    private String name;
    private int age;

    /***********************************
     * Constructor: Person
     *              Constructor for a person
     *              object. Takes in a string
     *              and int as parameters.
     *
     ************************************/
    public Person(String name, int age) {

        this.name = name;
        this.age = age;

    }

    /***********************************
     * Constructor: Person
     *              Constructor for a person
     *              object. Takes in a person object
     *              and uses that person's
     *              name and age to set
     *              this peron's name and age.
     *
     ************************************/
    public Person(Person person) {

        this.name = person.name;
        this.age = person.age;

    }

    /***********************************
     * Constructor: Person
     *              Default constructor
     *              method.
     *
     ************************************/
    public Person() {

    }

    /***********************************
     * Method: getAge
     *          Returns the age, an int, of the object.
     *
     ************************************/
    public int getAge() {

        return age;

    }

    /***********************************
     * Method: getName
     *          Returns the name, a string,
     *          of the object.
     *
     ************************************/
    public String getName() {

        return name;

    }

    /***********************************
     * Method: setAge
     *          Sets the age, an int, of
     *          the object.
     *
     ************************************/
    public void setAge(int age) {

        this.age = age;

    }

    /***********************************
     * Method: setName
     *          Sets the name, a string,
     *          of the object.
     *
     ************************************/
    public void setName(String name) {

        this.name = name;

    }

    /***********************************
     * Method: printStatus
     *          Returns the string "This
     *          is a College member".
     *
     ************************************/
    public String printStatus() {

        return "Person";

    }

    /***********************************
     * Method: toString
     *          Returns the object's variables
     *          as a string.
     *
     ************************************/
    public String toString() {

        return "Name: " +  name  + "\nAge: " + age;

    }

    /***********************************
     * Method: toFile()
     *          Returns a String of the
     *          Person's characteristics
     *          in CSV formatting
     *          for printing to a file.
     ************************************/
    public String toFile() {

        return "Person" + "," +name + "," + age;

    }
}
