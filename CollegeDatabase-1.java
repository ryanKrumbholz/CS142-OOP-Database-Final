package database;

import people.Person;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

/*********************************************************************
 * Class: CollegeDatabase
 *          Maintains a database of members of a college using a list.
 *          Includes methods to add, delete, search, find location of
 *          a member in the list, and get and set characteristics of
 *          the class.
 **********************************************************************/
public class CollegeDatabase implements Database {

    //Generic return value for when a person cannot be found. IE: Searching;
    final private int NOT_FOUND = -1;

    final private int DEFAULT_SIZE = 20;

    //Holds person objects
    private Person[] entry;

    //Keeps track of the number of elements within entry
    private int size;

    /*********************************************************************
     * Constructor: CollegeDatabase
     *              Method that doesn't take parameters
     *              and initializes entry to an empty Person ArrayList.
     **********************************************************************/
    public CollegeDatabase() {

        entry = new Person[DEFAULT_SIZE];
        size = entry.length;

    }

    /*********************************************************************
     *Constructor: CollegeDatabase
     *              Takes an ArrayList<Person> parameter entry and initializes
     *              the global entry to the provided ArrayList.
     **********************************************************************/
    public CollegeDatabase(Person[] personArray) {

        entry = personArray;
        size = personArray.length;

    }

    /*********************************************************************
     * Method: add
     *          Adds a Person object to the array by taking a temporary
     *          copy of the entry array, expanding the entry array, then
     *          iterating through a for loop to copy each element back into
     *          the array, and then adds the inputted person object at the
     *          end of the array.
     **********************************************************************/
    public void add(Person person) {

        Person[] temp = Arrays.copyOf(entry, entry.length);
        entry = new Person[temp.length + 1];

        for (int i = 0; i < temp.length; i++) {

            entry[i] = temp[i];

        }

        entry[entry.length - 1] = person;
        size = entry.length;

    }

    /*********************************************************************
     * Method: delete
     *          Removes a Person object from the Array by
     *          taking in a String parameter name and utilizing it within
     *          the helper method. If String is found, the Person object
     *          associated with that name will be removed and the array will
     *          be shifted over and shrunk. If the String is not found
     *          however, an error message will print to console.
     **********************************************************************/
    public void delete(String name) {

        if (search(name)) {

            for (int i = 0; i < entry.length; i++) {

                if (entry[findLocation(name)].equals(entry[i])) {

                    for (int j = i; j < entry.length - 1; j++) {

                        entry[j] = entry[j + 1];

                    }
                    break;

                }

            }

            entry = Arrays.copyOf(entry, entry.length - 1);

        } else {

            System.out.println("ERROR: PERSON NOT FOUND!");

        }

        size = entry.length;

    }

    /*********************************************************************
     * Method: search
     *          Takes in a String parameter name and linearly searches through
     *          the list for a Person object with that name. Iterates through
     *          a for loop until it finds a name in the list that matches
     *          the given name and then breaks. If it does not find the name
     *          in the array, it will return a boolean with a false value.
     **********************************************************************/
    public boolean search(String name) {

        boolean found = false;

        for (int i = 0; i < entry.length; i++) {

            if (entry[i].getName().equals(name)) {

                found = true;
                break;

            }

        }

        if (found) {

            return true;

        } else {

            return false;

        }
    }

    /*********************************************************************
     * Method: findLocation
     *          Returns the index at which the person object is located
     *          within entry. Takes in a String parameter name, which is
     *          then passed to the search method. If name is found, the
     *          index will return. If not, -1 will return, indicating that
     *          the Person object does not exist within entry.
     **********************************************************************/
    public int findLocation(String name) {

        if (search(name)) {

            int i = 0;

            while (!entry[i].getName().equals(name)) {

                i++;

            }

            return i;

        } else {

            return NOT_FOUND;

        }
    }

    /*********************************************************************
     * Method: getDatabase
     *          Returns entry. Allows for safe accessing of data through
     *          encapsulation.
     **********************************************************************/
    public Person[] getEntry() {

        return entry;

    }

    /*********************************************************************
     * Method: getSize
     *              Returns the size of the database.
     * ********************************************************************/
    public int getSize() {

        return size;

    }

    /*********************************************************************
     * Method: getPerson
     *              Returns the person object associated with that name
     *              (string).
     * ********************************************************************/
    public Person getPerson(String name) {

        return entry[findLocation(name)];

    }
}
