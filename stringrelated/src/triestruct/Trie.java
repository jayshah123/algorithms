package triestruct;
/**
 * TC trie tutorial
 * @author jayshah
 *
 */
public class Trie {
	
	int words;
	int prefixes;
	Trie edges[];
	
	/**
	 * 
	 */
	void initialize(Trie vertex){
		vertex.words =0;
		vertex.prefixes = 0;
		vertex.edges = new Trie[26];
		for(int i=0;i<26;i++){
			vertex.edges[i]=null;
		}
	}
	
	
	/**
	 * add a single word to dictionary
	 */
	void addWord(Trie vertex,String word){
		if(word.isEmpty()){
			vertex.words = vertex.words + 1;
		}
		vertex.prefixes = vertex.prefixes + 1;
		
	}
	
	/**
	 * count number of words in dictionary that have prefix
	 * as the given argument prefix
	 * @return
	 */
	int countPrefixes(Trie vertex,String prefixes){
		return words;
		
	}
	
	/**
	 * count number of words in dictionary that exactly 
	 * match the word given in argument
	 * @return
	 */
	int countWords(Trie vertex,String word){
		return prefixes;
		
	}

}
