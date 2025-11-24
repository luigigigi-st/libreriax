package com.mycompany.libreriax.console;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


class AppendableObjectOutputStream extends ObjectOutputStream {

    
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out); 
    }

   
    //mmetodo chiamato solutamente da objoutputstream
    @Override
    protected void writeStreamHeader() throws IOException {
        // non fa nulla, evita di riscrivere l'intestazione
    }
}
