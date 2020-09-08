package literateProgramming;

public class NumberPrinter {
    private final int colsPerPage;
    private final int rowsPerPage;

    public NumberPrinter(int colsPerPage, int rowsPerPage) {
        this.colsPerPage = colsPerPage;
        this.rowsPerPage = rowsPerPage;
    }

    void print(int numPrimes, int[] primes) {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= numPrimes) {
            System.out.print("The First ");
            System.out.print(Integer.toString(numPrimes));
            System.out.print(" Prime Numbers --- Page ");
            System.out.print(Integer.toString(pageNumber));
            System.out.println("\n");
            for (int rowOffset = pageOffset; rowOffset <= pageOffset + rowsPerPage - 1; rowOffset++) {
                for (int col = 0; col <= colsPerPage - 1; col++)
                    if (rowOffset + col * rowsPerPage <= numPrimes)
                        System.out.printf("%10d", primes[rowOffset + col * rowsPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pageNumber++;
            pageOffset += rowsPerPage * colsPerPage;
        }
    }

}
