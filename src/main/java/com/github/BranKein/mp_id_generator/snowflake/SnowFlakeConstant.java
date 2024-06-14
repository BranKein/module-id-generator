package com.github.BranKein.mp_id_generator.snowflake;

class SnowFlakeConstant {
    public final static long START_STAMP = 1707828242000L;

    public final static long SIGN_BIT = 1;
    public final static long MACHINE_ID_BIT = 10;
    public final static long SEQUENCE_BIT = 10;

    public final static long MAX_MACHINE_ID_BIT = ~(-1 << MACHINE_ID_BIT);
    public final static long MAX_SEQUENCE_BIT = ~(-1 << SEQUENCE_BIT);

    public final static long MACHINE_ID_LEFT = SEQUENCE_BIT;
    public final static long TIMESTAMP_LEFT = MACHINE_ID_LEFT + MACHINE_ID_BIT;
}
