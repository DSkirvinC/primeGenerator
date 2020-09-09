package literateProgramming;

class PrimeGenerator {
    private int numPrimes;
    private int candidatePrime = 1;
    private int lastPrimeIndex = 1;
    private int[] primes;
    private int ord = 2;
    private int ordmax = 30;
    private int[] multiples = new int[ordmax + 1];

    public PrimeGenerator(int numPrimes) {
        this.numPrimes = numPrimes;
        primes = new int[numPrimes + 1];
        primes[1] = 2;
    }

    public int[] generate() {
        while (needMorePrimes()) storeNextPrime(computeNextPrime());
        return primes;
    }

    private boolean needMorePrimes() {
        return lastPrimeIndex < numPrimes;
    }

    private void storeNextPrime(int nextPrime) {
        primes[++lastPrimeIndex] = nextPrime;;
    }

    private int computeNextPrime() {
        do {
            candidatePrime += 2;
            addNextMultipleEntryIfReachedNextPrimeSquare();
        } while (candidateIsComposite());
        return candidatePrime;
    }

    private void addNextMultipleEntryIfReachedNextPrimeSquare() {
        if (candidatePrime == primes[ord] * primes[ord]) multiples[ord++] = candidatePrime;
    }

    private boolean candidateIsComposite() {
        for (int n = 2 ; n < ord; n++) {
            if (candidateIsNthMultiple(n)) return true;
        }
        return false;
    }

    private boolean candidateIsNthMultiple(int n) {
        updateNthMultiple(n);
        return multiples[n] == candidatePrime;
    }

    private void updateNthMultiple(int n) {
        while (multiples[n] < candidatePrime)
            multiples[n] += primes[n] + primes[n];
    }
}
