package ch.heig.dai.lab.fileio.michaelstrefeler;

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
        String newString = source;
        newString = newString.replace("Chuck Norris", newName);
        return newString;
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        StringBuilder newString = new StringBuilder(source);
        for(int i = 0; i < newString.length(); i++){
            if(i == 0 || newString.charAt(i-1) == ' '){
               newString.setCharAt(i, Character.toUpperCase(newString.charAt(i)));
            }
        }
        return newString.toString();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        // Use the StringBuilder class to build the result string.
        StringBuilder newString = new StringBuilder();
        int lineNumber = 1;
        String[] words = source.split(" ");
        int temp = 1;
        newString.append(lineNumber+".");
        for (String word: words) {
            newString.append(' ').append(word);
            if(temp == numWordsPerLine){
                newString.append('\n');
                lineNumber++;
                newString.append(lineNumber+".");
                temp = 1;
            }else{
                temp++;
            }

        }
        newString.append("\n");
        return newString.toString();
    }
}   