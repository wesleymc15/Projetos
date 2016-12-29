package br.com.enterprise.bevefood.bevfood.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.enterprise.bevefood.bevfood.interfaces.Cardapio;
import br.com.enterprise.bevefood.bevfood.interfaces.Pedido;

/**
 * Created by Wesley on 10/09/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int numbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    String numeroMesa;
    String enderecoIP;


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb, String numeroMesa, String enderecoIP) {
        super(fm);

        this.enderecoIP = enderecoIP;
        this.titles = mTitles;
        this.numbOfTabs = mNumbOfTabsumb;
        this.numeroMesa = numeroMesa;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            Cardapio tab1 = new Cardapio(enderecoIP);
            return tab1;
        }
        else             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Pedido tab2 = new Pedido(numeroMesa);
            return tab2;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return numbOfTabs;
    }
}
