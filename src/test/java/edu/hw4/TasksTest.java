package edu.hw4;

import edu.hw4.Animal.Sex;
import edu.hw4.Animal.Type;
import edu.hw4.ValidationError.ErrorType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class TasksTest {

    private static List<Animal> animals;

    @BeforeEach
    void setUp() {
        animals = new ArrayList<>();
        animals.add(new Animal(
            "CatName",
            Type.CAT,
            Sex.M,
            2,
            20,
            5,
            true
        ));
        animals.add(new Animal(
            "DogName",
            Type.DOG,
            Sex.F,
            5,
            30,
            10,
            true
        ));
        animals.add(new Animal(
            "BirdName",
            Type.BIRD,
            Sex.F,
            2,
            10,
            1,
            false
        ));
        animals.add(new Animal(
            "FishName",
            Type.FISH,
            Sex.F,
            1,
            5,
            2,
            false
        ));
        animals.add(new Animal(
            "SpiderName",
            Type.SPIDER,
            Sex.M,
            3,
            4,
            1,
            true
        ));
    }

    @Test
    void task1Test() {
        List<Animal> result = Tasks.task1(animals);

        assertThat(result.get(0)).isEqualTo(animals.get(4));
        assertThat(result.get(4)).isEqualTo(animals.get(1));
    }

    @Test
    void task2Test() {
        int k = 2;

        List<Animal> result = Tasks.task2(animals, k);

        assertThat(result.get(0)).isEqualTo(animals.get(1));
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void task3Test() {
        animals.add(new Animal(
            "Cat2",
            Type.CAT,
            Sex.M,
            2,
            20,
            5,
            true
        ));

        var result = Tasks.task3(animals);

        assertThat(result.get(Type.CAT)).isEqualTo(2);
        assertThat(result.get(Type.DOG)).isEqualTo(1);
    }

    @Test
    void task4Test() {
        var result = Tasks.task4(animals);

        assertThat(result.name()).isEqualTo("SpiderName");
    }

    @Test
    void task5Test() {
        var result = Tasks.task5(animals);

        assertThat(result).isEqualTo(Sex.F);
    }

    @Test
    void task6Test() {
        animals.add(new Animal(
            "Cat2Max",
            Type.CAT,
            Sex.M,
            2,
            20,
            15,
            true
        ));
        animals.add(new Animal(
            "Cat2Min",
            Type.CAT,
            Sex.M,
            2,
            20,
            2,
            true
        ));

        var result = Tasks.task6(animals);

        assertThat(result.get(Type.CAT).weight()).isEqualTo(15);
        assertThat(result.get(Type.DOG).weight()).isEqualTo(10);
    }

    @Test
    void task7Test() {
        int k = 2;

        var result = Tasks.task7(animals, k);

        assertThat(result.age()).isEqualTo(3);
    }

    @Test
    void task8Test() {
        int k = 25;

        var result = Tasks.task8(animals, k);

        assertThat(result.name()).isEqualTo("CatName");
    }

    @Test
    void task9Test() {
        var result = Tasks.task9(animals);

        assertThat(result).isEqualTo(18);
    }

    @Test
    void task10Test() {
        var result = Tasks.task10(animals);

        assertThat(result.size()).isEqualTo(4);
    }

    @Test
    void task11Test() {
        animals.add(new Animal(
            "BigSpiderName",
            Type.SPIDER,
            Sex.M,
            3,
            101,
            1,
            true
        ));

        var result = Tasks.task11(animals);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).name()).isEqualTo("BigSpiderName");
    }

    @Test
    void task12Test() {
        animals.add(new Animal(
            "BigTomCat",
            Type.CAT,
            Sex.M,
            2,
            20,
            25,
            true
        ));

        var result = Tasks.task12(animals);

        assertThat(result).isEqualTo(1L);
    }

    @Test
    void task13Test() {
        animals.add(new Animal(
            "CatName 2",
            Type.CAT,
            Sex.M,
            2,
            20,
            25,
            true
        ));
        animals.add(new Animal(
            "Cat Name 3",
            Type.CAT,
            Sex.M,
            2,
            20,
            25,
            true
        ));

        var result = Tasks.task13(animals);

        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void task14Test() {
        int k = 29;

        var result = Tasks.task14(animals, k);

        assertThat(result).isTrue();
    }

    @Test
    void task15Test() {
        int k = 2;
        int l = 5;

        var result = Tasks.task15(animals, k, l);

        assertThat(result).isEqualTo(17);
    }

    @Test
    void task16Test() {
        animals.add(new Animal(
            "CatName2",
            Type.CAT,
            Sex.F,
            2,
            20,
            5,
            true
        ));
        animals.add(new Animal(
            "CatName3",
            Type.CAT,
            Sex.M,
            2,
            20,
            5,
            true
        ));

        var result = Tasks.task16(animals);

        assertThat(result.get(0).name()).isEqualTo("CatName");
        assertThat(result.get(1).name()).isEqualTo("CatName3");
        assertThat(result.get(2).name()).isEqualTo("CatName2");
        assertThat(result.get(6).name()).isEqualTo("SpiderName");
    }

    @Test
    void task17Test() {
        animals.add(new Animal(
            "AnotherDog",
            Type.DOG,
            Sex.F,
            2,
            20,
            5,
            false
        ));
        animals.add(new Animal(
            "AnotherSpider",
            Type.SPIDER,
            Sex.M,
            2,
            20,
            5,
            true
        ));

        var result = Tasks.task17(animals);

        assertThat(result).isTrue();
    }

    @Test
    void task18Test() {
        List<Animal> list2 = new ArrayList<>();
        list2.add(new Animal(
            "Fish2Max",
            Type.FISH,
            Sex.F,
            2,
            20,
            50,
            false
        ));
        List<Animal> list3 = new ArrayList<>();
        list3.add(new Animal(
            "Fish3",
            Type.FISH,
            Sex.M,
            2,
            20,
            5,
            true
        ));
        List<List<Animal>> listOfListAnimals = List.of(animals, list2, list3);

        var result = Tasks.task18(listOfListAnimals);

        assertThat(result.name()).isEqualTo("Fish2Max");
    }

    @Test
    void task19Test() {
        animals.add(new Animal(
            "DogWithNegativeAge",
            Type.DOG,
            Sex.F,
            -2,
            20,
            5,
            false
        ));
        animals.add(new Animal(
            "SpiderWithNegativeHeightAndWeight",
            Type.SPIDER,
            Sex.M,
            2,
            -20,
            -5,
            true
        ));

        var result = Tasks.task19(animals);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get("DogWithNegativeAge")).isEqualTo(Set.of(new ValidationError(ErrorType.NEGATIVE_AGE)));
        assertThat(result.get("SpiderWithNegativeHeightAndWeight")).isEqualTo(Set.of(
            new ValidationError(ErrorType.NEGATIVE_HEIGHT),
            new ValidationError(ErrorType.NEGATIVE_WEIGHT)
        ));
    }

    @Test
    void task20Test() {
        animals.add(new Animal(
            "DogWithNegativeAge",
            Type.DOG,
            Sex.F,
            -2,
            20,
            5,
            false
        ));
        animals.add(new Animal(
            "SpiderWithNegativeHeightAndWeight",
            Type.SPIDER,
            Sex.M,
            2,
            -20,
            -5,
            true
        ));

        var result = Tasks.task20(animals);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get("DogWithNegativeAge")).isEqualTo("errors: age < 0");
        assertThat(result.get("SpiderWithNegativeHeightAndWeight")).isEqualTo("errors: height < 0, weight < 0");
    }

}
