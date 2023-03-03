package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;


public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void findSelfTitled_shouldReturnCorrectResult() {
        Collection<MusicItem> items = catalog.findSelfTitled();
        // size should be 2, and ids are 6 and 7

        assertEquals(2, items.size());

        // need to extract (get) the first one and make sure its id is 6. then the second one
        List<MusicItem> itemsList = new ArrayList<>(items);
        itemsList.sort(null); // sorts by natural order
        // now you can say itemsList.get(0) and check its id and same for 7
        assertEquals(6L, itemsList.get(0).getId().longValue());
        assertEquals(7L, itemsList.get(1).getId().longValue());
    }


    @Test(expected = UnsupportedOperationException.class)
    public void getAll_shouldReturnReadOnlyCollection() {
        Collection<MusicItem> items = catalog.getAll();
        items.clear();  // should trigger UnsupportedOperationsException

    }

    @Test
    public void findById_shouldReturnNull_whenIdNotFound() {
        MusicItem item = catalog.findById(1000L);
        assertNull(item);
    }

    @Test
    public void findById_shouldReturnMusicItemWithThatId_whenIdFound() {
        MusicItem item = catalog.findById(12L);
        assertTrue(12L == item.getId());
    }
}