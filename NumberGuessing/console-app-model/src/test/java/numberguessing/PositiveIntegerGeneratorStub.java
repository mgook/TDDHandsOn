package numberguessing;

public class PositiveIntegerGeneratorStub implements PositiveIntegerGenerator {
    private final int[] numbers;
    private int index;

    public PositiveIntegerGeneratorStub(int... numbers) {
        this.numbers = numbers;
        this.index = 0;
    }

    @Override
    public int generateLessThanOrEqualToHundred() {
        return numbers[index++ % numbers.length];
    }
}
