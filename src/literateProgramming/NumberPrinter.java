package literateProgramming;

public class NumberPrinter {
    private final int colsPerPage;
    private final int rowsPerPage;
    private int[] numbers;

    public NumberPrinter(int colsPerPage, int rowsPerPage) {
        this.colsPerPage = colsPerPage;
        this.rowsPerPage = rowsPerPage;
    }

    void print(int[] numbers, String title) {
        this.numbers = numbers;
        int pageNumber = 1;
        while (needToPrintMore(pageNumber)) {
            printHeader(title, pageNumber);
            printNumbersOnPage(pageNumber);
            System.out.println("\f");
            pageNumber++;
        }
    }

    private boolean needToPrintMore(int pageNumber) {
        return getPageOffset(pageNumber) <= getNumberOfNumbers();
    }

    private void printNumbersOnPage(int pageNumber) {
        for (int row = 0; row < rowsPerPage; row++) {
            for (int col = 0; col < colsPerPage; col++)
                printNumberAt(getPageOffset(pageNumber) + row + col * rowsPerPage);
            System.out.println();
        }
    }

    private void printNumberAt(int index) {
        if (index <= this.getNumberOfNumbers())
            System.out.printf("%10d", this.numbers[index]);
    }

    private void printHeader(String title, int pageNumber) {
        System.out.printf("%s--- Page %d\n%n", title, pageNumber);
    }

    public int getPageOffset(int pageNumber) {
        return (pageNumber - 1) * rowsPerPage * colsPerPage + 1;
    }

    public int getNumberOfNumbers() {
        return numbers.length - 1;
    }
}
