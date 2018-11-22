package ru.itpark;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class creditService {
    public double creditCalc(double loanAmount, double interestRate, double loanPeriod) {
        int year = 12;
        double sizeMonthlyPayments; //Размер ежемесячного платежа = коэффициент аннуитета*сумма кредита
        double annuityRatio;
        //коэффициент аннуитета = i*(1+i)^n/((1+i)^n-1)
        // n = int loanPeriod - количество периодов

        double mPercent = interestRate / year / 100;// = i месячная процентная ставка по кредиту (= годовая ставка/год)
        double mPercentPlusOne = mPercent + 1; //(1+i)
        double mPercentPlusOneInDegree = Math.pow(mPercentPlusOne, loanPeriod); //(1+i)^n

        annuityRatio = mPercent * mPercentPlusOneInDegree / (mPercentPlusOneInDegree - 1);

        sizeMonthlyPayments = annuityRatio * loanAmount;

        //TODO: применил для обрезки "лишних" нулей в результате.
        sizeMonthlyPayments = sizeMonthlyPayments * 100;
        sizeMonthlyPayments = (int) sizeMonthlyPayments;
        sizeMonthlyPayments = sizeMonthlyPayments / 100;
        //TODO: Нашел альтернативу - NumberFormat nf = new DecimalFormat("#.##"); но в данном случае она не подошла.
        //TODO: как можно упростить эту конструкцию?

        if (sizeMonthlyPayments < 0) {
            sizeMonthlyPayments = 0;
        }

        return sizeMonthlyPayments;

    }
}
