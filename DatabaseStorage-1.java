package database;

import people.Employee;
import people.Person;
import people.Status;
import people.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*********************************************************************
 * Class: DatabaseStorage
 *              Manages reading and writing to files. Contains methods
 *              to read, write, parse, and setFile.
 * ********************************************************************/
public class DatabaseStorage {

    private File file;

    final private String DEFAULT_FILEPATH = File.separator + "Users" + File.separator
            + "Documents" + File.separator + "CSC_142" + File.separator +
            "College.txt";

    /*********************************************************************
     * Constructor: DatabaseStorage
     *              Default Constructor method. If nothing it passed to the
     *              constructor, it will create a new DatabaseStorage object
     *              with the default filepath.
     * ********************************************************************/
    public DatabaseStorage() {

        setFile(DEFAULT_FILEPATH);

    }

    /*********************************************************************
     * Constructor: DatabaseStorage
     *              Constructor method that takes in a string and uses it to
     *              set it as the filepath.
     * ********************************************************************/
    public DatabaseStorage(String filePath) {

        setFile(filePath);

    }

    /*********************************************************************
     * Method: read
     *              Reads the file and converts it into a String array where
     *              each line of the file is a new index in the array. Then
     *              parses each line into a person object and adds it to the
     *              array.
     * ********************************************************************/
    public CollegeDatabase read() {

        String[] data = new String[(int) file.length()];
        CollegeDatabase people = new CollegeDatabase();
        int i = 0;

        try {

            FileReader reader = new FileReader(file);
            Scanner input = new Scanner(reader);

            while (input.hasNextLine()) {

                data[i] = input.nextLine();
                i++;

            }

        } catch (Exception e) {

            System.out.println("FILE NOT FOUND!");
            System.out.println("Error code: " + e);

        }

        for (int j = 0; j < i; j++) {

            if (j < people.getSize()) {

                people.getEntry()[j] = parsePerson(data[j]);

            } else {

                people.add(parsePerson(data[j]));

            }

        }

        return people;

    }

    /*********************************************************************
     * Method: parsePerson
     *              Parses the given String line into a person by splitting
     *              the line into an array, every new index separated by a comma.
     *              Then uses corresponding locations to set the person's
     *              characteristics. It can decide whether the person is an
     *              employee or student based off of the role, which is found
     *              at the zero index in the array. After assigning each value
     *              for the person, it returns the person object.
     * ********************************************************************/
    public Person parsePerson(String line) {

        String[] dataLine = line.split(",");
        String name = dataLine[1];
        int age = Integer.parseInt(dataLine[2]);
        Person person = new Person(name, age);
        Person newPerson;

        if (dataLine[0].equals("Student")) {

            double GPA = Double.parseDouble(dataLine[4]);
            Status status = Status.valueOf(dataLine[3]);
            newPerson = new Student(person, status, GPA);

        } else if (dataLine[0].equals("Employee")) {

            double salary = Double.parseDouble(dataLine[4]);
            String office = dataLine[3];
            newPerson = new Employee(person, office, salary);

        } else {

            newPerson = new Person(name, age);

        }

        return newPerson;

    }

    /*********************************************************************
     * Method: setFile
     *              Takes parameter String filePath. Sets file to a new file
     *              with the path of filePath.
     * ********************************************************************/
    public void setFile(String filePath) {

        file = new File(filePath);

    }

    /*********************************************************************
     * Method: write
     *              Takes in a CollegeDatabase people and a File file.
     *              Uses a for loop to write each person in the database
     *              to the file by calling their toFile method.
     * ********************************************************************/
    public void write(CollegeDatabase people, File file) {

        try {

            FileWriter fileWriter = new FileWriter(file);

            for (int i = 0; i < people.getSize(); i++) {

                fileWriter.write(people.getEntry()[i].toFile() + "\n");

            }

            fileWriter.close();

        } catch (Exception e) {

            System.out.println("FILE NOT FOUND!");
            System.out.println("Error: " + e);

        }

    }

}
