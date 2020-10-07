package app.android.com.gitrepostriesApp;

import android.app.Application;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class GitRepoApplication extends Application {

    private static GitRepoApplication mInstance;


    public static synchronized GitRepoApplication getInstance() {
        if (mInstance==null){
            GitRepoApplication gitRepoApplication= new GitRepoApplication();
            mInstance= gitRepoApplication;
        }
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // initalize Calligraphy
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/Roboto-RobotoRegular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
    }
}
