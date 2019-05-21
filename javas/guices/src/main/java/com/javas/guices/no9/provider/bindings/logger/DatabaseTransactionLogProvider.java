package com.javas.guices.no9.provider.bindings.logger;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public class DatabaseTransactionLogProvider implements Provider<TransactionLog> {

    private String jdbcUrl;

    @Inject
    public DatabaseTransactionLogProvider(@Named("name jdbcUrl") String jdbcUrl){
        this.jdbcUrl = jdbcUrl;
    }
    @Override
    public TransactionLog get() {
        return new DatabaseTransactionLog(jdbcUrl);
    }
}
