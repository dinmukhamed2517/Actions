package kz.just_code.motion;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private float xDelta, yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView movableControl = findViewById(R.id.movableControl);

        movableControl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int action = event.getAction();
                final float x = event.getRawX();
                final float y = event.getRawY();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Save the initial touch coordinates
                        xDelta = x - movableControl.getX();
                        yDelta = y - movableControl.getY();
                        Toast.makeText(MainActivity.this, "ACTION_DOWN", Toast.LENGTH_SHORT).show();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        // Update the position of the control based on the touch movement
                        movableControl.setX(x - xDelta);
                        movableControl.setY(y - yDelta);
                        Toast.makeText(MainActivity.this, "ACTION_MOVE", Toast.LENGTH_SHORT).show();
                        break;

                    case MotionEvent.ACTION_UP:
                        // Do something when the finger is lifted
                        Toast.makeText(MainActivity.this, "ACTION_UP", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
    }
}