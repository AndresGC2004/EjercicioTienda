/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.institute;

/**
 *
 * @author Andres Gomez
 */
public class PosgraduateStudent {
    private String nom;
    private String cedula;
    private String sexo;
    private int cred;
    private double calculo;
    private double fisica;
    private double estadistica;

    public PosgraduateStudent(String nom, String cedula, String sexo) {
        this.nom = nom;
        this.cedula = cedula;
        this.sexo = sexo;
    }

    public void setCred(int cred) {
        this.cred = cred;
    }

    public void setCalculo(double calculo) {
        this.calculo = calculo;
    }

    public void setFisica(double fisica) {
        this.fisica = fisica;
    }

    public void setEstadistica(double estadistica) {
        this.estadistica = estadistica;
    }

    public String getCedula() {
        return cedula;
    }

    public String getSexo() {
        return sexo;
    }
    

    public String getNom() {
        return nom;
    }

    public int getCred() {
        return cred;
    }
    
    public double calcularProm(double cal,double fis,double estad){
        double x=0;
        return x=(cal+fis+estad)/3;   
    }
    public double calcularMat(int cred){
        double mat;
        return mat=cred*200000;
    }

    @Override
    public String toString() {
        return "PosgraduateStudent{" + "nom=" + nom + ", cedula=" + cedula + ", sexo=" + sexo + ", cred=" + cred + ", calculo=" + calculo + ", fisica=" + fisica + ", estadistica=" + estadistica + '}';
    }

   


    
}
