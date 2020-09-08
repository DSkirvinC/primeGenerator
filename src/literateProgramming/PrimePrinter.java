package literateProgramming;


public class PrimePrinter {
    public static void main(String[] args) {

        int candidatePrime = 1;
        int lastPrimeIndex = 1;
        final int numPrimes = 1000;
        int[] primes = new int[numPrimes + 1];
        primes[1] = 2;
        int ORD = 2;
        int nextPrimeSquare = 9;

        int N = 0;
        final int ORDMAX = 30;
        int[] multiples = new int[ORDMAX + 1];
        while (lastPrimeIndex < numPrimes) {
            boolean possiblyPrime;
            do {
                candidatePrime += 2;
                if (candidatePrime == nextPrimeSquare) {
                    ORD++;
                    nextPrimeSquare = primes[ORD] * primes[ORD];
                    multiples[ORD - 1] = candidatePrime;
                }
                N = 2;
                possiblyPrime = true;
                while (N < ORD && possiblyPrime) {
                    while (multiples[N] < candidatePrime)
                        multiples[N] += primes[N] + primes[N];
                    if (multiples[N] == candidatePrime)
                        possiblyPrime = false;
                    N++;
                }
            } while (!possiblyPrime);
            lastPrimeIndex++;
            primes[lastPrimeIndex] = candidatePrime;
        }
        int pageNumber = 1;
        int pageOffset = 1;
        final int rowsPerPage = 50;
        final int colsPerPage = 4;
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
