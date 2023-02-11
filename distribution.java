import java.io.*;

class distribution {
  int total;
  int[][] charCounts;

  distribution(String file) {
    total = 0;
    charCounts = new int[26][2];

    for (int i = 0; i != 26; i++) {
      charCounts[i][0] = i;
    }

    try {
      FileInputStream in = new FileInputStream(file);
      int c;
      while ((c = in.read()) != -1) {
        char cur = Character.toLowerCase((char) c);
        if (cur >= 97 && cur <= 122)
          charCounts[cur - 97][1] += 1;
      }
      in.close();

      for (int i = 0; i != 26; i++) {
        total += charCounts[i][1];
      }
    } catch (Exception e) {
      System.out.println("File unavailable");
    }
  }

  public void sort() {
    int n = 26;
    int[] temp = {0,0};
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < (n - i); j++) {
        if (charCounts[j - 1][1] > charCounts[j][1]) {
          // swap elements
          temp = charCounts[j - 1];
          charCounts[j - 1] = charCounts[j];
          charCounts[j] = temp;
        }

      }
    }
  }

  @Override
  public String toString() {
    String out = "";
    for (int i = 0; i != 26; i++) {
      out += ((char)(charCounts[i][0] + 97) + ": " + ((double)charCounts[i][1]/(double)total) + "\n");
    }
    return out;
  }

  public void printGraph(){
    int[][] temp = charCounts;
    for (int i = 0; i != 26; i++) {
      temp[i] = charCounts[i];
      temp[i][1] = (int)(((double)charCounts[i][1]/(double)total)*100);
    }
    for (int i = 10; i >= 0; i--){
      String out = "";
      for (int j = 0; j != 26; j++) {
        if(temp[j][1] >= i){
          out += "* | ";
        }
        else out+="  | ";
      }
      System.out.println(out);
    }
    for (int i = 0; i != 26; i++){
      System.out.print((char)(temp[i][0]+97) + " | ");
    }
  }

  public int[][] getCharCounts() {
    return charCounts;
  }

  public int getTotal() {
    return total;
  }
}
