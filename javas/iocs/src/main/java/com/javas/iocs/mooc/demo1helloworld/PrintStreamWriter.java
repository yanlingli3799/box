package com.javas.iocs.mooc.demo1helloworld;

import java.io.PrintStream;

public class PrintStreamWriter implements MyWriter {

    private PrintStream printStream;

    public PrintStreamWriter(PrintStream printStream) {
        super();
        this.printStream = printStream;
    }

    @Override
    public void write(String str) {
        printStream.println(str);
    }
}
