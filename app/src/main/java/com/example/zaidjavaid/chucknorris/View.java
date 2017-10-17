package com.example.zaidjavaid.chucknorris;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Zaid Javaid on 10/16/2017.
 */

public class View extends LinearLayout
{
    private Button button;
    private TextView textview;
    private TextView textview2;

    public View(Context context, View.OnClickListener listener)
    {
        super(context);
        button = new Button (context);

        //Creating the layout
        LinearLayout linearlayout = new LinearLayout(context);

        //Setting up the orientation
        linearlayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams linearlayoutparams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        addView(linearlayout,linearlayoutparams);

        //setting up button
        button = new Button(context);
        LinearLayout.LayoutParams buttonviewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        buttonviewParams.gravity = Gravity.CENTER_HORIZONTAL;
        button.setText("Click Me");
        button.setTextSize(10);
        button.setOnClickListener(listener);
        linearlayout.addView(button,buttonviewParams);

        //setting up the textview(Result)
        textview = new TextView(context);
        LinearLayout.LayoutParams textviewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        textviewParams.gravity = Gravity.CENTER_HORIZONTAL;
        textview.setLayoutParams(textviewParams);
        textview.setText("Result");
        textview.setTextSize(25);
        linearlayout.addView(textview, textviewParams);

        //textview (character count)
        textview2 = new TextView(context);
        LinearLayout.LayoutParams  textviewparams2=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        textviewparams2.gravity=Gravity.CENTER_HORIZONTAL;
        textview2.setLayoutParams(textviewparams2);
        textview2.setText("Character count");
        textview2.setTextSize(25);
        linearlayout.addView(textview2, textviewparams2);
    }

    public boolean isButton(Button b)
    {
        return (b == button);
    }

    public void updateSentenceSize()
    {
        textview2.setText("Number of characters " + Integer.toString(textview.getText().length()));
    }

    public void getText(String s,String t)
    {
        textview.setText("id: " + s + "\n"+"Joke: "+t);
    }
}
