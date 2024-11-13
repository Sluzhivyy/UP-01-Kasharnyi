package n3;

import java.io.*;

public class TextFile {

    private File file;

    public TextFile(String filePath) {
        file = new File(filePath);
    }

    public TextFile(File file) {
        this.file = file;
    }

    public boolean create() {
        try {
            return file.createNewFile();
        } catch (IOException e) {
            System.err.println("Ошибка создания файла: " + e.getMessage());
            return false;
        }
    }

    public boolean rename(String newName) {
        return file.renameTo(new File(file.getParent(), newName));
    }

    public void printContent() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public void append(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public boolean delete() {
        return file.delete();
    }

    public static void main(String[] args) {

        TextFile textFile = new TextFile("my_file.txt");


        if (textFile.create()) {
            System.out.println("Файл создан.");
        }


        textFile.append("Hello, world!");
        textFile.append("This is my text file.");

        System.out.println("Содержимое файла:");
        textFile.printContent();


        if (textFile.rename("renamed_file.txt")) {
            System.out.println("Файл переименован.");
        }


        if (textFile.delete()) {
            System.out.println("Файл удален.");
        }
    }
}
