import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

class Person {
    public static final Comparator<Person> c = Comparator.comparing(Person::getName);
    int age;
    String name;

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    String getName() {
        return name;
    }
}

public class J8ReductionExample {
    public static void main(String[] args) {
        List<Person> ppl = new ArrayList<Person>(){{
           add(new Person(29, "Virat"));
            add(new Person(33, "Kedar"));
            add(new Person(36, "MS Dhoni"));
        }};

        String collect = ppl.stream()
                .map(Person::getName)
                .collect(
                        Collectors.joining("Cricketer: ")
                );

        System.out.println(collect);

        SortedSet<Person> set1 = new TreeSet<>(Person.c);
        Person virat = new Person(29, "Virat");
        Person kedar = new Person(33, "Kedar");
        Person msDhoni = new Person(36, "MS Dhoni");

        set1.add(virat);
        set1.add(kedar); set1.add(msDhoni);
        //set1.addAll(Arrays.asList(1,2,3,4,5));

        //System.out.println(set1);
        //System.out.println(set1.first().getName());

        set1.tailSet(kedar).stream().map(Person::getName).forEach(System.out::println);

    }

}
