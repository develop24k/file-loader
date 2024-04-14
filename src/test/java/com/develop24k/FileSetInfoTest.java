package com.develop24k;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;


public class FileSetInfoTest {

    @Test
    public void getRiskSubjectFilePath() {

        FileSetInfo fs = null;
        try {
            fs = new FileSetInfo("C:\\temp\\attachments");
            System.out.println(fs.getRiskSubjectFile());
            System.out.println(fs.getRiskFactorFile());
            System.out.println(fs.getMeasureFile());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}