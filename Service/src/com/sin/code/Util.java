package com.sin.code;

import java.io.*;

public class Util {

    public static File writeToFile (String code,String type,String name){
        FileWriter fw = null;
        File file = new File("codes/"+ type,name+"."+type);
        if (file.exists()){
            System.out.println("File exist,recover it" + file.getAbsolutePath());
        }else{
            try{
                boolean isCreate = file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        try{
            fw = new FileWriter(file,false);
            fw.write(code);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            close(fw);
        }

        return file;
    }

    public static String exeCmd(String commandStr) {
        BufferedReader scReader = null;
        BufferedReader errorReader = null;

        StringBuilder sc = new StringBuilder();
        StringBuilder se = new StringBuilder();
        try {
            Process p = Runtime.getRuntime().exec(commandStr);
            scReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String line = null;
            while ((line = scReader.readLine()) != null) {
                sc.append(line + "\n");
            }

            while ((line = errorReader.readLine()) != null) {
                se.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            close(errorReader);
            close(scReader);
        }

        if (!sc.toString().trim().equals(""))
            return sc.toString().trim();
        else
            return se.toString().trim();
    }

    public static void close(Closeable c){
        try{
            if (c != null)
                c.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
