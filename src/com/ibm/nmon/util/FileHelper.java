package com.ibm.nmon.util;

import java.io.File;
import java.io.FileFilter;

import java.util.List;

public final class FileHelper {
    public static void recurseDirectories(File[] files, FileFilter filter, List<String> toParse) {
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                recurseDirectories(files[i].listFiles(), filter, toParse);
            }
            else {
                if (filter.accept(files[i])) {
                    toParse.add(files[i].getPath());
                }
            }
        }
    }

    public static void recurseDirectories(List<File> files, FileFilter filter, List<String> filenames) {
        for (File file : files) {
            if (file.isDirectory()) {
                recurseDirectories(file.listFiles(), filter, filenames);
            }
            else {
                if (filter.accept(file)) {
                    filenames.add(file.getPath());
                }
            }
        }
    }

    private FileHelper() {}
}