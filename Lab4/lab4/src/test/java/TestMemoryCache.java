import org.example.MemoryCache;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestMemoryCache {

    // MethodName_StateUnderTest_ExpectedBehavior
    @Test
    void getInstance_newKeyAndNotFull_insertObject(){
        MemoryCache.setMaxInstanceCount(3);
        String newKey = "A";
        MemoryCache memoryCacheFromMap = MemoryCache.getInstance(newKey);

        List<String> memoryCacheLruList = (LinkedList<String>) MemoryCache.getCacheLRUList();
        String keyFromList = memoryCacheLruList.get(0);

        assertEquals(newKey,memoryCacheFromMap.getKey());
        assertEquals(newKey,keyFromList);
    }

    @Test
    void getInstance_newKeyAndFull_removeAndInsert(){
        MemoryCache.setMaxInstanceCount(3);
        MemoryCache.getInstance("A");
        MemoryCache.getInstance("B");
        MemoryCache.getInstance("A");
        MemoryCache.getInstance("C");

        MemoryCache.getInstance("D");
        assertEquals("D",MemoryCache.getCacheLRUList().get(0));
        assertTrue(MemoryCache.getInstanceMap().containsKey("A"));
        assertFalse(MemoryCache.getInstanceMap().containsKey("B"));
    }

    @Test
    void setMaxInstanceCount_limitOver_removeUntilLimit(){
        MemoryCache.getInstance("A");
        MemoryCache.getInstance("B");
        MemoryCache.getInstance("C");
        MemoryCache.getInstance("D");

        MemoryCache.setMaxInstanceCount(2);
        assertFalse(MemoryCache.getInstanceMap().containsKey("B"));
        assertEquals(2,MemoryCache.getCacheLRUList().size());
    }
}
