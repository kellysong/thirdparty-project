package uk.co.deanwild.materialshowcaseviewsample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;


public class SequenceExample2 extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonOne;
    private Button mButtonTwo;
    private Button mButtonThree;

    private Button mButtonReset;

    private static final String SHOWCASE_ID = "sequence example2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sequence_example2);
        mButtonOne = findViewById(R.id.btn_one);
        mButtonOne.setOnClickListener(this);

        mButtonTwo = findViewById(R.id.btn_two);
        mButtonTwo.setOnClickListener(this);

        mButtonThree = findViewById(R.id.btn_three);
        mButtonThree.setOnClickListener(this);

        mButtonReset = findViewById(R.id.btn_reset);
        mButtonReset.setOnClickListener(this);

        presentShowcaseSequence(); // one second delay
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_one || v.getId() == R.id.btn_two || v.getId() == R.id.btn_three
                || v.getId() == R.id.btn_four|| v.getId() == R.id.btn_five) {


            presentShowcaseSequence();

        } else if (v.getId() == R.id.btn_reset) {

            MaterialShowcaseView.resetSingleUse(this, SHOWCASE_ID);
            Toast.makeText(this, "Showcase reset", Toast.LENGTH_SHORT).show();
        }

    }

    private void presentShowcaseSequence() {
        View btn_one = findViewById(R.id.btn_one);
        View btn_two = findViewById(R.id.btn_two);
        View btn_three = findViewById(R.id.btn_three);
        View btn_four = findViewById(R.id.btn_four);
        View btn_five = findViewById(R.id.btn_five);
        ShowcaseConfig config = new ShowcaseConfig();
        config.setMaskColor(getResources().getColor(R.color.color_mask));
        config.setDelay(100); // 每个指示器显示100ms
        config.setRenderOverNavigationBar(true);
        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, SHOWCASE_ID);
        sequence.setConfig(config);

        sequence.addSequenceItem(new MaterialShowcaseView.Builder(this)
                .setTarget(btn_three)
                .setLayoutId(R.layout.showcase_content1)
                .setContentText("我是Button 3")
                .setDismissText("我知道了")
                .setSkipText("跳过")
                .withRectangleShape()
                .useFadeAnimation()
                .build());

        sequence.addSequenceItem(new MaterialShowcaseView.Builder(this)
                .setTarget(btn_four)
                .setLayoutId(R.layout.showcase_content2)
                .setContentText("我是Button 4")
                .setDismissText("我知道了")
                .setSkipText("跳过")
                .withRectangleShape()
                .useFadeAnimation()
                .build()
        );

        sequence.addSequenceItem(new MaterialShowcaseView.Builder(this)
                .setTarget(btn_five)
                .setLayoutId(R.layout.showcase_content3)
                .setContentText("我是Button 5")
                .setDismissText("我知道了")
                .setSkipText("跳过")
                .withRectangleShape().useFadeAnimation()
                .build()
        );

        sequence.addSequenceItem(new MaterialShowcaseView.Builder(this)
                .setTarget(btn_one)
                .setLayoutId(R.layout.showcase_content4)
                .setContentText("我是Button 1")
                .setDismissText("我知道了")
                .setSkipText("跳过")
                .withRectangleShape().useFadeAnimation()
                .build()
        );
        sequence.addSequenceItem(new MaterialShowcaseView.Builder(this)
                .setTarget(btn_two)
                .setLayoutId(R.layout.showcase_content5)
                .setContentText("我是Button 2")
                .setDismissText("我知道了")
                .setSkipText("跳过")
                .withRectangleShape().useFadeAnimation()
                .build()
        );
        sequence.start();


    }

}
