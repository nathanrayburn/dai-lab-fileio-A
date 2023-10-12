package ch.heig.dai.lab.fileio.RemiAncay;

import java.io.*;
import java.nio.charset.Charset;

public class FileReaderWriter {

    /**
     * Read the content of a file with a given encoding.
     * @param file the file to read. 
     * @param encoding
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding) {

        try (var reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding))){
            
            var builder = new StringBuilder();
            String line;

            //Get the content
            while((line = reader.readLine()) != null){
                builder.append(line + "\n");
            }

            //Close the reader and return the content
            reader.close();
            return builder.toString();
        } catch (IOException e) {
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

        try (var writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding))) {
            
            writer.write(content, 0, content.length());

            writer.flush();
            writer.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
