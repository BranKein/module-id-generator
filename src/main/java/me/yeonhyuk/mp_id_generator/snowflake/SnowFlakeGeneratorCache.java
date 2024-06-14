package me.yeonhyuk.mp_id_generator.snowflake;

import java.util.HashMap;

class SnowFlakeGeneratorCache {
    private final HashMap<Long, SnowFlakeGenerator> cache = new HashMap<>();
    private static SnowFlakeGeneratorCache instance;

    // for Singleton instance, reject to create new instance
    private SnowFlakeGeneratorCache() {}

    public static SnowFlakeGeneratorCache getInstance() {
        if (instance == null) {
            instance = new SnowFlakeGeneratorCache();
        }
        return instance;
    }

    public SnowFlakeGenerator getGenerator(Long serverId) {
        if (true == cache.containsKey(serverId)) {
            return cache.get(serverId);
        } else {
            SnowFlakeGenerator g = new SnowFlakeGenerator(serverId);
            cache.put(serverId, g);
            return g;
        }
    }
}
