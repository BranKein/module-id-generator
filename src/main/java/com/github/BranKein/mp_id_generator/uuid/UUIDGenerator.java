package com.github.BranKein.mp_id_generator.uuid;

import com.github.BranKein.mp_id_generator.IDGeneratorAbstract;

import java.util.UUID;

public class UUIDGenerator extends IDGeneratorAbstract<UUID> {

    @Override
    protected UUID getNewId(Object... args) {
        return UUID.randomUUID();
    }
}
