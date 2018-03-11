
package com.working.util;

import java.util.UUID;

public class UUIDUtil {
    
    // 自动生成主键
    public static synchronized String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
}
