package application.taufiqrahman.com.ovto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import application.taufiqrahman.com.ovto.bottomTabBar.Notifications;
import application.taufiqrahman.com.ovto.bottomTabBar.Options;
import application.taufiqrahman.com.ovto.bottomTabBar.Profile;
import devlight.io.library.ntb.NavigationTabBar;

public class MainActivity extends AppCompatActivity {

    public boolean mIsLogged = true;
    public static TextView mToolbarText;
    Toolbar mToolBar;
    private Context mContext;
    private Activity mActivity;

    private RelativeLayout mRelativeLayout;
    private Button mButton;

    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppProductionTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolBar = findViewById(R.id.main_toolbar);
        mToolbarText = findViewById(R.id.toolbar_title);
        mToolbarText.setText(R.string.home_title);

        bottomTabBar();
    }

    private void bottomTabBar() {

        final String[] colors = getResources().getStringArray(R.array.default_preview);

        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_horizontal);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_home),
                        Color.parseColor("#299b4d"))
                        .title("Home")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_notifications),
                        Color.parseColor("#299b4d"))
                        .title("Notifications")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_profile),
                        Color.parseColor("#299b4d"))
                        .title("Profile")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_settings),
                        Color.parseColor("#299b4d"))
                        .title("Settings")
                        .build()
        );

        navigationTabBar.setModels(models);
        navigationTabBar.setInactiveColor(Color.parseColor("#FF58534E"));
        navigationTabBar.setIsTitled(true);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frameLayout, new Home()).commit();

        //IMPORTANT: ENABLE SCROLL BEHAVIOUR IN COORDINATOR LAYOUT
        navigationTabBar.setBehaviorEnabled(true);

        navigationTabBar.setOnTabBarSelectedIndexListener(new NavigationTabBar.OnTabBarSelectedIndexListener() {
            @Override
            public void onStartTabSelected(final NavigationTabBar.Model model, final int index) {
                beginFragmentTransactions(index);
            }

            @Override
            public void onEndTabSelected(final NavigationTabBar.Model model, final int index) {
                model.hideBadge();
            }
        });
        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
                beginFragmentTransactions(position);
            }

            @Override
            public void onPageSelected(final int position) {

            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

        // final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.parent);
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                for (int i = 0; i < navigationTabBar.getModels().size(); i++) {
                    final NavigationTabBar.Model model = navigationTabBar.getModels().get(i);
                    navigationTabBar.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            final String title = String.valueOf(new Random().nextInt(15));
                            if (!model.isBadgeShowed()) {
                                model.setBadgeTitle(title);
                                model.showBadge();
                            } else model.updateBadgeTitle(title);
                        }
                    }, i * 100);
                }

//                coordinatorLayout.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        final Snackbar snackbar = Snackbar.make(navigationTabBar, "Coordinator NTB", Snackbar.LENGTH_SHORT);
//                        snackbar.getView().setBackgroundColor(Color.parseColor("#299b4d"));
//                        ((TextView) snackbar.getView().findViewById(R.id.snackbar_text))
//                                .setTextColor(Color.parseColor("#FF454545"));
//                        snackbar.show();
//                    }
//                }, 1000);
            }
        });
    }

 /*   private void setAlertDialog(int key) {
        switch (key) {
            case 1:
                alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage(getString(R.string.change_language_prompt));

                alertDialogBuilder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        if (getSharedPreference.getLanguage().equals("en")) {
                            setSharedPreference.setLanguage("ar");
                            restartActivity(MainActivity.this);
                        } else {
                            setSharedPreference.setLanguage("en");
                            restartActivity(MainActivity.this);
                        }
                    }
                });

                alertDialogBuilder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                break;
            case 2:
                alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage(getString(R.string.signin_first));

                alertDialogBuilder.setPositiveButton(getString(R.string.action_sign_in), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        MainActivity.this.finish();
                    }
                });

                alertDialogBuilder.setNegativeButton(getString(R.string.prompt_continue), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                break;
        }
    }//end setAlertDialog
    */

    private void beginFragmentTransactions(int index) {
        switch (index) {
            case 0:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_frameLayout, new Home()).commit();
                break;
            case 1:
                if (mIsLogged)
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_frameLayout, new Notifications()).commit();
                else {
                   /* setAlertDialog(2);
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show(); */
                }
                break;
            case 2:
                if (mIsLogged)
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_frameLayout, new Profile()).commit();
                else {
                    /* setAlertDialog(2);
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show(); */
                }
                break;
            case 3:
                if (mIsLogged)
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_frameLayout, new Options()).commit();
                else {
                    /* setAlertDialog(2);
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show(); */
                }
                break;
        }//end switch
    }
//    public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
//
//        @Override
//        public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
//            final View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_list, parent, false);
//            return new ViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(final ViewHolder holder, final int position) {
//            holder.txt.setText(String.format("Food Item #%d", position));
//        }
//
//        @Override
//        public int getItemCount() {
//            return 20;
//        }
//
//        public class ViewHolder extends RecyclerView.ViewHolder {
//
//            public TextView txt;
//
//            public ViewHolder(final View itemView) {
//                super(itemView);
//                txt = (TextView) itemView.findViewById(R.id.txt_vp_item_list);
//            }
//        }
//    }

    public void shareInviteCode(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");
        String shareBodyText = "sharing message";
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject/Title");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
        startActivity(Intent.createChooser(intent, "Choose sharing method"));
    }

    public void openSettings(View view) {
        Intent intent = new Intent(this, EditProfile.class);
        startActivity(intent);
    }
}
