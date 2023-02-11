import java.util.Scanner;

class main{

  public static void menu(){
    System.out.println("1. Enter target file (read only)");
    System.out.println("2. Run analysis");
    System.out.print("> ");
  }
  public static void main(String[] args){

    String lorem = "/mnt/eva/education/2023/spring-CS3626s01-Cryptography/hw02/lorem.txt";
    Scanner in = new Scanner(System.in);
    String file = "";
    distribution analyzer;
    while(true){
      menu();
      int selection = in.nextInt();
      in.nextLine();
      switch(selection){
        case 1:
          System.out.print("Path: ");
          file = in.nextLine();
          if(file.equals("1")) file = lorem;
          break;
        case 2:
          analyzer = new distribution(file);
          analyzer.sort();
          System.out.println(analyzer);
          analyzer.printGraph();
          break;
      }
    }
  }
}
