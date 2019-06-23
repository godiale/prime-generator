package prime;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    private static List<Long> createList(int... sample) {
        return Arrays.stream(sample)
                .mapToLong(i -> i)
                .boxed()
                .collect(Collectors.toList());
    }

    @Test
    void findNextPrime() {
        assertEquals(2, PrimeGenerator.findNextPrime(createList()));
        assertEquals(3, PrimeGenerator.findNextPrime(createList(2)));
        assertEquals(5, PrimeGenerator.findNextPrime(createList(2, 3)));
        assertEquals(7, PrimeGenerator.findNextPrime(createList(2, 3, 5)));
        assertEquals(7, PrimeGenerator.findNextPrime(createList(2, 3, 5)));
        assertEquals(11, PrimeGenerator.findNextPrime(createList(2, 3, 5, 7)));
        assertEquals(13, PrimeGenerator.findNextPrime(createList(2, 3, 5, 7, 11)));
    }
}