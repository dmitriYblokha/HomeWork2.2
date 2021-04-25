package com.gmail.dimablogha;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SaveTo()
class TextContainer{
    String text = "Hello World!";
    
    @Saver
    public void save(String path){
        File file = new File(path);
        try(PrintWriter pw = new PrintWriter(file)){
            pw.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        TextContainer cont = new TextContainer();
        Class<?> cls = TextContainer.class;
        SaveTo svto = cls.getAnnotation(SaveTo.class);
        Method[] methods = cls.getMethods();
        for (Method method: methods){
            if (method.isAnnotationPresent(Saver.class)){
                try {
                    method.invoke(cont,svto.path());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
