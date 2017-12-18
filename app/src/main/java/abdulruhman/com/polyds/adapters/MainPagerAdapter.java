package abdulruhman.com.polyds.adapters;

/**
 * Created by AbdulRuhman on 11/20/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import abdulruhman.com.polyds.fragments.PolyExec;
import abdulruhman.com.polyds.fragments.PolyOps;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    private String[] tabTitles = new String[]{"Operations", "Execute"};

    public MainPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

       switch (position) {
            case 0:
                Fragment tab5 = new PolyOps();
                return tab5;
            case 1:
                Fragment tab3 =  new PolyExec();
                return tab3;
            default:
                return null;
        }
    }
    // overriding getPageTitle()
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return 2;
    }
}