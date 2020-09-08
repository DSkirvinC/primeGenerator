package literateProgramming;

public class Page {
    final int colsPerPage;
    final int rowsPerPage;
    int pageNumber = 0;
    int[] numbers;

    public Page(int colsPerPage, int rowsPerPage) {
        this.colsPerPage = colsPerPage;
        this.rowsPerPage = rowsPerPage;
    }

    public int getPageOffset() {
        return (pageNumber - 1) * rowsPerPage * colsPerPage + 1;
    }

    public int getNextPageOffset() { return pageNumber * rowsPerPage * colsPerPage + 1; }

    public int getNumberOfNumbers() {
        return numbers.length - 1;
    }

    public int getColsPerPage() {
        return colsPerPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    boolean hasNext() {
        return getNextPageOffset() <= getNumberOfNumbers();
    }

    void nextPage() {
        this.pageNumber = getPageNumber() + 1;
    }

    int getIndexFor(int row, int col) {
        return getPageOffset() + row + col * rowsPerPage;
    }

    boolean hasEntry(int row, int col) {
        return getIndexFor(row, col) <= getNumberOfNumbers();
    }
}