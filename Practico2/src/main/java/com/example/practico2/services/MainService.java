package com.example.practico2.services;

import com.example.practico2.model.Patient;
import com.example.practico2.model.TestResult;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class MainService {

    public Patient readPatientInformation()throws RuntimeException{
        String path = "Archivo.txt";
        StringBuilder bl = new StringBuilder();
        try(BufferedReader fl = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line=fl.readLine())!=null){
                bl.append(line).append("\n");
            }
        }catch (Exception e){
            throw new RuntimeException("No se pudo leer el archivo");
        }
        return getInfPatient(bl.toString());
    }

    private Patient getInfPatient(String patientInf){
        Patient patient = new Patient();
        String[] lines = patientInf.split("\n");
        for(String line : lines){
            String[] segment = line.split("\\|");
            switch (segment[0]){
                case "PID":
                    String name = segment[5];
                    name = name.substring(0,name.lastIndexOf("^")).replace("^"," ");
                    patient.setName(name);
                    break;
                case "OBR":
                    patient.setOrder(segment[2]);
                    break;
                case "OBX":
                    patient.getResult().add(getTestResult(segment));
                    break;
            }
        }
        return patient;
    }

    private TestResult getTestResult(String[] tetResult){
        TestResult resultTest = new TestResult();
        resultTest.setTest(tetResult[3].split("\\^")[0]);
        resultTest.setResult(tetResult[5]);

        return resultTest;
    }

}
