package literateProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;

class PrimeGenerator {
    private final ArrayList<Integer> oddPrimes = new ArrayList<>();
    private int numPrimes;
    private int candidatePrime = 3;
    private ArrayList<Multiple> multiples = new ArrayList<Multiple>();

    public PrimeGenerator(int numPrimes) {
        this.numPrimes = numPrimes;
        oddPrimes.add(3);
    }

    public int[] generate() {
        while (needMorePrimes()) storeNextPrime(computeNextPrime());
        return getPrimesArray();
    }

    private int[] getPrimesArray() {
        int[] primes = new int[oddPrimes.size() + 2];
        primes[1] = 2;
        for (int i = 0; i < oddPrimes.size(); i++) {
            primes[i + 2] = oddPrimes.get(i);
        }
        return primes;
    }

    private boolean needMorePrimes() {
        return oddPrimes.size() + 1 < numPrimes;
    }

    private void storeNextPrime(int nextPrime) {
        oddPrimes.add(nextPrime);
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
        return oddPrimes.get(multiples.size());
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
