package literateProgramming;

public class NumberPrinter {
    private final Page page;

    public NumberPrinter(int colsPerPage, int rowsPerPage) {
        page = new Page(colsPerPage, rowsPerPage);
    }

    void print(int[] numbers, String title) {
        this.page.setNumbers(numbers);
        while (page.hasNext()) {
            page.nextPage();
            printPage(title);
        }
    }

    private void printPage(String title) {
        printHeader(title);
        printNumbersOnPage();
        printFooter();
    }

    private void printNumbersOnPage() {
        for (int row = 0; row < page.rowsPerPage; row++) {
            for (int col = 0; col < page.getColsPerPage(); col++) {
                if (page.hasEntry(row, col))
                    System.out.printf("%10d", getEntryAt(row, col));
            }
            System.out.println();
        }
    }

    private int getEntryAt(int row, int col) {
        return page.numbers[page.getIndexFor(row, col)];
    }

    private void printHeader(String title) {
        System.out.printf("%s--- Page %d\n%n", title, page.getPageNumber());
    }

    private void printFooter() {
        System.out.println("\f");
    }

}
