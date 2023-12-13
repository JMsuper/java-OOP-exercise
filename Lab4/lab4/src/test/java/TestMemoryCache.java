import org.example.MemoryCache;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TestMemoryCache {

    // MethodName_StateUnderTest_ExpectedBehavior
    @Test
    void getInstance_newKeyAndNotFull_insertObject(){
        String newKey = "A";
        MemoryCache memoryCacheFromMap = MemoryCache.getInstance(newKey);

        LinkedList<String> memoryCacheLruList = MemoryCache.getMemoryCacheLruList();
        String keyFromList = memoryCacheLruList.getFirst();

        assertEquals(newKey,memoryCacheFromMap.getKey());
        assertEquals(newKey,keyFromList);
    }

    @Test
    void getInstance_newKeyAndFull_removeAndInsert(){
        MemoryCache.getInstance("A");
        MemoryCache.getInstance("B");
        MemoryCache.getInstance("A");
        MemoryCache.getInstance("C");

        MemoryCache.getInstance("D");
        assertEquals("D",MemoryCache.getMemoryCacheLruList().getFirst());
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
        assertEquals(2,MemoryCache.getMemoryCacheLruList().size());
    }
}
