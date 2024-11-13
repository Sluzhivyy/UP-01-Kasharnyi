package n6;

import java.io.*;

public class TextFileWithExceptions {

    private File file;

    public TextFileWithExceptions(String filePath) {
        file = new File(filePath);
    }

    public TextFileWithExceptions(File file) {
        this.file = file;
    }

    public boolean create() throws IOException {
        try {
            return file.createNewFile();
        } catch (IOException e) {
            throw new FileCreationException("Ошибка создания файла: " + e.getMessage());
        }
    }

    public boolean rename(String newName) throws IOException {
        try {
            File newFile = new File(file.getParent(), newName);

            // Check if the source file exists
            if (!file.exists()) {
                throw new FileRenameException("Исходный файл не существует: " + file.getAbsolutePath(), null);
            }

            // Check if the new file already exists
            if (newFile.exists()) {
                throw new FileRenameException("Файл с новым именем уже существует: " + newFile.getAbsolutePath(), null);
            }

            // Attempt to rename
            if (!file.renameTo(newFile)) {
                throw new FileRenameException("Ошибка при переименовании файла: " + file.getAbsolutePath() + " в " + newFile.getAbsolutePath(), null);
            }

            return true;
        } catch (IOException e) {
            throw new FileRenameException("Ошибка переименования файла: " + e.getMessage(), e);
        }
    }

    public void printContent() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new FileReadException("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public void append(String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            throw new FileWriteException("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public boolean delete() throws IOException {
        try {
            // Check if the file exists before trying to delete it
            if (!file.exists()) {throw new FileDeletionException("Файл не существует: " + file.getAbsolutePath());
            }

            // Attempt to delete the file
            if (!file.delete()) {
                throw new FileDeletionException("Ошибка удаления файла: " + file.getAbsolutePath());
            }

            return true;
        } catch (IOException e) {
            throw new FileDeletionException("Ошибка удаления файла: " + e.getMessage(), e);
        }
    }


    static class FileCreationException extends IOException {
        public FileCreationException(String message) {
            super(message);
        }
    }

    static class FileRenameException extends IOException {
        public FileRenameException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    static class FileReadException extends IOException {
        public FileReadException(String message) {
            super(message);
        }
    }

    static class FileWriteException extends IOException {
        public FileWriteException(String message) {
            super(message);
        }
    }

    static class FileDeletionException extends IOException {

        public FileDeletionException(String message, Throwable cause) {
            super(message, cause);
        }

        public FileDeletionException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {

        TextFileWithExceptions textFile = new TextFileWithExceptions("my_file.txt");

        try {

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
        } catch (FileCreationException e) {
            System.err.println(e.getMessage());
        } catch (FileRenameException e) {
            System.err.println(e.getMessage());
        } catch (FileReadException e) {
            System.err.println(e.getMessage());
        } catch (FileWriteException e) {
            System.err.println(e.getMessage());
        } catch (FileDeletionException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Произошла ошибка ввода-вывода: " + e.getMessage());
        }
    }
}
