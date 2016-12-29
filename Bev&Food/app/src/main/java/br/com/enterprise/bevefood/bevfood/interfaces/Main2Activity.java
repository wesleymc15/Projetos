package br.com.enterprise.bevefood.bevfood.interfaces;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import br.com.enterprise.bevefood.bevfood.R;
import br.com.enterprise.bevefood.bevfood.adapters.ViewPagerAdapter;
import br.com.enterprise.bevefood.bevfood.extras.SlidingTabLayout;

public class Main2Activity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence titles[] = {"CARDÁPIO", "PEDIDO"};
    int numbOfTabs = 2;
    Typeface myTypeface;
    TextView tvToolbarText;
    TextView tvMesa;

    public void setTitulo(){
        myTypeface = Typeface.createFromAsset(getAssets(), "lobster.otf");
        tvToolbarText = (TextView) findViewById(R.id.toolbarText);
        tvToolbarText.setTypeface(myTypeface);
    }

    public void setToolbars(){
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("Bev&Food");
        setSupportActionBar(toolbar);
    }

    public void setAdapters(String mesa, String endereco){
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), titles, numbOfTabs, mesa, endereco);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
    }

    public void setTab(){
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollCollor);
            }
        });

        tabs.setViewPager(pager);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitulo();
        setToolbars();

        Intent intencao = getIntent();
        String mesa = intencao.getStringExtra("MESA");
        String endereco = intencao.getStringExtra("ENDERECO");

        setAdapters(mesa, endereco);
        setTab();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
