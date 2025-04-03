package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Main extends JFrame {

    private double saldo = 2350000;
    private String contraseña = "1234";

    private JLabel lblSaldo;

    public Main(){
        setTitle("Cajero Automatico");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,1 ,10,10));

        JButton btnColsultar = new JButton("Consultar saldo");
        btnColsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Su saldo en este momento es : $ "+saldo);
            }
        });

        JButton btnRetiro = new JButton("Retirar");
        btnRetiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valorRetiro = JOptionPane.showInputDialog("Ingrese el monto a retirar");
                try {
                    double monto = Double.parseDouble(valorRetiro);
                    if (monto <= 0){
                        JOptionPane.showMessageDialog(null,"El monto no debe ser inferior a 0");
                    } else if (monto > saldo) {
                        JOptionPane.showMessageDialog(null,"El monto exede el saldo disponible");
                    }else {
                        saldo -= monto;
                        JOptionPane.showMessageDialog(null,"Retiro Exitoso");
                    }
                }catch (NumberFormatException ex){
                    System.out.println(ex);
                }
            }
        });

        JButton btnCambioClave = new JButton("Cambiar Contraseña");
        btnCambioClave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actual = JOptionPane.showInputDialog("Ingrese su contraseña actual");
                if (actual != null && actual.equals(contraseña)){
                    String nueva = JOptionPane.showInputDialog("Ingrese su nueva contraseña");
                    if (nueva != null && !nueva.isEmpty()){
                        contraseña = nueva;
                        JOptionPane.showMessageDialog(null, "Cambio exitoso");
                    }else{
                        JOptionPane.showMessageDialog(null, "Nueva contraseña invalida");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                }
            }
        });

        JButton btnSalir = new JButton("Finalizar");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Gracias");
                System.exit(0);
            }
        });



        add(btnColsultar);
        add(btnRetiro);
        add(btnCambioClave);
        add(btnSalir);

    }




    public static int mcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void Ejercicio1(){
        Scanner scr = new Scanner(System.in);
        int num1, num2, mcd;

        System.out.println("Ingrese el primer numero: ");
        num1 = scr.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        num2 = scr.nextInt();

        if(num1 >= 0 && num2 >= 0){
            mcd = mcd(num1,num2);
            System.out.println("El MCD de los dos numero es " + mcd);
        }else {
            System.out.println("Los numeros no son positivos");
        }
    }
    public static void Ejercicio2(){
        Scanner scr = new Scanner(System.in);
        int pasos = 0;
        String num1,num2;

        System.out.println("Ingrese el primer numero: ");
        num1 = scr.next();
        System.out.println("Ingrese el segundo numero: ");
        num2 = scr.next();

        if (num1.length() == num2.length()){
            for (int i = 0; i < num1.length(); i++) {
                int Dig1 = Character.getNumericValue(num1.charAt(i));
                int Dig2 = Character.getNumericValue(num2.charAt(i));

                if (Dig1 < Dig2){
                    pasos += (Dig2-Dig1);
                }else{
                    System.out.println("El digito del numero 1 es menor al del 2 ");
                    return;
                }
            }
        }else {
            System.out.println("Los inmeros ingresados no tienen la misma cantidad de cifras");
        }

        System.out.println("El numero de pasos requeridos son "+pasos);


    }



    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int respuesta;

        System.out.println("Ingrese el numero del ejercicio a comprobar");
        System.out.println("Ejercicio1  =  1");
        System.out.println("Ejercicio2  =  2");
        System.out.println("Ejercicio3  =  3");
        respuesta = scr.nextInt();
        switch (respuesta){
            case 1:
                Ejercicio1();
                break;
            case 2:
                Ejercicio2();
                break;
            case 3:
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new Main().setVisible(true);
                    }
                });
                break;

        }
    }
}