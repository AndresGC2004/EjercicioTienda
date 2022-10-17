/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.institute;
import java.util.Scanner;

/**
 *
 * @author Andres Gomez
 */
public class Institute {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        DoublyLinkedList <PregradeStudent> listapre = new DoublyLinkedList <>();;
        DoublyLinkedList <PosgraduateStudent> listapos = new DoublyLinkedList <>();;
        
        int opcion;
        int cred;
        int tipo;
        double cal,fis,est;
        String nom,ced,sexo;
        
        do{
        System.out.println("Ingrese a que grupo pertenece el estudiante"
                + "\n1. Pregrado"
                + "\n2. Posgrado"
                + "\n3. Mostrar estudiantes matriculados"
                + "\n4. Salir");
        opcion=in.nextInt();in.nextLine();
        switch(opcion){
            case 1:
                double x=0;
                
                System.out.println("Ingrese el nombre del estudiante");
                nom=in.nextLine();
                System.out.println("Ingrese la cedula");
                ced=in.nextLine();
                System.out.println("Ingrese el genero F/M");
                sexo=in.nextLine().toUpperCase();
                PregradeStudent a = new PregradeStudent(nom,ced,sexo);
                System.out.println("Ingrese la calificacion de las materias Calculo, Fisica y Estadistica");
                System.out.println("Calculo: ");cal=in.nextDouble();in.nextLine();
                System.out.println("Fisica: ");fis=in.nextDouble();in.nextLine();
                System.out.println("Estadistica: ");est=in.nextDouble();in.nextLine();
                a.setCalculo(cal);a.setFisica(fis);a.setEstadistica(est);
                x=a.calcularProm(cal, fis, est);
                
                if(x>=4.5){
                    a.setCred(28);
                    System.out.println("Estudiante "+a.getNom()+
                            "\n25% de descuento en la Matricula"
                                    + "\nCedula: "+a.getCedula()
                                    + "\nGenero: "+ a.getSexo()
                                    + "\nCreditos que registra: "+ a.getCred()
                                    + "\nCosto Matricula: "+ (a.calcularMat(28)-(a.calcularMat(28)*0.25)));
                    listapre.addLast(a);
                }else if(x>=4 && x<4.5){
                    a.setCred(25);
                    System.out.println("Estudiante "+a.getNom()+
                            "\n10% de descuento en la Matricula"
                                    + "\nCedula: "+a.getCedula()
                                    + "\nGenero: "+ a.getSexo()
                                    + "\nCreditos que registra: "+ a.getCred()
                                    + "\nCosto Matricula: "+ (a.calcularMat(25)-(a.calcularMat(25)*0.10)));
                    listapre.addLast(a);
                }else if(x>=3.5 && x<4){
                    a.setCred(20);
                    System.out.println("Estudiante "+a.getNom()+
                            "\nSin descuento en la Matricula"
                                    + "\nCedula: "+a.getCedula()
                                    + "\nGenero: "+ a.getSexo()
                                    + "\nCreditos que registra: "+ a.getCred()
                                    + "\nCosto Matricula: "+ a.calcularMat(20));
                    listapre.addLast(a);
                }else if(x>=2.5 && x<3.5){
                    a.setCred(15);
                    System.out.println("Estudiante "+a.getNom()+ 
                            "\nSin descuento en la Matricula"
                                    + "\nCedula: "+a.getCedula()
                                    + "\nGenero: "+ a.getSexo()
                                    + "\nCreditos que registra: "+ a.getCred()
                                    + "\nCosto Matricula: "+ a.calcularMat(15));
                    listapre.addLast(a);
                }else if(x<2.5){
                    System.out.println("Lo sentimos pero el estudiante "+ a.getNom() +" no se le permite la matricula");
                }
                
                
            break;
            case 2:
                double y=0;
                
                System.out.println("Ingrese el nombre del estudiante");
                nom=in.nextLine();
                System.out.println("Ingrese la cedula");
                ced=in.nextLine();
                System.out.println("Ingrese el genero F/M");
                sexo=in.nextLine().toUpperCase();
                PosgraduateStudent b = new PosgraduateStudent(nom,ced,sexo);
                System.out.println("Ingrese la calificacion de las materias Calculo, Fisica y Estadistica");
                System.out.println("Calculo: ");cal=in.nextDouble();in.nextLine();
                System.out.println("Fisica: ");fis=in.nextDouble();in.nextLine();
                System.out.println("Estadistica: ");est=in.nextDouble();in.nextLine();
                b.setCalculo(cal);b.setFisica(fis);b.setEstadistica(est);
                y=b.calcularProm(cal, fis, est);
                
                if(y>=4.5){
                    b.setCred(20);
                    System.out.println("Estudiante "+b.getNom()+
                            "\n20% de descuento en la Matricula"
                                    + "\nCedula: "+b.getCedula()
                                    + "\nGenero: "+ b.getSexo()
                                    + "\nCreditos que registra: "+ b.getCred()
                                    + "\nCosto Matricula: "+ (b.calcularMat(20)-(b.calcularMat(20)*0.20)));
                    listapos.addLast(b);
                }else{
                    b.setCred(10);
                    System.out.println("Estudiante "+b.getNom()+
                            "\nSin descuento en la Matricula"
                                    + "\nCedula: "+b.getCedula()
                                    + "\nGenero: "+ b.getSexo()
                                    + "\nCreditos que registra: "+ b.getCred()
                                    + "\nCosto Matricula: "+ b.calcularMat(10));
                    listapos.addLast(b);
                }
            break;
            
            case 3:
                System.out.println("Ingrese de que grupo desea ver "
                        + "\n1.Pregrado"
                        + "\n2.Posgrado");
                opcion=in.nextInt();in.nextLine();
                switch(opcion){
                    case 1:
                        for(PregradeStudent s:listapre){
                            System.out.println(s.toString());
                        }
                    break;
                    case 2:
                        for(PosgraduateStudent s:listapos){
                            System.out.println(s.toString());
                        }
                    break;
                    
                }
            break;
            case 4:
                System.exit(0);
            break;
        }
        }while(true);
    }
}
