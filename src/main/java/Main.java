import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ROOT);

        runInCommandLineMode(args);
    }

    public static void runInCommandLineMode(String[] args) throws Exception {
        ArgsParser argsParser = new ArgsParser(args);

        String inputFile = argsParser.getArgumentValue("-i", "--input-file");
        String outputFile = argsParser.getArgumentValue("-o", "--output-file");

        Logic.processText(inputFile, outputFile);
    }
}