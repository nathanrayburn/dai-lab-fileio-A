package ch.heig.dai.lab.fileio.AlejandroSta;

import java.io.File;
import java.util.HashSet;

public class FileExplorer {
    private final File folder;
    private HashSet<File> knownFiles;

    /**
     * Constructor
     * Memorize the folder to explore and initialize the set of known files.
     * @param folder
     */
    public FileExplorer(String folder) {
        this.folder = new File(folder);
        this.knownFiles = new HashSet<File>();
    }

    /**
     * Get a single new file from the folder.
     * The file must not have been returned before.
     * Use the java.io.file API to get the list of files in the folder.
     * Use the HashSet knownFiles to keep track of the files that have already been returned.
     * @return a new file, or null if there is no new file
     */
    public File getNewFile() {
        // TODO: implement the method body here
        File[] liste = folder.listFiles();
        for(File f1 : liste){
            boolean already_known = false;
            for(File f2 : knownFiles){
                if(f1.equals(f2)){
                    already_known = true;
                    break;
                }
            }
            if(!already_known){
                knownFiles.add(f1);
                return f1;
            }
        }
        return null;
    }
}