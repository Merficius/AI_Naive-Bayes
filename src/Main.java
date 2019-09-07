import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		Bayes     bayes                  = new Bayes(3, 2);
		Utilities util                   = new Utilities();
		HashMap   generalMap             = new HashMap();
		HashMap   positiveMap            = new HashMap();
		HashMap   negativeMap            = new HashMap();
		HashMap   positiveProbabilityMap = new HashMap();
		HashMap   negativeProbabilityMap = new HashMap();
		double    positiveFinal, negativeFinal;
		
		util.createMap(util.words("C:\\Users\\chema\\Desktop\\Pruebabayes.txt"), generalMap, negativeMap);
		util.createMap(util.words("C:\\Users\\chema\\Desktop\\Pruebabayes2.txt"), generalMap, negativeMap);
		util.createMap(util.words("C:\\Users\\chema\\Desktop\\Pruebabayes3.txt"), generalMap, positiveMap);
		util.createMap(util.words("C:\\Users\\chema\\Desktop\\Pruebabayes4.txt"), generalMap, positiveMap);
		util.createMap(util.words("C:\\Users\\chema\\Desktop\\Pruebabayes5.txt"), generalMap, positiveMap);
		
		for (Object key : generalMap.keySet()) {
			if (positiveMap.get(key) == null)
				positiveMap.put(key, 0);
			if (negativeMap.get(key) == null)
				negativeMap.put(key, 0);
		}
		for (Object key : generalMap.keySet()) {
			positiveProbabilityMap.put(key, bayes.calculateWordProbability((String) key, positiveMap));
			negativeProbabilityMap.put(key, bayes.calculateWordProbability((String) key, negativeMap));
		}
		System.out.println(Arrays.asList(positiveMap));
		System.out.println(Arrays.asList(generalMap));
		System.out.println(Arrays.asList(negativeMap));
		System.out.println(Arrays.asList(positiveProbabilityMap));
		System.out.println(Arrays.asList(negativeProbabilityMap));
		
		positiveFinal = bayes.classify(util.words("C:\\Users\\chema\\Desktop\\Pruebabayes6.txt"), positiveProbabilityMap, bayes.positiveDocuments);
		negativeFinal = bayes.classify(util.words("C:\\Users\\chema\\Desktop\\Pruebabayes6.txt"), negativeProbabilityMap, bayes.negativeDocuments);
		
		if (positiveFinal > negativeFinal)
			System.out.println("Positive outcome: " + positiveFinal);
		else
			System.out.println("Negative outcome: " + negativeFinal);
		
	}// end main
	
	
}// end Main - class
