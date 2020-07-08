package com.company;

public class Conta {
    private long numeroConta;
    private double saldo;

    public Conta(long numeroConta) {
        this.setNumeroConta(numeroConta);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        }
        this.saldo += valor;
        return true;
    }

    public boolean sacar(double valor) {
        if (valor > this.saldo) {
            return false;
        }
        this.saldo -= valor;
        return true;
    }

    public long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(long numeroConta) {
        this.numeroConta = numeroConta;
    }
}
