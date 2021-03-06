package com.jackbrando.memotome;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.jackbrando.memotome.game.battle.BattleCharacter;
import com.jackbrando.memotome.game.battle.BattleOption;
import com.jackbrando.memotome.game.Wheel;
import com.jackbrando.memotome.game.selection.Selection;
import com.jackbrando.memotome.game.selection.SelectionListener;

import java.util.List;


/**
 * An example full-screen activity
 */
public class BattleActivity extends Activity {

    private List<Selection> selections;
    private BattleCharacter monster;
    private BattleCharacter hero;
    private static final String[] states = {"SPIN", "ACT", "REACT"};

    private String state = states[0];

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
        hero = new BattleCharacter();
        monster = new BattleCharacter();
        spinAllWheels();
        startAnimation(R.id.wheel1Prev, R.drawable.spin);
        startAnimation(R.id.wheel1Curr, R.drawable.spin2);

    }

    private void startAnimation(int id, int spin) {
        // Load the ImageView that will host the animation and
        // set its background to our AnimationDrawable XML resource.
        ImageView img = (ImageView)findViewById(id);
        img.setBackgroundResource(spin);

        // Get the background, which has been compiled to an AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

        // Start the animation (looped playback by default).
        frameAnimation.start();
    }

    private Wheel wheel1 = new Wheel(1);
    private Wheel wheel2 = new Wheel(2);
    private Wheel wheel3 = new Wheel(3);
    private Wheel wheel4 = new Wheel(4);
    private Wheel wheel5 = new Wheel(5);

    public void spin(View view) {
        spinAllWheels();
        this.state = states[1];
        System.out.println("The state is now: " + this.state);
        updateSpinButton();
    }

    private void updateSpinButton() {
        Button spinButton = (Button) findViewById(R.id.spinButton);
        boolean enabled = states[0].equals(this.state);
        spinButton.setEnabled(enabled);
        System.out.println("The button is " + enabled + "ly enabled.");
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
        updateWheelOption(myWheel.getPreviousOption(), wheelPrevious, myWheel);
        updateWheelOption(myWheel.getCurrentOption(), wheelCurrent, myWheel);
        updateWheelOption(myWheel.getNextOption(), wheelNext, myWheel);
        View selectionCanvas = findViewById(R.id.SelectionCanvas);
        selectionCanvas.invalidate();
    }

    private void updateWheelOption(BattleOption option, int id, Wheel wheel) {
        ImageView image = (ImageView) findViewById(id);
        String uri = "@drawable/" + option.getName();
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        image.setImageDrawable(res);
        image.setOnTouchListener(new SelectionListener(option, wheel));
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

    public void setSelections(List<Selection> selections) {
        this.selections = selections;
        if(this.selections.size() < 1){
            this.state = states[0];
            updateSpinButton();
        }
    }

    public List<Selection> getSelections() {
        return selections;
    }

    public BattleCharacter getMonster() {
        return monster;
    }

    public BattleCharacter getHero() {
        return hero;
    }

    public void takeAction(Selection chosenSelection) {
        BattleOption selectedOption = chosenSelection.getSelectedOption();
        System.out.println("Stand back!  I'm about to try " + selectedOption.getName() + " with the power of " + (chosenSelection.getLength() + 1));
        BattleCharacter hero = getHero();
        BattleCharacter monster = getMonster();
        System.out.println("Hero: " + hero.getHitPoints());
        System.out.println("Monster " + monster.getHitPoints());
        selectedOption.doAction(hero, monster, chosenSelection.getLength() + 1);
        System.out.println("BOOM!  Now hero has " + hero.getHitPoints() +
                " and the monster has " + monster.getHitPoints() + "!!!111");
        this.state = states[0];
        updateSpinButton();
    }

    public boolean isActionable() {
        return states[1].equals(this.state);
    }
}
