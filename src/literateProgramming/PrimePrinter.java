package literateProgramming;


public class PrimePrinter {
    public static void main(String[] args) {
        final int numPrimes = 1000;
        PrimeGenerator primeGenerator = new PrimeGenerator(numPrimes);
        NumberPrinter numberPrinter = new NumberPrinter(4, 50);
        numberPrinter.print(primeGenerator.generate());
    }

}
