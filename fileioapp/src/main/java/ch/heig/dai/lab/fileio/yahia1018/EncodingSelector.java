package ch.heig.dai.lab.fileio.yahia1018;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class EncodingSelector {

    /**
     * Get the encoding of a file based on its extension.
     * The following extensions are recognized:
     *   - .utf8:    UTF-8
     *   - .txt:     US-ASCII
     *   - .utf16be: UTF-16BE
     *   - .utf16le: UTF-16LE
     * 
     * @param file the file to get the encoding from
     * @return the encoding of the file, or null if the extension is not recognized
     */
    public Charset getEncoding(File file) {
        String filePath = file.getName();
        int lastDotIndex = filePath.lastIndexOf('.');

        // We check that the index is valid
        if (lastDotIndex > 0 & lastDotIndex < filePath.length() - 1){
            String extension = filePath.substring(lastDotIndex + 1);

            switch(extension){
                case "utf8":
                    return StandardCharsets.UTF_8;
                case "txt":
                    return StandardCharsets.US_ASCII;
                case "utf16be":
                    return StandardCharsets.UTF_16BE;
                case "utf16le":
                    return StandardCharsets.UTF_16LE;
                default:
                    return null;
            }
        }
        else
            System.out.println("Le fichier n'a pas d'extension.");

        return null;
    }
}