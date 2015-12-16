package com.jackbrando.memotome;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
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
    }
    
    private Wheel wheel1 = new Wheel();
    private Wheel wheel2 = new Wheel();
    private Wheel wheel3 = new Wheel();
    private Wheel wheel4 = new Wheel();
    private Wheel wheel5 = new Wheel();

    public void spin(View view) {
        wheel1.spin();
        wheel2.spin();
        wheel3.spin();
        wheel4.spin();
        wheel5.spin();
        updateWheelValues();
        //createARandomLine();
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

    public void selectPrevOnWheel1(View view){
        wheel1.selectPrevous();
        
    }
    public void selectCurrOnWheel1(View view){
        wheel1.selectCurrent();
        updateWheel1();
    }
    public void selectNextOnWheel1(View view){
        wheel1.selectNext();
        updateWheel1();
    }
    public void selectPrevOnWheel2(View view){
        wheel2.selectPrevous();
        updateWheel2();
    }
    public void selectCurrOnWheel2(View view){
        wheel2.selectCurrent();
    }
    public void selectNextOnWheel2(View view){
        wheel2.selectNext();
    }
    public void selectPrevOnWheel3(View view){
        wheel3.selectPrevous();
    }
    public void selectCurrOnWheel3(View view){
        wheel3.selectCurrent();
    }
    public void selectNextOnWheel3(View view){
        wheel3.selectNext();
    }
    public void selectPrevOnWheel4(View view){
        wheel4.selectPrevous();
    }
    public void selectCurrOnWheel4(View view){
        wheel4.selectCurrent();
    }
    public void selectNextOnWheel4(View view){
        wheel4.selectNext();
    }
    public void selectPrevOnWheel5(View view){
        wheel5.selectPrevous();
    }
    public void selectCurrOnWheel5(View view){
        wheel5.selectCurrent();
    }
    public void selectNextOnWheel5(View view){
        wheel5.selectNext();
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
}
