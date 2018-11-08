public class WordSearch{
    private char[][]data;

    /**Initialize the grid to the size specified 
     *and fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols){
    	data = new char[rows][cols];
    	clear();
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
    	for (int i = 0; i < data.length; i++){
    		for (int e = 0; e < data[i].length; e++){
    			data[i][e] = '_';
    		}
    	}
    }

    /**Each row is a new line, there is a space between each letter
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
    	String out = "";
    	for (int i = 0; i < data.length; i++){
    		for (int e = 0; e < data[i].length; e++){
    			out += data[i][e];
    			if (e != data[i].length - 1) {out += " ";}
    		}
    		out += "\n";
    	}
    	return out;
    }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned 
     * and the board is NOT modified.
     */
    public boolean addWordHorizontal(String word,int row, int col){
    	if (data[row].length - col < word.length()) return false;
    	char[][] old = copy();

    	for (int i = col, e = 0; e < word.length(); i++, e++){
    		if (data[row][i] == ('_')) {data[row][i] = word.charAt(e);}
    		if (data[row][i] != word.charAt(e)) { 
    			data = old;
    			return false;}
    	}
    	return true;
    }

    /* *@return a copy of the data[][] field 
    */
    private char[][] copy(){
    	char[][] old = new char[data.length][data[0].length];
    	for (int i = 0; i < data.length; i++){
    		for (int e = 0; e < data[i].length; e++){
    			old[i][e] = data[i][e];
    		}
    	}
    	return old;
    }

   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    public boolean addWordVertical(String word,int row, int col){
    	if (data.length - row < word.length()) return false;
    	char[][] old = copy();

    	for (int i = row, e = 0; e < word.length(); i++, e++){
    		if (data[i][col] == ('_')) {data[i][col] = word.charAt(e);}
    		if (data[i][col] != word.charAt(e)) { 
    			data = old;
    			return false;}
    	}
    	return true;
    }
}
