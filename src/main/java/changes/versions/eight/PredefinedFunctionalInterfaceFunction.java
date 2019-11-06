package changes.versions.eight;

import java.util.function.Function;

public class PredefinedFunctionalInterfaceFunction {

    public static void main(String[] args) {
        beforeJava8();
        java8();
        beforeJava8andThen();
        java8andThen();
        java8compose();
        java8identity();
    }

    private static Integer convertStringToInt(String string){
        return Integer.valueOf(string);
    }

    private static void beforeJava8(){
        System.out.println(convertStringToInt("2"));
    }

    private static void java8(){
        Function<String, Integer> convertStringToInt = string -> Integer.valueOf(string);
        System.out.println(convertStringToInt.apply("2"));
    }


    private static Person createPerson(Integer age){
        return new Person(age, "Julio");
    }

    private static Integer getAge(Human human){
        return human.getAge();
    }

    private static void beforeJava8andThen(){
        Person person = createPerson(27);
        Integer square = getAge(person);
        System.out.println(square);
    }

    private static void java8andThen(){
        Function<Integer, Person> createPerson = age -> new Person(age, "Julio");
        Function<Human, Integer> getAge = human -> human.getAge();
        System.out.println(createPerson.andThen(getAge).apply(27));
    }

    private static void java8compose(){
        Function<Integer, Person> createPerson = age -> new Person(age, "Julio");
        Function<Human, Integer> getAge = human -> human.getAge();
        System.out.println(getAge.compose(createPerson).apply(27));
    }

    private static void java8identity(){
        Function<Integer, Integer> myFunction = Function.identity();
        System.out.println(myFunction.apply(10));
    }
}

class Human {
    private Integer age;

    public Human(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}

class Person extends Human {

    private String name;
    public Person(Integer age, String name) {
        super(age);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}