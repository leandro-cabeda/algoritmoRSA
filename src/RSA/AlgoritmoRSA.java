/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA;

import java.math.BigInteger;

import java.util.Scanner;

/**
 Autor : Leandro Cabeda Rigo / Matheus Xavier
 */
public class AlgoritmoRSA {

    public static void main(String[] args) {

        System.out.println("Digite a mensagem para ser criptografada: ");
        Scanner sc = new Scanner(System.in);

        BigInteger p = new BigInteger("17");
        BigInteger q = new BigInteger("11");
        BigInteger n;
        BigInteger z;
        BigInteger d = new BigInteger("7");
        BigInteger e = new BigInteger("0");

        n = p.multiply(q); // n=p*q;
        z = (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE))); // z = (p - 1) * (q - 1);

        for (int i = 1; i <= 100; i++) {
            e = BigInteger.valueOf(i).multiply(d);

            if (e.intValue() % z.intValue() == 1) {
                e = BigInteger.valueOf(i);
                break;
            }
        }

        String msg = sc.nextLine().toLowerCase();
        char[] letras = msg.toCharArray();

        BigInteger c[] = new BigInteger[letras.length];
        String m = "";

        for (int i = 0; i < letras.length; i++) {

            c[i] = BigInteger.valueOf(letras[i]).modPow(e, n);
            int codigo = (int) c[i].intValue();
            m += (char) codigo;
        }
        System.out.println("\n\n");

        System.out.println("Mensagem criptografada  " + m + "\n");

        String m2 = "";
        char[] letras2 = m.toCharArray();
        BigInteger c2[] = new BigInteger[letras2.length];

        for (int i = 0; i < letras2.length; i++) {
            c2[i] = BigInteger.valueOf(letras2[i]).modPow(d, n);
            int codigo = (int) c2[i].intValue();

            m2 += (char) codigo;

        }
        System.out.println("\n");

        System.out.println("Mensagem descriptografada  " + m2 + "\n\n");

        String m3 = "";
        char[] letras3 = m2.toCharArray();
        BigInteger c3[] = new BigInteger[letras3.length];

        for (int i = 0; i < letras.length; i++) {

            c3[i] = BigInteger.valueOf(letras3[i]).modPow(d, n);
            int codigo = (int) c3[i].intValue();
            m3 += (char) codigo;
        }
        System.out.println("\n\n");

        System.out.println("Mensagem Assinatura Digital criptografada  " + m3 + "\n");

        String m4 = "";
        char[] letras4 = m3.toCharArray();
        BigInteger c4[] = new BigInteger[letras4.length];

        for (int i = 0; i < letras4.length; i++) {
            c4[i] = BigInteger.valueOf(letras4[i]).modPow(e, n);
            int codigo = (int) c4[i].intValue();

            m4 += (char) codigo;
        }
        System.out.println("\n");

        System.out.println("Mensagem Assinatura Digital descriptografada  " + m4 + "\n\n");

    }

}
