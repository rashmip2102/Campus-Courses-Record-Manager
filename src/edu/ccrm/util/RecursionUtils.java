package edu.ccrm.util;

import java.io.File;

public class RecursionUtils {
    public static long getTotalSize(File folder) {
        long totalSize = 0;
        if (folder.isFile()) {
            return folder.length();
        }
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                totalSize += getTotalSize(f);
            }
        }
        return totalSize;
    }
}
