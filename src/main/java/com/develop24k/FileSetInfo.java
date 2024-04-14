package com.develop24k;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileSetInfo {

    public FileSetInfo(String dirPath) throws IOException {
        this.dirPath = dirPath;
        load();
    }

        private String dirPath;

    private String ids;
    private Date cob;
    private String region;
    private String businessArea;
    private boolean isProcessed;
    private Path riskSubjectFile;
    private Path measureFile;
    private Path riskFactorFile;


    private final String RiskSubjectFilePattern="RiskSubject";
    private final String MeasureFilePattern="Measure";
    private final String RiskFactorFilePattern="RiskFactor";

    private final String fileEndsWith=".pdf";


    private List<Path> getPaths() throws IOException {
        return Files.find(Paths.get(dirPath),1,(p, basicFileAttributes) -> basicFileAttributes.isRegularFile()).filter(x->x.toString().endsWith(fileEndsWith)).collect(Collectors.toList());

    }

    public void load() throws IOException {
        List<Path> paths = getPaths();
        riskSubjectFile=paths.stream().filter(x->x.toFile().getName().contains(RiskSubjectFilePattern)).findFirst().orElseThrow(() -> new RuntimeException("Could not find file with pattern: "+RiskSubjectFilePattern));
        measureFile=paths.stream().filter(x->x.toFile().getName().contains(MeasureFilePattern)).findFirst().orElseThrow(() -> new RuntimeException("Could not find file with pattern: "+MeasureFilePattern));
        riskFactorFile=paths.stream().filter(x->x.toFile().getName().contains(RiskFactorFilePattern)).findFirst().orElseThrow(() -> new RuntimeException("Could not find file with pattern: "+RiskFactorFilePattern));
    }

    public String getIds() {
        return ids;
    }

    public Date getCob() {
        return cob;
    }

    public String getRegion() {
        return region;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }

    public Path getRiskSubjectFile() {
        return riskSubjectFile;
    }

    public Path getMeasureFile() {
        return measureFile;
    }

    public Path getRiskFactorFile() {
        return riskFactorFile;
    }
}
