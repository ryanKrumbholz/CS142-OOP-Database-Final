package database;

import people.Employee;
import people.Person;
import people.Status;
import people.Student;

import java.io.File;
import java.util.Arrays;

/*********************************************************************
 * Class: DatabaseClient
 *              Client Class that allows for testing functionality of
 *              elements within the database package. Test all methods
 *              within the DatabaseStorage and CollegeDatabase classes.
 *              Includes multiple methods that consist of certain types
 *              of test, and then one final method which combines all of
 *              the other testing methods.
 * ********************************************************************/
public class DatabaseClient {

    public static void main(String[] args) {

        //Calls testing method
        testResults();

    }

    /*********************************************************************
     * Method: methodTest
     *              Test all methods within the DatabaseStorage and
     *              CollegeDatabase classes. Requires that it be passed a
     *              DatabaseStorage class, CollegeDatabase class, File, and
     *              a Person Class. Prints results of testing to console.
     * ********************************************************************/
    public static void methodTest(DatabaseStorage storage, CollegeDatabase database, File test, Person person) {

        String name = person.getName();
        int index = database.findLocation(name);
        System.out.println("Running test...");

        System.out.println();
        System.out.println("Test: Writing to file. Check test file for results.");
        storage.write(database, test);
        System.out.println();

        System.out.println("Test: Searching database for person with name " + name + "...");

        if (database.search(name)) {

            System.out.println("Test Passed! :)");

        } else {

            System.out.println("Test Failed! :(");

        }

        System.out.println();

        System.out.println("Test: Deleting " + name + " from the database...");
        database.delete(name);

        if (!database.search(name) && index >= 0) {

            System.out.println("Test Passed! :)");

        } else {

            System.out.println("Test Failed! :(");

        }

        System.out.println();

        System.out.println("Test: Adding " + name + " into the database...");
        database.add(person);
        if (database.search(name)) {

            System.out.println("Test Passed! :)");

        } else {

            System.out.println("Test Failed :(");

        }

        System.out.println("__________________________________________");
        System.out.println();
    }

    /*********************************************************************
     * Method: separationTesting
     *              Separates a CollegeDatabase upon characteristics such as
     *              Status, age, salary, and gpa, and then writes to separate
     *              files for each characteristic. Requires being passed a
     *              String to find what characteristic is being searched for
     *              a String to differentiate the type of Person, a double
     *              to compare the characteristic to, and a File to write
     *              to.
     * ********************************************************************/
    public static void separationTesting(String type, String status, double num, File file) {

        DatabaseStorage data = new DatabaseStorage("src/database/College.txt");
        CollegeDatabase database = data.read();
        CollegeDatabase newDatabase = new CollegeDatabase(new Person[0]);

        for (int i = 0; i < database.getSize(); i++) {

            Person person = database.getEntry()[i];

            if (status.equals("Student") && person.printStatus().equals("Student")) {

                Student student = (Student) person;

                if (type.equals("gpa")) {

                    if (student.getGpa() < num) {

                        newDatabase.add(person);

                    }
                } else if (type.equals("age")) {

                    if (student.getAge() < num) {

                        newDatabase.add(person);

                    }

                }

            } else if (status.equals("Employee") && person.printStatus().equals("Employee")) {

                if (type.equals("salary")) {

                    Employee employee = (Employee) person;

                    if (employee.getSalary() > num) {

                        newDatabase.add(person);

                    }

                } else if (type.equals("age")) {

                    if (person.getAge() > num) {

                        newDatabase.add(person);

                    }

                }

            }

        }

        data.write(newDatabase, file);

    }

    /*********************************************************************
     * Method: separationTestingResults
     *              Conducts five different separation test using the
     *              separationTesting method.
     * ********************************************************************/
    public static void separationTestingResults() {

        File gpaUnder2 = new File("src/textfiles/gpalessthan2.txt");
        File gpaUnder3 = new File("src/textfiles/gpalessthan3.txt");
        File salaryOver = new File("src/textfiles/salaryover55.txt");
        File employeesOver = new File("src/textfiles/employeesover40.txt");
        File studentsUnder = new File("src/textfiles/studentsunder25.txt");

        separationTesting("gpa", "Student", 2.0, gpaUnder2);
        separationTesting("gpa", "Student", 3.0, gpaUnder3);
        separationTesting("salary", "Employee", 55000.00, salaryOver);
        separationTesting("age", "Employee", 40, employeesOver);
        separationTesting("age", "Student", 25, studentsUnder);

    }

    /*********************************************************************
     * Method: testResults
     *              Conducts all testing in one method for easy calling.
     *              Uses separationTestingResults, methodTest, and other
     *              single line test.
     * ********************************************************************/
    public static void testResults() {

        DatabaseStorage storage = new DatabaseStorage("src/database/College.txt");
        CollegeDatabase database = storage.read();
        File test1 = new File("src/textfiles/test.txt");

        Person virginia = database.getPerson("Virginia Alcott");
        Person michael = database.getPerson("Michael Wang");
        Person wilbur = database.getPerson("Wilbur Grant");
        Person ryan = new Student("Ryan Krumbholz", 20, Status.SOPHOMORE, 3.94);

        System.out.println("Test: Checking Array.");
        System.out.println(Arrays.toString(database.getEntry()));
        System.out.println();

        System.out.println("Test: Checking case of negative index.");
        try {

            System.out.println(database.getEntry()[-1]);

        } catch (Exception e) {

            System.out.println("CHECK INDEX");
            System.out.println("Error: " + e);

        }
        System.out.println();

        System.out.println("Test: Checking case of zero index.");
        System.out.println(database.getEntry()[0]);
        System.out.println();

        System.out.println("Test: Testing methods for person in the front of the database.");
        methodTest(storage, database, test1, virginia);

        System.out.println("Test: Testing methods for person in the middle of the database.");
        methodTest(storage, database, test1, michael);

        System.out.println("Test: Testing methods for person in the end of the database.");
        methodTest(storage, database, test1, wilbur);

        System.out.println("Test: Testing methods for person not in the database");
        methodTest(storage, database, test1, ryan);

        System.out.println("Test: Separating people into different files based on their characteristics");
        separationTestingResults();
        System.out.println("See files under the \"testfile\" package.");

    }

}
