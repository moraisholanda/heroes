package com.marvel.heroes.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.marvel.heroes.R;
import com.marvel.heroes.ui.fragments.ComicsFragment;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsActivity extends BaseActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        imageView = (ImageView) findViewById(R.id.open_profile);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComicsActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new ComicsFragment());
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

   /* @OnClick(R.id.open_profile)
    void onClickProfile(){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }*/
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()) {

           case R.id.open_profile:

               return  true;
           default:
               break;
       }

       return false;
   }
}
