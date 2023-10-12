package ch.heig.dai.lab.fileio.Sinaf19;

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
        String toReplace = "Chuck Norris";
        return source.replace(toReplace, this.newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        // TODO: Implement the method body here.
        String[] words = source.split(" ");
        StringBuilder capitalizeWord = new StringBuilder();
        for (String w : words) {
            String first = w.substring(0,1);
            String afterFirst = w.substring(1);
            if (w != words[words.length-1]) {
                capitalizeWord.append(first.toUpperCase()).append(afterFirst).append(" ");
            } else {
                capitalizeWord.append(first.toUpperCase()).append(afterFirst);
            }
        }
        return capitalizeWord.toString();
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
        String[] words = source.split(" ");
        StringBuilder formattedString = new StringBuilder();
        int counter = 1;
        for (int j = 0; j < words.length;) {
            formattedString.append(counter).append(". ");
            for (int i = 0; i < this.numWordsPerLine; i++) {
                formattedString.append(words[j]);
                if (i < this.numWordsPerLine - 1 && j != words.length - 1) {
                    formattedString.append(" ");
                }
                j++;
                if (j >= words.length) {
                    break;
                }
            }
            counter++;
            formattedString.append("\n");
        }


        return formattedString.toString();
    }
}   