package edu.ccrm.io;

import java.nio.file.Path;
import java.io.IOException;

public class BackupServiceImpl implements BackupService {
	
    @Override
    public void backupData(Path sourceDir, Path backupRootDir) throws IOException {
        System.out.println("Backup skipped (prototype mode).");
    }

    @Override
    public long getBackupSize(Path backupDir) {
        return 0;
    }
}
