package edu.hw4;

import edu.hw4.ValidationError.ErrorType;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidationErrorUtils {

    private ValidationErrorUtils() {

    }

    public static boolean isContainsValidationError(Animal animal) {
        return getValidationErrors(animal).size() != 0;
    }

    public static Set<ValidationError> getValidationErrors(Animal animal) {
        Set<ValidationError> validationErrors = new LinkedHashSet<>();
        if (animal.age() < 0) {
            validationErrors.add(new ValidationError(ErrorType.NEGATIVE_AGE));
        }
        if (animal.height() < 0) {
            validationErrors.add(new ValidationError(ErrorType.NEGATIVE_HEIGHT));
        }
        if (animal.weight() < 0) {
            validationErrors.add(new ValidationError(ErrorType.NEGATIVE_WEIGHT));
        }
        return validationErrors;
    }

    public static String getInfoAboutValidationErrors(Animal animal) {
        return "errors: " + getValidationErrors(animal).stream()
            .map(ValidationError::toString)
            .collect(Collectors.joining(", "));
    }

}
