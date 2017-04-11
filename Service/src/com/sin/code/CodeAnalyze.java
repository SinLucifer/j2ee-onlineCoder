package com.sin.code;

import com.sun.scenario.effect.impl.prism.PrImage;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;

public class CodeAnalyze {
    private String type;
    private String code;
    private String name;
    private File file;
    private static final String DIRTY_GROUP = "D:\\j2ee\\apache-tomcat-8.5.12-windows-x64\\apache-tomcat-8.5.12\\bin";
    private static final String JAVA_GROUP = "D:\\j2ee\\apache-tomcat-8.5.12-windows-x64\\apache-tomcat-8.5.12\\bin\\codes\\java ";
    private static final String C_GROUP = "D:\\j2ee\\apache-tomcat-8.5.12-windows-x64\\apache-tomcat-8.5.12\\bin\\codes\\c\\";
    private static final String PHP_GROUP = "D:\\j2ee\\apache-tomcat-8.5.12-windows-x64\\apache-tomcat-8.5.12\\bin\\codes\\php";
    private static final String JS_GROUP = "D:\\j2ee\\apache-tomcat-8.5.12-windows-x64\\apache-tomcat-8.5.12\\bin\\codes\\js";
    private static final String PY_GROUP = "D:\\j2ee\\apache-tomcat-8.5.12-windows-x64\\apache-tomcat-8.5.12\\bin\\codes\\py";
    private static final String CPP_GROUP = "D:\\j2ee\\apache-tomcat-8.5.12-windows-x64\\apache-tomcat-8.5.12\\bin\\codes\\cpp";

    public CodeAnalyze(String type, String code) {
        this.type = type;
        this.code = code;
        this.name = reName();
        file = Util.writeToFile(this.code,type,name);
    }

    private String reName(){
        String name = System.currentTimeMillis()+"";
        code = code.replaceFirst("Test","T"+name);
        return "T"+name;
    }

    public String runCode(){
        String result = null;
        switch (type){
            case "c":
                result = runC();
                break;
            case "java":
                result = runJava();
                break;
            case "py":
                result = runPy();
                break;
            case "php":
                result = runPHP();
                break;
            case "js":
                result = runJs();
                break;
            case "cpp":
                result = runCpp();
                break;
        }

        return shapeResult(result);
    }

    private String shapeResult(String dirty){
        return dirty.replace(DIRTY_GROUP,"");
    }

    private String runJs(){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String result = null;
        try{
            result =  engine.eval(code).toString();
        }catch (ScriptException e){
            e.printStackTrace();
        }
        return result;
    }

    private String runC(){
        String result;
        result = Util.exeCmd("gcc " + file.getAbsolutePath() + " -o " + C_GROUP+name);
        if (result.equals(""))
            result = Util.exeCmd(C_GROUP+name);
        return result;
    }

    private String runJava(){
        String result;
        result = Util.exeCmd("javac "+ file.getAbsolutePath());
        if (result.equals(""))
            result = Util.exeCmd("java -cp "+ JAVA_GROUP + name);
        return result;
    }

    private String runCpp(){
        String result;
        result = Util.exeCmd("g++ " + file.getAbsolutePath() + " -o " + CPP_GROUP+name);
        if (result.equals(""))
            result = Util.exeCmd(CPP_GROUP+name);
        return result;
    }

    private String runPy(){
        return Util.exeCmd("python " + file.getAbsolutePath());
    }

    private String runPHP(){
        return Util.exeCmd("php " + file.getAbsolutePath());
    }
}
