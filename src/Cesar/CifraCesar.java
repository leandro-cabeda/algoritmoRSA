package Cesar;

import java.util.Scanner;

public class CifraCesar {

  public static void main(String[] args) {
    String msgCript = "", msgDecript = "";
    
    System.out.println("Digite a mensagem para ser criptografada: ");
    Scanner sc = new Scanner(System.in);
    
    String msg = sc.nextLine().toLowerCase();
    char[] letras = msg.toCharArray();
    
    System.out.println("Digite o valor da chave: ");
    int chave = sc.nextInt();
    
    for (int i = 0; i < letras.length; i++) {
      int codeASCII = (int) letras[i] + chave;
      if (codeASCII > 122) {
        codeASCII -= 26;
      } else if (codeASCII < 97) {
        codeASCII += 26;
      }
      msgCript += (char) codeASCII;
    }
    System.out.println("Mensagem com Criptografia da Cifra de César: " + msgCript);
    
    char[] letras2 = msgCript.toCharArray();
    
    for (int i = 0; i < letras2.length; i++) {
      int codeASCII2 = (int) letras2[i] - chave;
      if (codeASCII2 > 122) {
        codeASCII2 -= 26;
      } else if (codeASCII2 < 97) {
        codeASCII2 += 26;
      }
      msgDecript += (char) codeASCII2;
    }
    System.out.println("Mensagem Descriptografada da Cifra de César: " + msgDecript);
  }
}
