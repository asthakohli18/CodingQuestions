/**
 * Created by kohas02 on 7/24/18.
 */
public class PassByRefOrPassByVal {


    static class Dog{
        public String getName() {
            return name;
        }

        String name ;
        Dog(String n){
            this.name = n;
        }

    }

    public static void main(String[] args) {
        Dog aDog = new Dog("Max");
        int i=10;
        System.out.println("I value b4 function call = "+i);
        // we pass the object to foo
        foo(aDog, i);
        System.out.println("I value after function call = "+i);
        // aDog variable is still pointing to the "Max" dog when foo(...) returns
        System.out.println(aDog.getName().equals("Max"));// true
        System.out.println(aDog.getName().equals("Fifi")); //false
    }

    public static void foo(Dog d, int i) {
        i++;
        d.getName().equals("Max"); // true
        // change d inside of foo() to point to a new Dog instance "Fifi"
        //d = new Dog("Fifi");
        d.name ="Fifi";
        d.getName().equals("Fifi"); // true
    }
}
