import java.util.*;
import java.io.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        boolean[] isHide = new boolean[message.length() + 1];
        Set<String> importWords = new HashSet<>();
        Set<String> noImportWords = new HashSet<>();
        List<Word> words = new ArrayList<>();

        int index = 0;
        while (index < message.length()) {
            if (message.charAt(index) == ' ') {
                index++;
                continue;
            }
            int start = index;
            while (index < message.length() && message.charAt(index) != ' ') {
                index++;
            }
            words.add(new Word(start, index - 1, message.substring(start, index)));
        }

        for (int i = 0; i < spoiler_ranges.length; i++) {
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];

            for (int j = start; j <= end; j++) {
                isHide[j] = true;
            }
        }

        for (Word word : words) {
            int left = word.left;
            int right = word.right;
            boolean isHideWord = false;

            for (int i = left; i <= right; i++) {
                if (isHide[i]) {
                    isHideWord = true;
                    break;
                }
            }

            if (!isHideWord) {
                noImportWords.add(word.word);
            }
        }

        for (Word word : words) {
            boolean isHideWord = false;

            for (int i = word.left; i <= word.right; i++) {
                if (isHide[i]) {
                    isHideWord = true;
                    break;
                }
            }

            if (!isHideWord) continue;
            if (noImportWords.contains(word.word)) continue;
            if (importWords.contains(word.word)) continue;

            importWords.add(word.word);
        }

        return importWords.size();
    }
    
    public class Word {
        int left;
        int right;
        String word;

        public Word(int left, int right, String word) {
            this.left = left;
            this.right = right;
            this.word = word;
        }
    }
}