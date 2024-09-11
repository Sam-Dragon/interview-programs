package misc.questions.streams.lamdas;

import misc.questions.reference.objects.ActualObject;
import misc.questions.reference.objects.PartialObject;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ConvertObjectUsingStreamMapMethod {

    public static void main(String[] args) {
        ModelMapper mapper = new ModelMapper();

        List<ActualObject> objects = List.of(
                new ActualObject(1, "Sam", 33, 'M', 100000D),
                new ActualObject(2, "Kim", 41, 'F', 200000D),
                new ActualObject(3, "Pom", 35, 'M', 400000D));

        System.out.println("\nActual Objects");
        objects.forEach(System.out::println);

        System.out.println("\nPartial Objects");
        objects.stream().map(e -> mapper.map(e, PartialObject.class))
                .toList().forEach(System.out::println);
    }
}

