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
        while (needMorePrimes()) computeAndStoreNextPrime();
        return primes;
    }

    private void computeAndStoreNextPrime() {
        do {
            candidatePrime += 2;
            addNextMultipleEntryIfReachedNextPrimeSquare();
            updateMultiplesToReachCandidate();
        } while (candidateIsComposite());
        lastPrimeIndex++;
        primes[lastPrimeIndex] = candidatePrime;
    }

    private boolean candidateIsComposite() {
        for (int n = 2 ; n < ord; n++) {
            if (multiples[n] == candidatePrime)
                return true;
        }
        return false;
    }

    private void updateMultiplesToReachCandidate() {
        for (int n = 2 ; n < ord; n++){
            while (multiples[n] < candidatePrime)
                multiples[n] += primes[n] + primes[n];
        }
    }

    private void addNextMultipleEntryIfReachedNextPrimeSquare() {
        if (candidatePrime == primes[ord] * primes[ord]) multiples[ord++] = candidatePrime;
    }

    private boolean needMorePrimes() {
        return lastPrimeIndex < numPrimes;
    }
}
