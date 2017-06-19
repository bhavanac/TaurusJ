package edu.ds.practice.FB;

public class Read4 {
  public int read(char[] buf, int n) {
    char[] buffer = new char[4];
    int readBytes = 0;
    boolean eof = false;
    /*while (!eof) {
      int count = read4(buffer);

      if (count < 4) {
        eof = true;
      }

      int length = Math.min(n-readBytes, count);
      for (int i = 0; i < length; i++) {
        buf[readBytes+i] = buffer[i];
      }
      readBytes += length;
    }*/

    return readBytes;
  }
}
