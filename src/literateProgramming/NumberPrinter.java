package literateProgramming;

public class NumberPrinter {
    private final int colsPerPage;
    private final int rowsPerPage;
    private int pageNumber;
    private int pageOffset;
    private int numberOfNumbers;
    private int[] numbers;

    public NumberPrinter(int colsPerPage, int rowsPerPage) {
        this.colsPerPage = colsPerPage;
        this.rowsPerPage = rowsPerPage;
    }

    void print(int[] numbers) {
        initialize(numbers);
        while (needToPrintMore()) {
            printHeader();
            printNumbersOnPage();
            moveToNextPage();
        }
    }

    private boolean needToPrintMore() {
        return pageOffset <= numberOfNumbers;
    }

    private void initialize(int[] numbers) {
        this.numbers = numbers;
        pageNumber = 1;
        pageOffset = 1;
        numberOfNumbers = this.numbers.length - 1;
    }

    private void moveToNextPage() {
        System.out.println("\f");
        pageNumber++;
        pageOffset += rowsPerPage * colsPerPage;
    }

    private void printNumbersOnPage() {
        for (int row = 0; row < rowsPerPage; row++) {
            for (int col = 0; col < colsPerPage; col++)
                printNumberAt(pageOffset + row + col * rowsPerPage);
            System.out.println();
        }
    }

    private void printNumberAt(int index) {
        if (index <= this.numberOfNumbers)
            System.out.printf("%10d", this.numbers[index]);
    }

    private void printHeader() {
        System.out.print("The First ");
        System.out.print(Integer.toString(numberOfNumbers));
        System.out.print(" Prime Numbers --- Page ");
        System.out.print(Integer.toString(pageNumber));
        System.out.println("\n");
    }

}
