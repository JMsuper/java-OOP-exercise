import javafx.util.Pair;
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

    @Test
    void addEntry_newEntry_insertMapAndList(){
        MemoryCache memoryCache = MemoryCache.getInstance("sample");
        memoryCache.addEntry("key","value");
        String valueFromMap = memoryCache.getEntryMap().get("key");
        String valueFromList = memoryCache.getLruList().getFirst();
        assertEquals("value",valueFromMap);
        assertEquals("key",valueFromList);
    }

    @Test
    void addEntry_duplicatedKey_updateMapAndList(){
        MemoryCache memoryCache = MemoryCache.getInstance("sample");
        memoryCache.addEntry("A","value");
        memoryCache.addEntry("B","value");
        memoryCache.addEntry("A","newValue");

        String valueFromMap = memoryCache.getEntryMap().get("A");
        String valueFromList = memoryCache.getLruList().getFirst();
        assertEquals("newValue",valueFromMap);
        assertEquals("A",valueFromList);
    }
}
