package ram.dsa.misc;

import java.util.*;

public class FindFriends {

    public static void main(String[] args) {
        List<Person> network = new LinkedList<Person>();
        Person A = new Person("A",Arrays.asList("B","C"));
        network.add(A);
        network.add(new Person("B",Arrays.asList("A","D","E")));
        network.add(new Person("C",Arrays.asList("A","D","F")));
        network.add(new Person("D",Arrays.asList("B","C","E")));
        network.add(new Person("E",Arrays.asList("B","D","F")));
        network.add(new Person("F",Arrays.asList("C","E")));

        Feed feed = new Feed(network);
        Person friend = feed.findSuggestion(A);
        System.out.println(friend.name);

        Person friend2 = feed.findSuggestion(new Person("C",Arrays.asList("A","D","F")));
        System.out.println(friend2.name);

    }

}

class Feed {
    List<Person> network;
    public Feed(List<Person> network) {
        this.network = network;
    }

    public Person findSuggestion(Person p) {
        if((p==null))
            throw new IllegalArgumentException("Person can not be null");

        Person result = null;
        int max=0;
        for(Person person:network) {
            if(person.name.equals(p.name))
                continue;
            Set<String> intersection = new HashSet<String>(p.friends);
            intersection.retainAll(person.friends);
            if(intersection.size() > max) {
                result = person;
                max = intersection.size();
            }
        }

        return result;
    }
}

class Person {
    String name;
    Set<String> friends;

    public Person(String name, List<String> friends) {
        this.name = name;
        this.friends = new HashSet(friends);
    }
}
