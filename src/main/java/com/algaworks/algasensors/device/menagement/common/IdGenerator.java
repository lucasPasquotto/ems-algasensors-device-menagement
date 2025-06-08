package com.algaworks.algasensors.device.menagement.common;

import io.hypersistence.tsid.TSID;

import java.util.Optional;

public class IdGenerator {

    private static final TSID.Factory tsidFactory;

    static {
        Optional.ofNullable(System.getenv("TSID_NODE"))
                .ifPresent(tsidNode -> System.setProperty("tsid.node", tsidNode));

        Optional.ofNullable(System.getenv("TSID_NOME_COUNT"))
                .ifPresent(tsidNodeCount -> System.setProperty("tsid.node.count", tsidNodeCount));

        tsidFactory = TSID.Factory.builder().build();
    }

    private IdGenerator() {
    }

    public static TSID generateTSID() {
        return tsidFactory.generate();
    }
}
