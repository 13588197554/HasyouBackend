package com.fly.util;

import java.io.*;

/**
 * @author david
 * @date 09/08/18 16:43
 */
public class LogUtil {

//    private static String LOG_PATH = "/usr/local/log/api/";
    private static String LOG_PATH = "/tmp/";

    public static void info(Class clazz, String fileName, Exception e) {
        String className = clazz.getSimpleName();
        File logDir = new File(LOG_PATH + className);
        if (!logDir.exists()) {
            logDir.mkdirs();
        }

        File file = new File(LOG_PATH + className + "/" + fileName + ".log");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file, true); // 追加
            bw = new BufferedWriter(fw);
            String message = e.toString();
            StackTraceElement[] stackTrace = e.getStackTrace();
            bw.write(message + " --" + Util.getCurrentFormatTime());
            for (StackTraceElement ste : stackTrace) {
                String m = ste.toString();
                bw.newLine();
                bw.write("\t" + m);
            }
            bw.newLine();
            bw.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }

            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static PrintWriter getPrint() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("/tmp/api/Main/main.log");
        return new PrintWriter(fos, true);
    }

}
