package Input_Output;
import java.io.*;

public class Utils {
    public static String readContentFromFile(String path) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    public static void writeContentToFile(String path, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            clearFileContent(path);

            // Ghi nội dung mới
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clearFileContent(String path) throws IOException {
        try (BufferedWriter clearWriter = new BufferedWriter(new FileWriter(path, false))) {
            clearWriter.write("");
        }
    }
    public static void appendContentToFile(String path, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().equals(fileName)) {
                        return file;
                    }
                }
            }
        }
        return null;
    }
}
