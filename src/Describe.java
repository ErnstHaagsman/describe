import java.io.InputStreamReader;

public class Describe {
    public static void main(String[] args) throws Exception {
        System.out.println("User: " + System.getProperty("user.name"));
        System.out.println();

        long charCount = 0;
        InputStreamReader stdIn = new InputStreamReader(System.in);
        if (stdIn.ready()) {
            char[] dest = new char[16384];
            int charsRead = 0;
            do {
                charsRead = stdIn.read(dest);
                charCount += charsRead;
            } while (charsRead > 0);
        }
        System.out.format("Read %d chars from stdin", charCount);
    }
}
