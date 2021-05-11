import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class for use in AQA exams for students using Java.
 *
 *
 * There are 2 constructors
 * 1. no parameters - creates an instance of AQAReadTextFile
 * 2. one parameter - filename, this will open the file for reading
 *
 * There is one openFile method, which matches 2 above.
 *
 * There is one readLine method, which reads a line of text from an open file.
 *
 * There is one read method, which reads one character from an open file.
 *
 * There is a closeFile method.
 *
 */
public class AQAReadTextFile {

  //The global variable link to the open file
  private BufferedReader textFileReader;

  /**
   * A constructor for AQAReadTextFile, but no file is opened
   * until openTextFile is called with a valid filename/path
   */
  public AQAReadTextFile() {
  } // end constructor AQAReadTextFile

  /**
   * A constructor that opens a text file for reading.
   * @param filename the filename/path of a text file to be opened.
   */
  public AQAReadTextFile(String filename) {
    openTextFile(filename);
  } // end constructor AQAReadTextFile

  /**
   * A method to open a text file.
   * @param filename the filename/path of a text file to be opened
   */
  public void openTextFile(String filename) {
    try {

      textFileReader = new BufferedReader(new FileReader(filename));

    } catch (IOException e) {
      e.printStackTrace();
      closeFile();
    } // end try/catch
  } // end openTextFile

  /**
   * returns the next character in the file.
   * returns '\u0000' only for the EOF or there is an error in reading.
   */
  public char readChar() {
    char c = '\u0000';
    try {

      c = (char) textFileReader.read();

    } catch (IOException e) {
      e.printStackTrace();
      closeFile();
    } // end catch
    return c;
  }  // end readChar

  /**
   * returns the content of a line MINUS the newline.
   * returns null only for the EOF.
   * returns an empty String if two newlines appear in a row.
   * Moves to the next line after reading this line.
   * @return line the current line in the file.
   *              this will not include any line termination characters.
   *              null is returned if the EOF marker has been reached or
   *              there is an error in reading.
   */
  public String readLine() {
    String line = null;
    try {

      line = textFileReader.readLine();

    } catch (IOException e) {
      e.printStackTrace();
      closeFile();
    } // end catch
    return line;
  } // end readNextLine

  /**
   * Closes the file
   */
  public void closeFile() {
    try {

      textFileReader.close();

    } catch (IOException ioe) {
      ioe.printStackTrace();
    } // end catch close exception
  } // end closeFile

} // end AQAReadTextFile