//Задача 5: стихотворении найти количество слов, начинающихся и заканчивающихся гласной буквой.
package Week1;

public class WordCounter {

    public static void main(String[] args) {
        String poem = "На небе звёзды, словно бриллианты,\n" +
                "Сверкают в тишине ночной.\n" +
                "Луна, как светлый, нежный бант,\n" +
                "Окутывает мир красой.\n\n" +
                "Ветер играет в листве,\n" +
                "Шурша, как шепот тихий сна.\n" +
                "И в этой нежной, темной гневе,\n" +
                "Скрыта душа, как тайна, одна.";

        int count = 0;

        // Разбиваем стихотворение на слова
        String[] words = poem.replaceAll("[\\p{Punct}\\s]+", " ").trim().split(" ");

        // Проходимся по каждому слову
        for (String word : words) {
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                count++;
            }
        }

        System.out.println("Количество слов, начинающихся и заканчивающихся гласной буквой: " + count);
    }

    // Проверка, является ли символ гласной буквой
    private static boolean isVowel(char ch) {
        return ch == 'а' || ch == 'у' || ch == 'о' || ch == 'ы' || ch == 'и' ||
                ch == 'э' || ch == 'я' || ch == 'ю' || ch == 'ё' ||
                ch == 'А' || ch == 'У' || ch == 'О' || ch == 'Ы' || ch == 'И' ||
                ch == 'Э' || ch == 'Я' || ch == 'Ю' || ch == 'Ё';
    }
}