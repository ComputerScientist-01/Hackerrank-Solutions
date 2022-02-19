//BUCKET FILL 

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'strokesRequired' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY picture as parameter.
     */

    public static int strokesRequired(List<String> picture) {
    // convert to char array to be sure to have O(n*m) complexity
    // if the list is a linked list the complexity would be worse
    char[][] arr = new char[picture.size()][];
    int index = 0;
    for (String s : picture)
        arr[index++] = s.toCharArray();
    int count = 0;
    for (int i = 0; i < arr.length; i++)
        for (int j = 0; j < arr[i].length; j++)
            if (arr[i][j] != '-') { // '-' indicates visited
                fill(arr, arr[i][j], i, j);
                count++;
            }
    return count;
}

private static void fill(char[][] arr, char c, int i, int j) {
    if (arr[i][j] != c)
        return;
    arr[i][j] = '-';
    if (i - 1 >= 0)
        fill(arr, c, i - 1, j);
    if (j - 1 >= 0)
        fill(arr, c, i, j - 1);
    if (i + 1 < arr.length)
        fill(arr, c, i + 1, j);
    if (j + 1 < arr[i].length)
        fill(arr, c, i, j + 1);
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int pictureCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> picture = IntStream.range(0, pictureCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Result.strokesRequired(picture);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
