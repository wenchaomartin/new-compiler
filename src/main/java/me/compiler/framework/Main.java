package me.compiler.framework;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length > 1) {
            System.out.println("Usage: jjy [script]");
        } else if (args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }

    /**
     * 从一个文件路径读取
     *
     * @param path
     */
    public static void runFile(String path) {

        File file = new File(path);
        try {
            String s = FileUtils.readFileToString(file);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 从命令行读取
     *
     * @return
     */
    public static void runPrompt() {
        //2. todo convert string to list<Token>
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = null;
        String word = "";
        while (true) {
            System.out.println(">");
            try {
                s = bufferedReader.readLine();
                if (s == null) {
                    System.out.println(word);
                    break;
                }
                word += s;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
