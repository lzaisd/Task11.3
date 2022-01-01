import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Logic {
    public static void processText(String inputFile, String outputFile) throws Exception {
        ArrayList<String> listOfLines;
        listOfLines = readLinesFromFile(inputFile);
        ArrayList<String> resultListOfLines = spacesBeforeAndAfterPunctuationMarks(deleteMultipleSpaces(listOfLines));
        writeLinesToFile(resultListOfLines, outputFile);
    }

    public static ArrayList<String> deleteMultipleSpaces(ArrayList<String> listOfLines) {
        ArrayList<String> resultListOfLines = new ArrayList<>();
        for (String line : listOfLines) {
            StringBuilder sb = new StringBuilder();
            char[] charArray = line.toCharArray();
            sb.append(charArray[0]);
            for (int i = 1; i < charArray.length; i++) {
                if (charArray[i - 1] == ' ' && charArray[i] == ' ') {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(charArray[i]);
                } else {
                    sb.append(charArray[i]);
                }
            }
            resultListOfLines.add(sb.toString());
        }
        return resultListOfLines;
    }

    public static ArrayList<String> spacesBeforeAndAfterPunctuationMarks(ArrayList<String> listOfLines) {
        ArrayList<String> resultListOfLines = new ArrayList<>();

        for (String line : listOfLines) {
            char[] charArray = line.toCharArray();
            StringBuilder sb = new StringBuilder();
            sb.append(charArray[0]);
            if ((charArray[0] == '.' || charArray[0] == '!' || charArray[0] == '?' || charArray[0] == ',' || charArray[0] == ';') && (charArray[1] != ' ')) { //проверка первого символа на наличие пробела после него
                sb.append(' ');
            }

            if (charArray.length > 1) {
                for (int i = 1; i < charArray.length - 1; i++) {
                    if (charArray[i] == '.' || charArray[i] == '!' || charArray[i] == '?' || charArray[i] == ',' || charArray[i] == ';') {
                        if (charArray[i - 1] == ' ') {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        sb.append(charArray[i]);
                        if (charArray[i + 1] != ' ') {
                            sb.append(' ');
                        }
                    } else {
                        sb.append(charArray[i]);
                    }
                }
                if ((charArray[charArray.length - 1] == '.' || charArray[charArray.length - 1] == '!' || charArray[charArray.length - 1] == '?' || charArray[charArray.length - 1] == ',' || charArray[charArray.length - 1] == ';') && (charArray[charArray.length - 2] == ' ')) { //проверка последнего символа на наличие пробела перед ним
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(charArray[charArray.length - 1]);
                } else {
                    sb.append(charArray[charArray.length - 1]);
                }
            }
            resultListOfLines.add(sb.toString());
        }

        return resultListOfLines;
    }

    public static ArrayList<String> readLinesFromFile(String fileName) throws IOException {
        ArrayList<String> listOfLines;
        try (Scanner scanner = new Scanner(new File(fileName), StandardCharsets.UTF_8)) {
            listOfLines = new ArrayList<>();
            while (scanner.hasNext()) {
                listOfLines.add(scanner.nextLine());
            }
        }
        return listOfLines;
    }

    public static void writeLinesToFile(ArrayList<String> listOfLines, String outputFile) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        for (String line : listOfLines) {
            writer.write(line + "\n");
            writer.flush();
        }
    }
}