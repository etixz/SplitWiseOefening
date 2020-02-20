package eb.egonb.splitwiseoefening.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import eb.egonb.splitwiseoefening.fragments.AboutFragment;
import eb.egonb.splitwiseoefening.fragments.PrefFragment;
import eb.egonb.splitwiseoefening.fragments.SplitFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments = {SplitFragment.newInstance(), AboutFragment.newInstance(), PrefFragment.newInstance()};

    public TabPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Split It";
        }
        if(position == 1){
            return "About";
        }
        return "Settings";
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
