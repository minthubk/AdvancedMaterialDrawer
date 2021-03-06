package de.madcyph3r.example.example.headItemTypes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;

import de.madcyph3r.example.R;
import de.madcyph3r.example.example.FragmentDummy;
import de.madcyph3r.example.example.FragmentInstruction;
import de.madcyph3r.materialnavigationdrawer.MaterialNavigationDrawer;
import de.madcyph3r.materialnavigationdrawer.head.MaterialHeadItem;
import de.madcyph3r.materialnavigationdrawer.listener.MaterialSectionOnClickListener;
import de.madcyph3r.materialnavigationdrawer.menu.MaterialMenu;
import de.madcyph3r.materialnavigationdrawer.menu.item.MaterialSection;
import de.madcyph3r.materialnavigationdrawer.tools.RoundedCornersDrawable;

/**
 * Created by marc on 23.02.2015.
 */
public class HeadItemTwoExtraMenuActivity extends MaterialNavigationDrawer {

    MaterialNavigationDrawer drawer = null;

    @Override
    public int headerType() {
        // set type. you get the available constant from MaterialNavigationDrawer class
        return MaterialNavigationDrawer.DRAWERHEADER_HEADITEMS;
    }

    @Override
    public void init(Bundle savedInstanceState) {

        drawer = this;

        // create menu
        MaterialMenu menu = new MaterialMenu();

        // create menu items
        MaterialSection section = this.newSection("Create new Head Item", false, menu);
        section.setOnClickListener(new MaterialSectionOnClickListener() {
            @Override
            public void onClick(MaterialSection section, View view) {
                Toast.makeText(drawer, "extra menu on click. do something here", Toast.LENGTH_LONG).show();
            }
        });

        // set the extra menu
        drawer.setHeadItemSwitchExtraMenu(menu);

        // set this to true. It show the arrow down button every time, even is only one head item available.
        // here it is needed, to show the extra menu
        this.setHeadItemSwitchShowForce(true);

        // add head Item (menu will be loaded automatically)
        this.addHeadItem(getHeadItem1());
        this.addHeadItem(getHeadItem2());
    }

    private MaterialHeadItem getHeadItem1() {
        MaterialMenu menu = new MaterialMenu();

        Bundle bundle = new Bundle();
        bundle.putString("instruction", "This example shows the head item style with two items. " +
                "The first three head items ar shown with a picture. To get the other head items, " +
                "press the down arrow button in the header. " +
                "Under the items, you see the extra menu. " +
                "See the method headerType in the source code.");

        //create instruction fragment
        Fragment fragmentInstruction = new FragmentInstruction();
        fragmentInstruction.setArguments(bundle);

        // create menu items
        MaterialSection instruction = this.newSection("Instruction", fragmentInstruction , false, menu);
        instruction.setFragmentTitle("Head Item Style (Two Items) With Extra Menu");
        this.newDevisor(menu);
        this.newLabel("Label", false, menu);
        this.newSection("Section", new FragmentDummy(), false, menu);

        // use bitmap and make a circle photo
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.app_drawer_icon);
        final RoundedCornersDrawable drawableAppIcon = new RoundedCornersDrawable(getResources(), bitmap);

        // create Head Item
        MaterialHeadItem headItem = new MaterialHeadItem(this, "A HeadItem", "A Subtitle", drawableAppIcon, R.drawable.mat5, menu);
        return headItem;
    }

    private MaterialHeadItem getHeadItem2() {

        // create menu
        MaterialMenu menu = new MaterialMenu();

        // create menu items
        this.newSection("Section 1 (Head 2)", new FragmentDummy(), false, menu);
        this.newSection("Section 2", new FragmentDummy(), false, menu);

        // create icon
        TextDrawable headPhoto = TextDrawable.builder()
                .buildRound("B", Color.BLUE);

        // create Head Item
        MaterialHeadItem headItem = new MaterialHeadItem(this, "B HeadItem", "B Subtitle", headPhoto, R.drawable.mat6, menu);
        return headItem;
    }
}
