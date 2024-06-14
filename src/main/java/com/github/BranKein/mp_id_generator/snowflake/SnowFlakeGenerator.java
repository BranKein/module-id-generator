package com.github.BranKein.mp_id_generator.snowflake;

import com.github.BranKein.mp_id_generator.IDGeneratorAbstract;

public class SnowFlakeGenerator extends IDGeneratorAbstract<Long> {
    private final Long machineId;
    private Long sequence = 0L;
    private Long lastStamp = -1L;

    public static SnowFlakeGenerator getGenerator(Long machineId) {
        if (machineId > SnowFlakeConstant.MAX_MACHINE_ID_BIT || machineId < 0) {
            throw new IllegalArgumentException(String.format("machineId can't be greater than %s or less than 0", SnowFlakeConstant.MAX_MACHINE_ID_BIT));
        }
        return SnowFlakeGeneratorCache.getInstance().getGenerator(machineId);
    }

    protected SnowFlakeGenerator(Long serverId) {
        this.machineId = serverId;
    }

    @Override
    protected Long getNewId(Object... args) {
        return ((this.getCurrStamp() - SnowFlakeConstant.START_STAMP) << SnowFlakeConstant.TIMESTAMP_LEFT)
                | this.machineId << SnowFlakeConstant.MACHINE_ID_LEFT
                | this.sequence;
    }

    public Long machineId() {
        return this.machineId;
    }

    synchronized private Long getCurrStamp() {
        long currTimestamp = System.currentTimeMillis();
        if (currTimestamp < this.lastStamp) {
            throw new RuntimeException();
        }
        if (currTimestamp == this.lastStamp) {
            this.sequence = (this.sequence + 1) & SnowFlakeConstant.MAX_SEQUENCE_BIT;
            if (this.sequence == 0) {
                currTimestamp = this.getNextMill();
            }
        } else {
            this.sequence = 0L;
        }
        this.lastStamp = currTimestamp;
        return currTimestamp;
    }

    private Long getNextMill() {
        long currentTimestamp = System.currentTimeMillis();
        while (currentTimestamp <= lastStamp) {
            currentTimestamp = System.currentTimeMillis();
        }
        return currentTimestamp;
    }


}
