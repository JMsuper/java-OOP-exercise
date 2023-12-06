package org.pocu;

public class ComplexNumber {
    public double real;
    public double imaginary;
    static public int DOUBLE_DIGIT = 100000;

    public ComplexNumber(){
        this(0.0,0.0);
    }

    public ComplexNumber(double num){
        this(num,0L);
    }

    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }


    public ComplexNumber roundWithin(){
        double real =  Math.round(this.real * DOUBLE_DIGIT) / (double)DOUBLE_DIGIT;
        double imaginary = Math.round(this.imaginary * DOUBLE_DIGIT) / (double)DOUBLE_DIGIT;
        return new ComplexNumber(real,imaginary);
    }

    @Override
    public boolean equals(Object object){
        ComplexNumber c = (ComplexNumber) object;
        c = c.roundWithin();
        ComplexNumber thisC = this.roundWithin();
        return thisC.real == c.real && thisC.imaginary == c.imaginary;
    }

    @Override
    public String toString(){
        return real + " " + imaginary;
    }

    public boolean isReal(){
        return imaginary == 0L;
    }

    public boolean isImaginary(){
        return real == 0L && imaginary != 0L;
    }

    public ComplexNumber getConjugate(){
        return new ComplexNumber(this.real,-this.imaginary);
    }



    public ComplexNumber add(ComplexNumber c){
        return new ComplexNumber(this.real + c.real , this.imaginary + c.imaginary)
                .roundWithin();
    }

    public ComplexNumber subtract(ComplexNumber c){
        return new ComplexNumber(this.real - c.real , this.imaginary - c.imaginary)
                .roundWithin();
    }

    // (a + bi)(c + di) = ac + cbi + adi + (-)bd = (ac - bd) + (ad + cb)i
    public ComplexNumber multiply(ComplexNumber c){
        double real = this.real * c.real - this.imaginary * c.imaginary;
        double imaginary = this.real * c.imaginary + this.imaginary * c.real;
        return new ComplexNumber(real,imaginary).roundWithin();
    }

    // (c + di) / (a + bi) = (ac + bd)/(a^2 + b^2) + (ad - bc)/(a^2 + b^2)i
    public ComplexNumber divide(ComplexNumber newComplex){
        double real = (newComplex.real * this.real + newComplex.imaginary * this.imaginary)/
                (Math.pow(newComplex.real,2) + Math.pow(newComplex.imaginary,2));
        double imaginary = (newComplex.real * this.imaginary - newComplex.imaginary * this.real)/
                (Math.pow(newComplex.real,2) + Math.pow(newComplex.imaginary,2));
        return new ComplexNumber(real,imaginary).roundWithin();
    }
}
