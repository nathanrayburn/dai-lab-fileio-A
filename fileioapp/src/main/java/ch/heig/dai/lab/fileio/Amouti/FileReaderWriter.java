package ch.heig.dai.lab.fileio.Amouti;

import java.io.*;
import java.nio.charset.Charset;

public class FileReaderWriter {

    /**
     * Read the content of a file with a given encoding.
     * @param file the file to read. 
     * @param encoding the encoding to use
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding) {
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to close the streams and readers at the end.
        StringBuilder content = new StringBuilder();

        try(var reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding))){

            while(reader.ready()){
                content.append(reader.readLine());
            }
            reader.close();
            return content.toString();

        }catch(IOException e) {
            return null;
        }
    }

    /**
     * Write the content to a file with a given encoding. 
     * @param file the file to write to
     * @param content the content to write
     * @param encoding the encoding to use
     * @return true if the file was written successfully, false otherwise
     */
    public boolean writeFile(File file, String content, Charset encoding) {
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to flush the data and close the streams and readers at the end.

        try(var writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding))){

            for(int i = 0; i < content.length(); ++i){
                writer.write(content.charAt(i));
            }
            writer.flush();
            writer.close();
            return true;
        }catch(IOException e) {
            return false;
        }
    }
}
