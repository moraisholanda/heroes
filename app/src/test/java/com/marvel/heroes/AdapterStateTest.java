package com.marvel.heroes;

import android.os.Parcelable;

import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.ui.adapter.ComicsAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 23,constants = BuildConfig.class)
public class AdapterStateTest {
    @Test
    public void assertThatAdapterOsConsistentAfterRestoring(){

        ComicsAdapter adapter = new ComicsAdapter(null,false);
        List<Comics> list = Arrays.asList(
                new Comics("Hulk ",2),
                new Comics("SpiderMan ",2),
                new Comics("Thor ",2),
                new Comics("Iron man ",2));
        adapter.setItems(list);
        Parcelable parcelable = adapter.onSaveInstanceState();

        ComicsAdapter newAdapter = new ComicsAdapter(null,false);
        newAdapter.onRestoreInstanceState(parcelable);

        assertEquals(adapter.getItemCount(),newAdapter.getItemCount());
        assertEquals(adapter.getItems().get(1).title,newAdapter.getItems().get(1).title);

    }
}