class Solution {
    public String reverseWords(String s) {
        String[] wordsArray = s.trim().split("\\s+");
        List<String> wordsList = Arrays.asList(wordsArray);
        Collections.reverse(wordsList);
        return String.join(" ", wordsList);
    }
}