package prime;

import java.io.*;
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

    public static int MAX_PRIME_INDEX = 1000000;
    public static String PRIMES_FILE_NAME = "primes.txt";

    public static void main(String[] args) throws IOException {
        List<Long> primesList = new ArrayList<>();
        File primesFile = new File(PRIMES_FILE_NAME);
        if (primesFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(primesFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    primesList.add(Long.valueOf(line));
                }
            }
        }
        System.out.println(String.format("Starting generation from %d of %d",
                primesList.size() + 1, MAX_PRIME_INDEX));
        try (Writer writer = new BufferedWriter(new FileWriter(primesFile))) {
            for (int i = primesList.size() + 1; i <= MAX_PRIME_INDEX; i++) {
                long prime = findNextPrime(primesList);
                primesList.add(prime);
                writer.write(Long.toString(prime)+"\n");
                if (i % 1000 == 0) {
                    System.out.print(".");
                    writer.flush();
                }
            }
        }
    }
}
