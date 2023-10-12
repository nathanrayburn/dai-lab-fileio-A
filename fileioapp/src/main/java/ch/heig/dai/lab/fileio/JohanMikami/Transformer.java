package ch.heig.dai.lab.fileio.JohanMikami;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;

public class Transformer {

    private final String newName;
    private final int numWordsPerLine;


    /**
     * Constructor
     * Initialize the Transformer with the name to replace "Chuck Norris" with 
     * and the number of words per line to use when wrapping the text.
     * @param newName the name to replace "Chuck Norris" with
     * @param numWordsPerLine the number of words per line to use when wrapping the text
     */
    public Transformer(String newName, int numWordsPerLine) {
        this.newName = newName;
        this.numWordsPerLine = numWordsPerLine;
    }

    /**
     * Replace all occurrences of "Chuck Norris" with the name given in the constructor.
     * @param source the string to transform
     * @return the transformed string
     */
    public String replaceChuck(String source) {
        // TODO: Implement the method body here.
        try {
            return source.replace("Chuck Norris", newName);
        }catch (Exception e) {
            return "";
        }
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        // TODO: Implement the method body here.
        try {
            StringBuilder strbuild = new StringBuilder();
            String[] splitSources = source.split(" ");
            for (String str:splitSources) {
                if (!Objects.equals(str, splitSources[0]))strbuild.append(" ");
                strbuild.append(str.substring(0, 1).toUpperCase()).append(str.substring(1));
            }
            return strbuild.toString();
        }catch (Exception e) {
            return "";
        }
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        // TODO: Implement the method body here.
        // Use the StringBuilder class to build the result string.
        try {
            StringBuilder str = new StringBuilder("1.");
            String[] splitSources = source.split(" ");
            for (int i = 1, j = 1; i <= splitSources.length; i++) {
                str.append(" ").append(splitSources[i-1]);
                if (i%numWordsPerLine==0) {
                    str.append("\n").append(++j).append(".");
                }
            }
            return str.append("\n").toString();
        }catch (Exception e){
            return "";
        }
    }
}   