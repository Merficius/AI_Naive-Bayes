import java.util.HashMap;

public class Bayes {
	double positiveDocuments, negativeDocuments;
	int totalWords, nWords;
	
	
	public Bayes(int positive, int negative) {
		positiveDocuments = (double) positive / (positive + negative);
		negativeDocuments = (double) negative / (positive + negative);
	}
	
	public double calculateWordProbability(String word, HashMap map) {
		double probability;
		nWords = 0;
		for (Object key : map.keySet()) {
			nWords += (int) map.get(key);
		}
		totalWords = map.size();
		probability = (double) ((int) map.get(word) + 1) / (nWords + totalWords);
		return probability;
		
	}
	
	public double classify(String words, HashMap map, double document) {
		double   probability = 1;
		String[] temp        = words.split(" ");
		for (int i = 0; i < temp.length; i++) {
			probability *= (double) map.get(temp[i]);
		}
		return probability * document;
	}
	
	
}// end Bayes - class
