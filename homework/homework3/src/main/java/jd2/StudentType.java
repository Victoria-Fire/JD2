package jd2;

public enum StudentType {
    FIRST("1"),
    SECOND("2"),
    THIRD("3");

    final String value;

    StudentType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
