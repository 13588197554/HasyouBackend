package com.fly.util;

import com.fly.config.SystemConfig;
import com.fly.exception.FileUploadException;
import com.fly.pojo.FlyFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Properties;

/**
 * @author david
 * @date 07/08/18 18:25
 */
public class FileUtil {

    private static Properties prop = SystemConfig.global;

    private static String host_url = "http://118.24.129.227/";

    private static String FLY_PATH = "/usr/local/file";

    private static String TEST_PATH = "/tmp";

    private static String PATH = FLY_PATH;

    /**
     * 单文件上传
     * @param multipartFile
     * @param file
     * @return
     */
    public static FlyFile upload(MultipartFile multipartFile, FlyFile file) throws FileUploadException {
        OutputStream out = null;
        InputStream in = null;
        String originFilename = multipartFile.getOriginalFilename();
        String[] names = originFilename.split("\\.");
        String type = multipartFile.getContentType();
        String ext = names[names.length - 1];
        String filename = Util.getUUid() + "." + ext;
        try {
            in = multipartFile.getInputStream();
            out = new FileOutputStream(new File(PATH, filename));
            byte[] bytes = new byte[2048];
            int length = 0;
            System.out.println("文件大小:" + multipartFile.getSize());
            while ((length = in.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
        } catch (Exception e) {
            throw new FileUploadException();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        file.setFileName(originFilename);
        file.setFileUrl(host_url + filename);
        return file;
    }

    /**
     * 单文件上传
     * @param multipartFile
     * @param file
     * @return
     */
    public static FlyFile upload(MultipartFile multipartFile, FlyFile file, String...dirs) throws FileUploadException {
        OutputStream out = null;
        InputStream in = null;
        String originFilename = multipartFile.getOriginalFilename();
        String[] names = originFilename.split("\\.");
        String type = multipartFile.getContentType();
        String ext = names[names.length - 1];
        String filename = Util.getUUid() + "." + ext;
        try {
            String path = createDirs(dirs);
            in = multipartFile.getInputStream();
            out = new FileOutputStream(new File(path, filename));
            byte[] bytes = new byte[2048];
            int length = 0;
            System.out.println("文件大小:" + multipartFile.getSize());
            while ((length = in.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
        } catch (Exception e) {
            throw new FileUploadException();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        file.setFileName(originFilename);
        file.setFileUrl(host_url + filename);
        return file;
    }

    /**
     * 获取当前项目根目录
     * @return
     */
    public static String getUserDir() {
        return System.getProperty("user.dir");
    }

    /**
     * 获取该用户home目录
     * @return
     */
    public static String getUserHome() {
        return System.getProperty("user.home");
    }

    /**
     * 根据指定key获取系统参数
     * @param key
     * @return
     */
    public static String getSysValueByKey(String key) {
        return System.getProperty(key);
    }

    /**
     * 通过绝对路径的方式加载配置文件
     * @param abPath 配置文件绝对路径
     * @param fileName
     */
    public static void loadProp(String abPath, String fileName) throws IOException {
        String fullName = abPath + "/" + fileName;
        File file = new File(fullName);
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
    }

    /**
     * 从classpath下加载配置文件
     * @param fileName classpath下文件名
     */
    public static void loadProp(String fileName) throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream(fileName);
        prop.load(is);
    }

    /**
     * 保存properties配置信息
     * @param p
     * @param filePath 文件路径
     * @param fileName 文件名
     * @throws IOException
     */
    public static void storeConfigFile(Properties p, String filePath, String fileName) throws IOException {
        String fullPath = filePath + "/" + fileName;
        File file = new File(fullPath);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream stream = new FileOutputStream(file);
        p.store(stream, fullPath);
    }

    /**
     * 创建多级文件夹
     * @param dirs 多级文件夹路径
     */
    public static String createDirs(String...dirs) {
        String path = PATH;
        for (String dir : dirs) {
            path += "/" + dir;
        }
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }

    /**
     * 创建单级文件夹
     * @param dirName 单机文件夹名
     */
    public static void createDir(String dirName) {
        File file = new File(dirName);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static void main(String[] args) throws IOException {

    }

}