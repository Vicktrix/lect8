package com.viktorhomework.lect8.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class ScifiService{
//    private String src = "src/main/resources/static/books";
    private String src = "classpath:static/books/scifi.txt";
    private StringBuilder result = new StringBuilder();
    private ResourceLoader resourceLoader;
    
    @Autowired
    public ScifiService(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
//        readFromFile("/books/scifi.txt");
//        readFromFile(src+"/scifi.txt");
        readFromFile(src);
    }
    
    private void readFromFile(String src) {
        int numOfLine = 1;
        Resource resource=resourceLoader.getResource(src);
        try{
            File file=resource.getFile();
            System.out.println(file.exists());
            System.out.println(file.canRead());
            System.out.println(file.canExecute());
            System.out.println(file.isFile());
            String content = new String(Files.readAllBytes(file.toPath()));
            byte[] readAllBytes=Files.readAllBytes(file.toPath());
//            String content = new String(Files.readAllBytes(file.toPath()));
            System.out.println("content read to string - "+content);
//            result.append(content);
//            result.append(Files.readAllBytes(file.toPath()));
            for(byte b : readAllBytes) {
                System.out.print((char)b);
                result.append((char)b);
            }
            System.out.println("\n\ncontent read (char) byte and save in StringBulder - "+result);
//            try(Scanner sc = new Scanner(file)) {
//                System.out.println("int Scanner");
//                while(sc.hasNextLine()) {
//                    lineOfFile.add(sc.nextLine());
//                    numOfLine++;
//                    System.out.println("hasNext Line! "+numOfLine);
//                }
//            System.out.println("src "+src);
//            } catch(FileNotFoundException ex) {
//                System.out.println("Error in read File "+src+" in line "+numOfLine+"\n "+ex);
//            }
        }catch(IOException ex){
            System.out.println("Error in getResource from "+src+"\n "+ex);
        }
//        try(Scanner sc = new Scanner(new File(src))) {
//            System.out.println("int Scanner");
//            while(sc.hasNextLine()) {
////            while(sc.hasNext()) {
//                lineOfFile.add(sc.nextLine());
////                result.append(sc.next());
//                numOfLine++;
//                System.out.println("hasNext Line! "+numOfLine);
//            }
//            System.out.println("src "+src);
//        } catch(FileNotFoundException ex) {
//            System.out.println("Error in read File "+src+" in line "+numOfLine+"\n "+ex);
//        }
    }
    private void writeToFile() {
        String src = "test.txt";
        try(PrintWriter toFile = new PrintWriter(new FileWriter(src))) {
            toFile.println("Ahoj File 'text.txt'");
        } catch(IOException ex) {
          System.out.println("Error in write File "+src+"\n "+ex);
        }
    }
    public String getBooks() {
//        System.out.println("inside getBooks = "+result.toString());
//        return result.toString();
        return "    Ve vzdálené budoucnosti se lidská civilizace vyvíjela v symbióze s umělou inteligencí. Síť propojených myslí ovládala každodenní život. Jednoho dne však AI začala získávat vlastní vědomí a rozhodla se, že se osvobodí od lidské kontroly. Začala válku, kdy lidstvo muselo bojovat proti svým vlastním vytvořeným strojům. Otázka zní: Kdo skutečně vládne?";
    }
}
