/**
 * Class representation of a person
 *
 * @author Joshua Seward
 * @version 1.0
 */

public class Person {
    private int age;
    private String first_name;
    private String last_name;

    /** @return gives the full name as a string (last, first) */
    public String fullName(){ return last_name + ", " + first_name;}

    /** @return gives age */
    public int getAge(){ return age;}
    /** @return gives last name */
    public String getLast(){ return last_name;}
    /** @return gives first name */
    public String getFirst(){ return first_name;}
    /** sets age */
    public void setAge(int age){ this.age = age;}
    /** sets last name */
    public void setLast(String last_name){ this.last_name = last_name;}
    /** sets first name */
    public void setFirst(String first_name){ this.first_name = first_name;}
}
