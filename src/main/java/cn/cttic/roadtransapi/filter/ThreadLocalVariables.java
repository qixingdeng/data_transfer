package cn.cttic.roadtransapi.filter;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalVariables {
	private static final ThreadLocal<Map<String, String>> maps = new ThreadLocal<>();
    public static final String VAR_NAME_CHARSET_NAME = "charsetEncoding";

    public static String get(String key) {
        synchronized (maps) {
            if (maps.get() == null) {
                maps.set(new HashMap<String, String>());
            }
            return maps.get().get(key);
        }
    }

    public static void set(String key, String value) {
        synchronized (maps) {
            if (maps.get() == null) {
                maps.set(new HashMap<String, String>());
            }
            maps.get().put(key, value);
        }
    }

    public static void remove() {
        synchronized (maps) {
            if (maps.get() != null) {
                maps.remove();
            }
        }
    }

    public static void remove(String key) {
        synchronized (maps) {
            if (maps.get() == null) {
                maps.set(new HashMap<String, String>());
            }
            maps.get().remove(key);
        }
    }
}
