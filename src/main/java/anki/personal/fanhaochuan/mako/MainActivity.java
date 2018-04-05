package anki.personal.fanhaochuan.mako;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.app.*;
import android.widget.*;
import android.view.View.*;
import android.widget.ImageView.*;
import android.media.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        int About_Try_Times = 0;
        boolean Calendar_Times = false;



        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            Calendar_Delete();
        }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.Menu_About:
                Menu_About();
                break;
            case  R.id.Menu_Exit:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Play_Musics(R.drawable.about_pic,"d");
        }  if (id == R.id.nav_gallery) {

            Calendar_Times=!Calendar_Times;
            if (Calendar_Times) {
                Calendar_Show();
            }
            else
                Calendar_Delete();
        }  if (id == R.id.nav_slideshow) {

        }  if (id == R.id.nav_manage) {

        }  if (id == R.id.nav_share) {

        }  if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public class choose_musics{
        LinearLayout music_linearlayout = new LinearLayout(MainActivity.this);
        final Dialog music_dialog = new Dialog(MainActivity.this);
        Button Music_Button = new Button(MainActivity.this);
        public Dialog Music_Dialog() {
            music_dialog.setContentView(music_linearlayout);
            music_dialog.show();
            return music_dialog;
        }


    }
    public void Menu_About(){
        final Dialog About_Dialog = new Dialog(this);

        final Dialog Tried_Dialog= new Dialog(MainActivity.this);
        final Button Okey_Button = new Button(this);
        Okey_Button.setText("确认");
        Button About_Button = new Button(this);
        final Button Tried_Button = new Button(this);
        Tried_Button.setText("嗯嗯");
        About_Button.setText("没东西了");
        LinearLayout About_LinearLayout = new LinearLayout(MainActivity.this);
        About_Dialog.setTitle("Just_Develop_For_U");
        About_Dialog.setContentView(About_LinearLayout);
        About_LinearLayout.setOrientation(1);
        About_LinearLayout.addView(About_Button);
        About_LinearLayout.addView(Okey_Button);
        About_Dialog.setCanceledOnTouchOutside(false);
        About_Button.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View p1){

                if (About_Try_Times==0){

                    Toast.makeText(MainActivity.this,"哈哈，没啦",Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this,"真的吗？(多试几次)",Toast.LENGTH_SHORT).show();
                }About_Try_Times++;

                if (About_Try_Times==16){

                    LinearLayout Tried_LinearLayout = new LinearLayout(MainActivity.this);
                    ImageView Tried_Image = new ImageView(MainActivity.this);
                    Tried_Image.setScaleType((ScaleType.FIT_CENTER));
                    Tried_Image.setImageResource(R.drawable.about_pic);
                    Tried_LinearLayout.addView(Tried_Image);
                    Tried_LinearLayout.addView(Tried_Button);
                    Tried_LinearLayout.setOrientation(1);
                    Tried_Dialog.setContentView(Tried_LinearLayout);
                    Tried_Dialog.setTitle("嘿嘿");
                    Tried_Dialog.show();
                }
                else if(About_Try_Times>=16){
                    Snackbar.make(p1, "真没啦", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }});
        Okey_Button.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View p1)
            {
                About_Dialog.cancel();
            }
        });
        Tried_Button.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View p1)
            {
                Tried_Dialog.cancel();
            }


        });

        About_Dialog.show();




    }
    public void Calendar_Show(){
        CalendarView Calendar = (CalendarView) findViewById(R.id.Calendar);
        Calendar.setVisibility(View.VISIBLE);


    }
    public void Calendar_Delete(){

        CalendarView Calendar = (CalendarView) findViewById(R.id.Calendar);
        Calendar.setVisibility(View.GONE);
    }
    public void Play_Musics(int Music_Pic_Id,String Music_Name) {
        choose_musics Choise_Music = new choose_musics();
        Dialog Music_Dialog = Choise_Music.Music_Dialog();
        TextView Music_Dialog_Title = new TextView(MainActivity.this);
        Music_Dialog_Title.setText("选一首吧");
        Music_Dialog_Title.setTextSize(15.f);
        Choise_Music.music_linearlayout.setOrientation(LinearLayout.VERTICAL);
        Choise_Music.music_linearlayout.addView(Music_Dialog_Title);
        Choise_Music.music_linearlayout.addView(Music_Names(Music_Name));
        Music_Dialog.setCanceledOnTouchOutside(false);
        ImageView music_image = (ImageView) findViewById(R.id.music_image);
        music_image.setImageResource(R.drawable.about_pic);
    }
        void Music_Player(int Music_Raw) {
        MediaPlayer Music_Player = MediaPlayer.create(MainActivity.this, Music_Raw);
        if (!Music_Player.isPlaying()) {
            Music_Player.setLooping(true);
            Music_Player.start();
        }
        }

    public CardView Music_Names(String Name){
        final TextView Music_Names_Texts = new TextView(MainActivity.this);
        final CardView Music_Names = new CardView(MainActivity.this);
        Music_Names.setClickable(true);
        Music_Names.setElevation(10.0f);
        Music_Names_Texts.setTextSize(35.f);
        Music_Names_Texts.setText(Name);
        Music_Names.addView(Music_Names_Texts);
        Music_Names_Texts.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        return Music_Names;
    }
}
