package literateProgramming;

public class NumberPrinter {
    private final int colsPerPage;
    private final int rowsPerPage;
    private int pageNumber;
    private int[] numbers;

    public NumberPrinter(int colsPerPage, int rowsPerPage) {
        this.colsPerPage = colsPerPage;
        this.rowsPerPage = rowsPerPage;
    }

    void print(int[] numbers, String title) {
        initialize(numbers);
        while (needToPrintMore()) {
            printHeader(title);
            printNumbersOnPage();
            moveToNextPage();
        }
    }

    private boolean needToPrintMore() {
        return getPageOffset() <= getNumberOfNumbers();
    }

    private void initialize(int[] numbers) {
        this.numbers = numbers;
        pageNumber = 1;
    }

    private void moveToNextPage() {
        System.out.println("\f");
        pageNumber++;
    }

    private void printNumbersOnPage() {
        for (int row = 0; row < rowsPerPage; row++) {
            for (int col = 0; col < colsPerPage; col++)
                printNumberAt(getPageOffset() + row + col * rowsPerPage);
            System.out.println();
        }
    }

    private void printNumberAt(int index) {
        if (index <= this.getNumberOfNumbers())
            System.out.printf("%10d", this.numbers[index]);
    }

    private void printHeader(String title) {
        System.out.printf("%s--- Page %d\n%n", title, pageNumber);
    }

    public int getPageOffset() {
        return (pageNumber - 1) * rowsPerPage * colsPerPage + 1;
    }

    public int getNumberOfNumbers() {
        return numbers.length - 1;
    }
}
