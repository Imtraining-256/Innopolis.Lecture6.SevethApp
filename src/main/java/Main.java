import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        HashMap<String, TestSubject> hashMap = new HashMap<>();

        String selectedString = "";

        for(int i = 0; i < 100; i++) {
            var subject = new TestSubject(i);

            hashMap.put(subject.getId(), subject);

            if(i == 27) {
                selectedString = subject.getId();
            }
        }

        System.out.println(hashMap.get(selectedString).getId());

        if(hashMap.get(selectedString).getId() == selectedString){
            System.out.println("True");
        }else {
            System.out.println("False");
        }

        TreeMap<Integer, TestSubject> subjectTreeMap = new TreeMap<>(new TestComparator());


        for(int i = 0; i < 100; i++) {
            TestSubject subject = new TestSubject(i);
            subjectTreeMap.put(subject.getOrdinal(), subject);
        }

        System.out.println(subjectTreeMap.lastEntry());

        Parser parser = new Parser();
        ArrayList<String> list = new ArrayList<>();

        File file = new File("voyna.txt");
        try {
            list = parser.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);
    }
}
