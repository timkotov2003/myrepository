package edu.hw4;

import edu.hw4.Animal.Sex;
import edu.hw4.Animal.Type;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("MagicNumber")
public class Tasks {

    private Tasks() {

    }

    public static List<Animal> task1(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparing(Animal::height)).toList();
    }

    public static List<Animal> task2(List<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparing(Animal::weight).reversed()).limit(k).toList();
    }

    public static Map<Animal.Type, Long> task3(List<Animal> animals) {
        return animals.stream().collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

    public static Animal task4(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparing(animal -> animal.name().length()))
            .orElseThrow(NoSuchElementException::new);
    }

    public static Animal.Sex task5(List<Animal> animals) {
        long maleAnimalsCount = animals.stream().filter(a -> a.sex() == Sex.M).count();
        return maleAnimalsCount > (animals.size() - maleAnimalsCount) ? Sex.M : Sex.F;
    }

    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(
            Animal::type,
            Function.identity(),
            BinaryOperator.maxBy(Comparator.comparing(Animal::weight))
        ));
    }

    public static Animal task7(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElseThrow(NoSuchElementException::new);
    }

    public static Animal task8(List<Animal> animals, int k) {
        return animals.stream()
            .filter(a -> a.height() < k)
            .max(Comparator.comparing(Animal::weight))
            .orElseThrow(NoSuchElementException::new);
    }

    public static int task9(List<Animal> animals) {
        return animals.stream().mapToInt(Animal::paws).sum();
    }

    public static List<Animal> task10(List<Animal> animals) {
        return animals.stream().filter(a -> a.age() != a.paws()).toList();
    }

    public static List<Animal> task11(List<Animal> animals) {
        return animals.stream().filter(a -> a.bites() && a.height() > 100).toList();
    }

    public static long task12(List<Animal> animals) {
        return animals.stream().filter(a -> a.weight() > a.height()).count();
    }

    public static List<Animal> task13(List<Animal> animals) {
        return animals.stream().filter(a -> a.name().split(" ").length > 2).toList();
    }

    public static boolean task14(List<Animal> animals, int k) {
        return animals.stream().anyMatch(a -> a.type() == Type.DOG && a.height() > k);
    }

    public static int task15(List<Animal> animals, int k, int t) {
        return animals.stream().filter(a -> a.age() >= k && a.age() <= t).mapToInt(Animal::weight).sum();
    }

    public static List<Animal> task16(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name))
            .toList();
    }

    public static boolean task17(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.bites() && (a.type() == Type.DOG || a.type() == Type.SPIDER))
            .mapToInt(a -> a.type() == Type.SPIDER ? 1 : -1)
            .sum() > 0;
    }

    public static Animal task18(List<List<Animal>> listOfListAnimals) {
        return listOfListAnimals.stream()
            .flatMap(List::stream)
            .filter(a -> a.type() == Type.FISH)
            .max(Comparator.comparing(Animal::weight))
            .orElseThrow(NoSuchElementException::new);
    }

    public static Map<String, Set<ValidationError>> task19(List<Animal> animals) {
        return animals.stream()
            .filter(ValidationErrorUtils::isContainsValidationError)
            .collect(Collectors.toMap(Animal::name, ValidationErrorUtils::getValidationErrors));
    }

    public static Map<String, String> task20(List<Animal> animals) {
        return animals.stream()
            .filter(ValidationErrorUtils::isContainsValidationError)
            .collect(Collectors.toMap(Animal::name, ValidationErrorUtils::getInfoAboutValidationErrors));
    }

}
