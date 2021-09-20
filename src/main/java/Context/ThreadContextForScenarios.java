package Context;

import java.util.HashMap;
import java.util.Map;

public class ThreadContextForScenarios {

    private static final ThreadLocal<Map<String, Object>> CONTEXT = new ThreadLocal<>();
    private static Map<String, Object> map = new HashMap<>();
    private static ThreadContextForScenarios threadContextForScenarios = null;

    public static Object getScenarioContext(String key) {
        return CONTEXT.get().get(key);
    }

    public static void setScenarioContext(String key, Object value) {
        map.put(key, value);
        CONTEXT.set(map);
    }

    public static ThreadContextForScenarios getInstance() {
        if (threadContextForScenarios == null) {
            synchronized (ThreadContextForScenarios.class) {
                if (threadContextForScenarios == null) {
                    threadContextForScenarios = new ThreadContextForScenarios();
                }
            }
        }
        return threadContextForScenarios;
    }
}
