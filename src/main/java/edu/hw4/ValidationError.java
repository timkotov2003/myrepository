package edu.hw4;

public record ValidationError(ErrorType type) {

    enum ErrorType {
        NEGATIVE_AGE("age < 0"), NEGATIVE_HEIGHT("height < 0"), NEGATIVE_WEIGHT("weight < 0");

        private String info;

        ErrorType(String info) {
            this.info = info;
        }

        @Override
        public String toString() {
            return info;
        }
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
