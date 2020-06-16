import java.io.InputStreamReader;
import java.util.Map;

public class Describe {
    public static void main(String[] args) throws Exception {
        // Display the current username
        System.out.println("User: " + System.getProperty("user.name"));
        System.out.println();
        assert System.getProperty("user.name").length() > 0;

        // Describe how many characters can be read from stdin
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
        assert charCount > 0;
        System.out.format("Read %d chars from stdin", charCount);
        System.out.println();

        // Describe the CLI args
        System.out.println("Command-line arguments:");
        for (int i = 0; i < args.length; i++){
            System.out.format("Arg %d: %s%s", i, args[i], System.lineSeparator());
        }
        System.out.println();

        // Describe part of the environment
        System.out.println("Environment variables starting with the letter H:");
        System.out.println("-------------------------------------------------");
        Map<String,String> env = System.getenv();
        assert !env.isEmpty();
        env.entrySet().stream()
                .filter(x -> x.getKey().toUpperCase().startsWith("H"))
                .forEach(x -> System.out.format("%30s: %-40s%s", x.getKey(), x.getValue(), System.lineSeparator()));
    }
}
