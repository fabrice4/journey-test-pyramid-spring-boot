package journey.springboot.test.junit.basic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    public Customer(String firstName,String lastName,int age){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
    }

    public String toString(){
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', 'age=%d]",id,firstName,lastName,age);
    }

    public int getAge() {
        return age;
    }
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
}