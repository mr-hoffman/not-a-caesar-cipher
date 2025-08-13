public class Cipher {
	private String[][] letterblock;
	private int numRows;
	private int numCols;

	// Constructor: parameters include number of rows, number of columns
	public Cipher(int _rows, int _cols) {
		this.letterblock = new String[_rows][_cols];
		this.numRows = _rows;
		this.numCols = _cols;
	}

	// method fillBlock(): places a String into a letterBlock in row major order
	// @param str: the String to be processed
	// POSTCONDITION: if str.length() < numRows*numCols, "A" is placed in each unfilled cell
	// POSTCONDITION: if str.length() > numRows * numCols, trailing characters are ignored
	private void fillBlock(String str) {
		// int totalLen = this.numRows * this.numCols;
		int pos = 0;
		
		for (int r = 0; r < this.numRows; r++) {
			for (int c = 0; c < this.numCols; c++) {
				if (pos < str.length()) {
					String substr = str.substring(pos, pos+1);
					this.letterblock[r][c] = substr;
					pos++;
				} else {
					this.letterblock[r][c] = "A";
				}
			}
		}
	}

	// method encryptBlock(): extracts encrypted message (cipher) from letterBlock in column major order
	// PRECONDITION: letterBlock has been filled
	// @return encrypted String from letterBlock
	private String encryptBlock() {
		String encryptedMsg = "";

		for (int c = 0; c < this.letterblock[0].length; c++) {
			for (int r = 0; r < this.letterblock.length; r++) {
				encryptedMsg += this.letterblock[r][c];
			}
		}
	
		return encryptedMsg;
	}

	// method encryptMessage(): encrypts a message
	// @param message: the String to be encrypted
	// @return the encrypted message
	// if message is an empty String, returns an empty String
	public String encryptMessage(String message) {
		String finalEncryptedMsg = "";
		int blockLen = this.numCols * this.numRows;
		while (message.length() > 0) {
			if (blockLen > message.length()) {
				blockLen = message.length();
			}

			fillBlock(message);
			finalEncryptedMsg += encryptBlock();
			message = message.substring(blockLen);
		}

		
		return finalEncryptedMsg;
	}
} 
