package application.taufiqrahman.com.ovto.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import application.taufiqrahman.com.ovto.R;

/**
 * Created by Taufiq on 5/30/2018.
 * Custom dialog for feedback of order
 */

public class FeedbackDialog {

    public void showDialog(Activity activity, String msg){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.feedback_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButtonLike = (Button) dialog.findViewById(R.id.btn_dialog_like);
        dialogButtonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button dialogButtonDislike = (Button) dialog.findViewById(R.id.btn_dialog_dislike);
        dialogButtonDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}