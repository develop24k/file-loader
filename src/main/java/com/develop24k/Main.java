package com.develop24k;

import org.apache.commons.lang3.time.StopWatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println("===================================================== ODF to ODS Converter =================================================");
        StopWatch stopWatch = new StopWatch();

        try {

            Scanner scanner = new Scanner(new File("C:\\Code\\github\\file-loader\\src\\main\\resources\\DirList.txt"));
            while (scanner.hasNextLine()) {
                stopWatch.reset();
                stopWatch.start();
                String dir = scanner.nextLine();
                System.out.println("Directory: " + dir);
                System.out.println("Loading Started (" + new java.util.Date() + ")...");

                FileSetInfo fsi = new FileSetInfo(dir);
                /*System.out.println(fsi.getRiskSubjectFile());
                System.out.println(fsi.getMeasureFile());
                System.out.println(fsi.getRiskFactorFile());*/

                //*************Processing here**************


                //******************************************

                stopWatch.stop();
                System.out.println("Done! (" + new java.util.Date() + ")");
                System.out.println("Time Taken: " + stopWatch.getTime(TimeUnit.SECONDS) + " sec");
                System.out.println("****************************************************************************************************************************");


            }

            System.out.println("====================================================== ALL DONE ============================================================");


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}