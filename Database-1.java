package database;

import people.Person;

/*********************************************************************
 * Interface: Database
 *              Sets guidelines in place for any class that implements
 *              this Interface. Class must have an void add(), void
 *              delete(), and boolean search() method.
* ********************************************************************/
public interface Database {

    public void  add(Person person);
    public void delete(String name);
    public boolean search(String name);

}
