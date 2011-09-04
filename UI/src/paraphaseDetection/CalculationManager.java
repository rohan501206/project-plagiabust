/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paraphaseDetection;

/**
 *
 * @author Udana Chathuranga
 */
public class CalculationManager {

    WordNetTest wordnet = new WordNetTest();

    /**
     * Calculate the inverse document frequency for a given word and two sentence
     * @param word
     * @param sentence
     * @param secondSentence
     * @return 
     */
    public double idf(String word, String sentence, String secondSentence) {
        double noOfDocs = 2.0;
        int occurrences = 0;
        boolean first = sentence.contains(word);
        boolean second = secondSentence.contains(word);

        if ((first == true) && (second == true)) {
            occurrences = 2;
        } else if ((first == false) && (second == false)) {
            occurrences = 0;
        } else {
            occurrences = 1;
        }

        double content = noOfDocs / (occurrences + 1) + 1;
        double idf = Math.log(content);
        double abidf = Math.abs(idf);
        return abidf;
    }

    /**
     * Calculate the Levenshtein edit distance for a two sentences
     * @param s
     * @param t
     * @return 
     */
    public int getLevenshteinDistance(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int n = s.length();
        int m = t.length();
        if (n == 0) {
            return m;
        } else if (m == 0) {
            return n;
        }

        if (n > m) {
            String tmp = s;
            s = t;
            t = tmp;
            n = m;
            m = t.length();
        }

        int p[] = new int[n + 1];
        int d[] = new int[n + 1];
        int _d[];
        int i;
        int j;
        char t_j;
        int cost;

        for (i = 0; i <= n; i++) {
            p[i] = i;
        }

        for (j = 1; j <= m; j++) {
            t_j = t.charAt(j - 1);
            d[0] = j;
            for (i = 1; i <= n; i++) {
                cost = s.charAt(i - 1) == t_j ? 0 : 1;
                d[i] = Math.min(Math.min(d[i - 1] + 1, p[i] + 1), p[i - 1] + cost);
            }
            _d = p;
            p = d;
            d = _d;
        }
        return p[n];
    }

    /**
     * Calculate maximum similarity  
     * @param word
     * @param sentence
     * @return 
     */
    public double maxSimilarity(String word, String sentence) {
        double similarity = 0.0;
        String[] arrayOfWords = sentence.split(" ");

        for (int i = 0; i < arrayOfWords.length; i++) {
            int distance = this.getLevenshteinDistance(word, arrayOfWords[i]);
            double similarityScore;
            if (distance == 0) {
                similarityScore = 1;
            } else {
                similarityScore = 0;
            }
            similarity = similarity + similarityScore;
        }

        double synonymSimilarity = this.synonymSimilarity(word, sentence);
        double finalSimilarity = similarity + synonymSimilarity;
        return finalSimilarity;
    }

    /**
     * Calculate synonym similarity
     * @param word
     * @param sentence
     * @return 
     */
    public double synonymSimilarity(String word, String sentence) {
        double similarity = 0.0;
        String[] arrayOfWords = sentence.split(" ");
        String[] arrayOfSynonyms = wordnet.getSynonyms(word);

        for (int i = 0; i < arrayOfWords.length; i++) {
            for (int k = 0; k < arrayOfSynonyms.length; k++) {
                if (arrayOfSynonyms[k].equals(arrayOfWords[i])) {
                    similarity = similarity + 1;
                }
            }
        }

        return similarity;
    }

    /**
     * Calculate length similarity of two sentences
     * @param firstSentence
     * @param secondSentence
     * @return 
     */
    public double lenthSimilarity(String firstSentence, String secondSentence) {
        double firstSentenceSize = firstSentence.length();
        double secondSentenceSize = secondSentence.length();
        double score = 0;

        if ((firstSentenceSize - secondSentenceSize) == 0) {
            score = 0.5;
        } else {
            if (Math.abs(firstSentenceSize - secondSentenceSize) > 0 && Math.abs(firstSentenceSize - secondSentenceSize) <= 5) {
                score = -0.08;

            } else if (Math.abs(firstSentenceSize - secondSentenceSize) > 5 && Math.abs(firstSentenceSize - secondSentenceSize) <= 10) {
                score = -0.10;

            } else {
                score = -0.20;
            }
        }
        return score;
    }

    /**
     * Calculation of final similarity of two sentences
     * @param firstSentence
     * @param secondSentence
     * @return 
     */
    public double similarity(String firstSentence, String secondSentence) {
        double similarity = 0.0;
        String[] firstSentencearrayOfWords = firstSentence.split(" ");
        String[] secondSentencearrayOfWords = secondSentence.split(" ");
        double firstSum = 0.0;
        double firstidfSum = 0.0;
        double secondSum = 0.0;
        double secondidfSum = 0.0;
        
        for (int i = 0; i < firstSentencearrayOfWords.length; i++) {
            double value1 = (this.maxSimilarity(firstSentencearrayOfWords[i], secondSentence)) * (this.idf(firstSentencearrayOfWords[i], firstSentence, secondSentence));
            double value2 = this.idf(firstSentencearrayOfWords[i], firstSentence, secondSentence);
            firstSum = firstSum + value1;
            firstidfSum = firstidfSum + value2;

        }

        for (int i = 0; i < secondSentencearrayOfWords.length; i++) {
            double value3 = (this.maxSimilarity(secondSentencearrayOfWords[i], firstSentence)) * (this.idf(secondSentencearrayOfWords[i], firstSentence, secondSentence));
            double value4 = this.idf(secondSentencearrayOfWords[i], firstSentence, secondSentence);
            secondSum = secondSum + value3;
            secondidfSum = secondidfSum + value4;
        }

        similarity = 0.5 * ((firstSum / firstidfSum) + (secondSum / secondidfSum));
        //lenth similarity value add
        similarity = similarity + this.lenthSimilarity(firstSentence, secondSentence);
        
        return similarity;
    }
}
