package literateProgramming;

class PrimeGenerator {
    private int numPrimes;

    public PrimeGenerator(int numPrimes) {
        this.numPrimes = numPrimes;
    }

    public int[] generate() {
        int N = 0;
        int candidatePrime = 1;
        int lastPrimeIndex = 1;
        int[] primes = new int[numPrimes + 1];
        primes[1] = 2;
        int ORD = 2;
        int nextPrimeSquare = 9;
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
        return primes;
    }
}
