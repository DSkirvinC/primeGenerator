package literateProgramming;

import java.util.ArrayList;

class PrimeGenerator {
    private int numPrimes;
    private int candidatePrime = 1;
    private int lastPrimeIndex = 1;
    private int[] primes;
    private ArrayList<Multiple> multiples = new ArrayList<Multiple>();

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
            maybeAddNextMultiple(nextPrimeFactor());
        } while (candidateIsComposite());
        return candidatePrime;
    }

    private void maybeAddNextMultiple(int prime) {
        if (candidatePrime == prime * prime) addNewMultiple();
    }

    private void addNewMultiple() {
        multiples.add(new Multiple(nextPrimeFactor()));
    }

    private int nextPrimeFactor() {
        return primes[multiples.size() + 2];
    }

    private boolean candidateIsComposite() {
        for (Multiple multiple : multiples) {
            if (multiple.becomes(candidatePrime)) return true;
        }
        return false;
    }

    private class Multiple {
        private final int prime;
        private int value;

        public Multiple(int prime) {
            this.prime = prime;
            value = prime * prime;
        }

        private boolean becomes(int number) {
            updateToReach(number);
            return value == number;
        }

        private void updateToReach(int number) {
            while (value < number)
                value += prime + prime;
        }
    }
}
