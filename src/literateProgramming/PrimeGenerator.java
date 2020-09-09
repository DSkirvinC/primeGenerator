package literateProgramming;

import java.util.ArrayList;

class PrimeGenerator {
    private int numPrimes;
    private int candidatePrime = 1;
    private int lastPrimeIndex = 1;
    private int[] primes;
    private ArrayList<Integer> multiples = new ArrayList<>();

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
        if (candidatePrime == primes[getOrd()] * primes[getOrd()]) addNewMultiple(candidatePrime);
    }

    private void addNewMultiple(int candidatePrime) {
        multiples.add(candidatePrime);
    }

    private boolean candidateIsComposite() {
        for (int n = 2; n < getOrd(); n++) {
            if (candidateIsNthMultiple(n)) return true;
        }
        return false;
    }

    private boolean candidateIsNthMultiple(int n) {
        updateNthMultiple(n);
        return getNthMultiple(n) == candidatePrime;
    }

    private int getNthMultiple(int n) {
        return multiples.get(n -2);
    }

    private void updateNthMultiple(int n) {
        while (getNthMultiple(n) < candidatePrime)
            increaseNthMultipleBy(n, primes[n] + primes[n]);
    }

    private void increaseNthMultipleBy(int n, int amount) {
        int index = n - 2;
        multiples.set(index, multiples.get(index) + amount);
    }

    public int getOrd() {
        return multiples.size() + 2;
    }
}
