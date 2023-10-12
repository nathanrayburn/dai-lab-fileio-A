package ch.heig.dai.lab.fileio.AlejandroSta;

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
        // TODO: Implement the method body here. 
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to close the streams and readers at the end.
        try(BufferedReader reader = new BufferedReader(
                                        new InputStreamReader(
                                            new FileInputStream(file.getName()), encoding) );){
            String return_string = "", line;
            while((line = reader.readLine()) != null){
                return_string += line + "\n";
            }
            return return_string;
        }catch (IOException e){
            System.out.println("Exception: " + e);
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
        // TODO: Implement the method body here. 
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to flush the data and close the streams and readers at the end.
        try(BufferedWriter writer = new BufferedWriter(
                                        new OutputStreamWriter(
                                            new FileOutputStream(file.getName()), encoding) );){
            writer.write(content);
            writer.flush();
            return true;
        }catch (IOException e){
            System.out.println("Exception: " + e);
            return false;
        }
    }
}
