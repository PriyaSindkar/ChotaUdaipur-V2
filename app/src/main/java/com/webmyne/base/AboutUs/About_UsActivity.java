package com.webmyne.base.AboutUs;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.ui.JustifiedTextView;

/**
 * Created by vaibhavirana on 21-03-2016.
 */
public class About_UsActivity extends AppCompatActivity {

    String text;
    JustifiedTextView txtAboutUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_main);

        text="The district consists of the six talukas of Chhota Udepur," +
                " Pavi Jetpur, Kawant, Naswadi, Sankheda and the newly created Bodeli taluka. " +
                "The district headquarters is located at Chhota Udepur." +
                "The district was created to facilitate decentralisation and ease of access to government services. " +
                "Its creation, announced in the run up to the Assembly elections in Gujarat in 2012, " +
                "was also seen by the media and political analysts as a government strategy to attract tribal votes."+
                "Chhota Udaipur is a tribal dominated district and the district headquarters is located 110 km away" +
                " from Vadodara. It shares its borders with the state of Madhya Pradesh. " +
                "Chhota Udepur is the third tribal dominated district in eastern Gujarat after the Narmada and Tapi districts." +
                "Chhota Udepur district has a forest area of 75,704 hectares and has deposits of dolomite, " +
                "fluorite, granite and sand all of which are mined. The district is also home to a large dairy industry." +
                " The Rathwa tribals who live here produce the Pithora mural paintings by mixing colours with liquour " +
                "and milk and then using it to depict intricate motifs and scenes on the walls of their village dwellings.";


        txtAboutUs=(JustifiedTextView)findViewById(R.id.activity_main_jtv);
        txtAboutUs.setAlignment(Paint.Align.LEFT);
        txtAboutUs.setText(text);
    }
}
