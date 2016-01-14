package com.jackbrando.memotome;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.jackbrando.memotome.game.Wheel;


/**
 * An example full-screen activity
 */
public class BattleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.battle_activity);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        spinAllWheels();
    }
    
    private Wheel wheel1 = new Wheel();
    private Wheel wheel2 = new Wheel();
    private Wheel wheel3 = new Wheel();
    private Wheel wheel4 = new Wheel();
    private Wheel wheel5 = new Wheel();

    public void spin(View view) {
        spinAllWheels();
    }

    private void spinAllWheels() {
        wheel1.spin();
        wheel2.spin();
        wheel3.spin();
        wheel4.spin();
        wheel5.spin();
        updateWheelValues();
    }

    private void updateWheelValues() {
        updateWheel1();
        updateWheel2();
        updateWheel3();
        updateWheel4();
        updateWheel5();
    }

    private void updateWheel1() {
        updateWheel(wheel1, R.id.wheel1Prev, R.id.wheel1Curr, R.id.wheel1Next);
    }

    private void updateWheel2() {
        updateWheel(wheel2, R.id.wheel2Prev, R.id.wheel2Curr, R.id.wheel2Next);
    }

    private void updateWheel3() {
        updateWheel(wheel3, R.id.wheel3Prev, R.id.wheel3Curr, R.id.wheel3Next);
    }

    private void updateWheel4() {
        updateWheel(wheel4, R.id.wheel4Prev, R.id.wheel4Curr, R.id.wheel4Next);
    }

    private void updateWheel5() {
        updateWheel(wheel5, R.id.wheel5Prev, R.id.wheel5Curr, R.id.wheel5Next);
    }

    private void updateWheel(Wheel myWheel, int wheelPrevious, int wheelCurrent, int wheelNext) {
        updateWheelOption(myWheel.getPreviousOption(), wheelPrevious, myWheel.getSelectedOption());
        updateWheelOption(myWheel.getCurrentOption(), wheelCurrent, myWheel.getSelectedOption());
        updateWheelOption(myWheel.getNextOption(), wheelNext, myWheel.getSelectedOption());
    }

    private void updateWheelOption(String option, int id, String selected) {
        ImageView image = (ImageView) findViewById(id);
        String uri = "@drawable/" + option;
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        image.setImageDrawable(res);
    }

    public Wheel getWheel1() {
        return wheel1;
    }

    public void setWheel1(Wheel wheel1) {
        this.wheel1 = wheel1;
    }

    public Wheel getWheel2() {
        return wheel2;
    }

    public void setWheel2(Wheel wheel2) {
        this.wheel2 = wheel2;
    }

    public Wheel getWheel3() {
        return wheel3;
    }

    public void setWheel3(Wheel wheel3) {
        this.wheel3 = wheel3;
    }

    public Wheel getWheel4() {
        return wheel4;
    }

    public void setWheel4(Wheel wheel4) {
        this.wheel4 = wheel4;
    }

    public Wheel getWheel5() {
        return wheel5;
    }

    public void setWheel5(Wheel wheel5) {
        this.wheel5 = wheel5;
    }
}
