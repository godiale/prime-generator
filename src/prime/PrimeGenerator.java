package prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator {

    static Long findNextPrime(List<Long> primesList) {
        if (primesList.isEmpty()) {
            return 2L;
        }
        long nextCandidate = primesList.get(primesList.size()-1) + 1;
        while (true) {
            boolean isPrime = true;
            for (long p : primesList) {
                if (nextCandidate % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                break;
            }
            nextCandidate += 1;
        }
        return nextCandidate;
    }

    public static void main(String[] args) {
        List<Long> primesList = new ArrayList<>();
        long prime = findNextPrime(primesList);
        primesList.add(prime);
        primesList.stream().forEach(System.out::println);
    }
}
