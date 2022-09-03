/** Android ListView :-
 ------------------------
        The "ListView" is a view which contains the group of items and displays in a scrollable list.
 ListView is implemented by importing "android.widget.ListView" class. ListView is a default scrollable
 which does not use other scroll view.

        ListView uses Adapter classes which adds the content from data source (such as "string array",
 "array", "database", etc) to ListView. Adapter bridges data between an AdapterViews and other Views
 (ListView, ScrollView, etc).

 ListView class declaration :-
 -------------------------------
    ---------------------------------------------
    | public class ListView extends AbsListView |
    ---------------------------------------------

 ListView class hierarchy :-
 ------------------------------
    java.lang.Object
    L> android.view.View
       L> android.view.ViewGroup
          L> android.widget.AdapterView <android.widget.ListAdapter>
             L> android.widget.AbsListView
                L> android.widget.ListView

 Nested Classes :-
 -------------------
 1) class ListView.FindViewInfo :- A class that represents a fixed view in a list, for example a header at a top (or) a footer at a bottom.

 XML attributes :-
 -------------------
 1) android:divider - Drawable (or) color to draw between list items.
 2) android:dividerHeight - Height of the divider
 3) android:entries - References (or) an array resource that will populate the ListView.
 4) android:headerDividersEnabled - When set to false, the listview will not drawn the divider after each header view.
 5) android:footerDividersEnabled - When set to false, the ListView will not draw the divider before each footer view.
 **/

package com.example.myfirstapplication;

// Import the necessary packages
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import android.graphics.Color;

import com.google.android.material.shape.OffsetEdgeTreatment;

import java.util.Arrays;

public class Program_14_ListView extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_14_list_view);

        String[] personsList = {"Ashwin", "Reshma", "Amutha", "Kannan", "Supriya", "Kirthika", "Suriya", "Kowshik", "Vignesh"};
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(Program_14_ListView.this, android.R.layout.simple_list_item_1, Arrays.asList(personsList));

        listView = findViewById(R.id.list_view);
        listView.setAdapter(stringArrayAdapter); // This method is used to set the data behind the list view.
        listView.setItemsCanFocus(true); // This method is used to indicates that the views created by the "ListAdapter" can contain focusable items.
        listView.setCacheColorHint(Color.BLUE); // When set to non-zero value, the cache color hint indicates that the list is always drawn on top of a solid, single-color, opaque background.
        listView.setSelection(0); // This method is used to set the currently selected item
        listView.setSelectionAfterHeaderView(); // This method is used to set the selection to be first list item after the header views.
        listView.setDividerHeight(5); // This method is used to sets the height of the divider that will be drawn between each items in the list.
        listView.setHeaderDividersEnabled(true); // This method is used to enables (or) disables the drawing of the divider for header views.
        listView.setFooterDividersEnabled(true); // this method is used to enables (or) disables the drawing of the divider for footer views.
        listView.smoothScrollByOffset(10); // This method is used to set the selection to be the first list item after the header views.
        listView.smoothScrollToPosition(10); // This method is used to smoothly scroll to the specified adapter position. The view will scroll such that the indicated position is displayed.


        System.out.println("getAdapter() method :- " + listView.getAdapter()); // This method is used to returns the adapter currently in use with list view.
        System.out.println("getDivider() method :- " + listView.getDivider()); // This method is used to returns the drawable that will be drawn between each items in a list.
        System.out.println("getDividerHeight() method :- " + listView.getDividerHeight());
        System.out.println("getHeaderViewsCount() method :- " + listView.getHeaderViewsCount());
        System.out.println("getFooterViewsCount() method :- " + listView.getFooterViewsCount());
        System.out.println("getItemsCanFocus() method :- " + listView.getItemsCanFocus());
        System.out.println("getMaxScrollAmount() method :- " + listView.getMaxScrollAmount());
        System.out.println("getOverScrollHeader() method :- " + listView.getOverscrollHeader());
        System.out.println("getOverScrollFooter() method :- " + listView.getOverscrollFooter());
        System.out.println("isOpaque() method :- " + listView.isOpaque()); // This method is used to indicates whether this view is opaque.
        System.out.println("areHeaderDividersEnabled() method :- " + listView.areHeaderDividersEnabled());
        System.out.println("areFooterDividersEnabled() method :- " + listView.areFooterDividersEnabled());


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String itemClicked = "You selected the person : " + personsList[i];
                Toast.makeText(view.getContext(), itemClicked, Toast.LENGTH_SHORT).show();
            }
        });
    }
}