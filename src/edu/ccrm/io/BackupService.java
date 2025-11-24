package edu.ccrm.io;

import java.nio.file.Path;
import java.io.IOException;

public interface BackupService {
    void backupData(Path sourceDir, Path backupRootDir) throws IOException;
    long getBackupSize(Path backupDir) throws IOException;
}
