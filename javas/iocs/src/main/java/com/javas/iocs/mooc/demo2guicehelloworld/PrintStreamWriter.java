package com.javas.iocs.mooc.demo2guicehelloworld;

import javax.inject.Inject;
import java.io.PrintStream;

public class PrintStreamWriter implements MyWriter {

    private PrintStream printStream;

    @Inject
    public PrintStreamWriter(PrintStream printStream) {
        super();
        this.printStream = printStream;
    }

    @Override
    public void write(String str) {
        printStream.println(str);
    }
}
