package ch.heig.dai.lab.fileio.kdemont;

import java.io.File;
import java.util.HashSet;
import java.util.Objects;

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
        File[] files = folder.listFiles();

        assert files != null;

        // find the first file in folder that is not in known files
        for (File file : files) {
            if (!knownFiles.contains(file)) {
                knownFiles.add(file);
                return file;
            }
        }
        return null;
    }
}