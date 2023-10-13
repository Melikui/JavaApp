import java.time.LocalDate;
import java.time.LocalDateTime;

import static algorithm.Search.binarySearch;

public class Main {
    public static void main(String[] args) {
        int[] list = {1, 6, 3, 63, 32, 34, 43, 35};
        System.out.println(binarySearch(list, 43));
    }

}

