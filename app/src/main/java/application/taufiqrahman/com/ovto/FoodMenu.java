package application.taufiqrahman.com.ovto;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import java.util.ArrayList;

import application.taufiqrahman.com.ovto.utils.FeedbackDialog;

public class FoodMenu extends Activity {

    final Context context = this;

    LinearLayout asthmaActionPlan;
    LinearLayout controlledMedication;
    LinearLayout asNeededMedication;
    LinearLayout rescueMedication;
    LinearLayout yourTriggers;
    LinearLayout wheezeRate;
    LinearLayout peakFlow;
    LayoutParams params;
    LinearLayout next, prev;
    int viewWidth;
    GestureDetector gestureDetector = null;
    Button b;
    HorizontalScrollView horizontalScrollView;
    ArrayList<LinearLayout> layouts;
    int parentLeft, parentRight;
    int mWidth;
    int currPosition, prevPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        b = (Button) findViewById(R.id.order_button);

//        prev = (LinearLayout) findViewById(R.id.prev);
//        next = (LinearLayout) findViewById(R.id.next);
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.hsv);
        gestureDetector = new GestureDetector(new MyGestureDetector());
        asthmaActionPlan = (LinearLayout) findViewById(R.id.asthma_action_plan);
        controlledMedication = (LinearLayout) findViewById(R.id.controlled_medication);
        asNeededMedication = (LinearLayout) findViewById(R.id.as_needed_medication);
        rescueMedication = (LinearLayout) findViewById(R.id.rescue_medication);

        Display display = getWindowManager().getDefaultDisplay();
        mWidth = display.getWidth(); // deprecated
        viewWidth = mWidth / 3;
        layouts = new ArrayList<LinearLayout>();
        params = new LayoutParams(viewWidth, LayoutParams.WRAP_CONTENT);

        asthmaActionPlan.setLayoutParams(params);
        controlledMedication.setLayoutParams(params);
        asNeededMedication.setLayoutParams(params);
        rescueMedication.setLayoutParams(params);

        layouts.add(asthmaActionPlan);
        layouts.add(controlledMedication);
        layouts.add(asNeededMedication);
        layouts.add(rescueMedication);
        layouts.add(yourTriggers);
        layouts.add(wheezeRate);
        layouts.add(peakFlow);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedbackDialog alert4 = new FeedbackDialog();
                alert4.showDialog(FoodMenu.this, "How was the food pricing?");
                FeedbackDialog alert3 = new FeedbackDialog();
                alert3.showDialog(FoodMenu.this, "How was the service?");
                FeedbackDialog alert2 = new FeedbackDialog();
                alert2.showDialog(FoodMenu.this, "How was the environment?");
                FeedbackDialog alert = new FeedbackDialog();
                alert.showDialog(FoodMenu.this, "How was the food quality?");
            }
        });

//        prev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Handler().postDelayed(new Runnable() {
//                    public void run() {
//                        horizontalScrollView.smoothScrollTo(
//                                (int) horizontalScrollView.getScrollX()
//                                        - viewWidth,
//                                (int) horizontalScrollView.getScrollY());
//                    }
//                }, 100L);
//            }
//        });

        horizontalScrollView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    return true;
                }
                return false;
            }
        });
    }



    class MyGestureDetector extends SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            if (e1.getX() < e2.getX()) {
                currPosition = getVisibleViews("left");
            } else {
                currPosition = getVisibleViews("right");
            }

            horizontalScrollView.smoothScrollTo(layouts.get(currPosition)
                    .getLeft(), 0);
            return true;
        }
    }

    public int getVisibleViews(String direction) {
        Rect hitRect = new Rect();
        int position = 0;
        int rightCounter = 0;
        for (int i = 0; i < layouts.size(); i++) {
            if (layouts.get(i).getLocalVisibleRect(hitRect)) {
                if (direction.equals("left")) {
                    position = i;
                    break;
                } else if (direction.equals("right")) {
                    rightCounter++;
                    position = i;
                    if (rightCounter == 2)
                        break;
                }
            }
        }
        return position;
    }

    void message(){
        Toast.makeText(FoodMenu.this,
                "Thank you for your feedback!", Toast.LENGTH_LONG).show();
    }
//
}
