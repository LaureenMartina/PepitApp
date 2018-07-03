package com.example.laureen.pepitapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.laureen.pepitapp.model.NavItem;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ListView mDrawerList;
    RelativeLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavItems.add(new NavItem("Profil", "votre compte personnel", R.drawable.ic_user));
        mNavItems.add(new NavItem("Informations", "informations générales", R.drawable.ic_info));
        mNavItems.add(new NavItem("Espace Jeux", "apprenez en jouant", R.drawable.ic_cible));
        mNavItems.add(new NavItem("Preferences", "modifier vos paramètres", R.drawable.ic_params));
        mNavItems.add(new NavItem("Liker", "noter notre application", R.drawable.ic_rate));
        mNavItems.add(new NavItem("Déconnexion", "quittez", R.drawable.ic_power_off));

        // DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        // Populate the Navigtion Drawer with options
        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        mDrawerList = (ListView) findViewById(R.id.navList);
        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setAdapter(adapter);

        // Click listener sur Drawer Item
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position);
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Log.d("TAG", "onDrawerOpened: " + getTitle());
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.d("TAG", "onDrawerClosed: " + getTitle());
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    /*
     * lorsqu'un élément particulier du tiroir de navigation est sélectionné
     */
    private void selectItemFromDrawer(int position) {
        // TODO faire des conditions pr chaque page/menu avec position 0,1,2

        //Intent intent = new Intent(HomeActivity.this, ProfilActivity.class);
        //startActivity(intent);

        mDrawerList.setItemChecked(position, true);
        setTitle(mNavItems.get(position).mTitle);

        // Fermer le menu
        mDrawerLayout.closeDrawer(mDrawerPane);
    }

    /*
    * Inner class:
     */
    class DrawerListAdapter extends BaseAdapter {

        Context mContext;
        ArrayList<NavItem> mNavItems;

        public DrawerListAdapter(Context context, ArrayList<NavItem> navItems) {
            mContext = context;
            mNavItems = navItems;
        }

        @Override
        public int getCount() {
            return mNavItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mNavItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.drawer_item, null);
            }
            else {
                view = convertView;
            }

            TextView titleView = (TextView) view.findViewById(R.id.title);
            TextView subtitleView = (TextView) view.findViewById(R.id.subTitle);
            ImageView iconView = (ImageView) view.findViewById(R.id.icon);

            titleView.setText( mNavItems.get(position).mTitle);
            subtitleView.setText( mNavItems.get(position).mSubtitle);
            iconView.setImageResource(mNavItems.get(position).mIcon);

            return view;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Transmettre l'événement à ActionBarDrawerToggle
        // S'il retourne vrai, alors il a manipulé
        // l'événement tactile de l'indicateur de tiroir de nav
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        // Gère tes autres éléments de la barre d'action ...

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
}
