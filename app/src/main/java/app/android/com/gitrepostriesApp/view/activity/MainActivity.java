package app.android.com.gitrepostriesApp.view.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import app.android.com.gitrepostriesApp.GitRepoApplication;
import app.android.com.gitrepostriesApp.R;
import app.android.com.gitrepostriesApp.listeners.ContributorSelectedListener;
import app.android.com.gitrepostriesApp.listeners.RepoActivityListener;
import app.android.com.gitrepostriesApp.model.ConnectionModel;
import app.android.com.gitrepostriesApp.model.ContributorModel;
import app.android.com.gitrepostriesApp.model.RepositoryModel;
import app.android.com.gitrepostriesApp.utils.ConnectionLiveData;
import app.android.com.gitrepostriesApp.view.fragment.ContributorDetailFragment;
import app.android.com.gitrepostriesApp.view.fragment.ContributorRepoFragment;
import app.android.com.gitrepostriesApp.view.fragment.TopGitRepositories;
import butterknife.BindView;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

import static app.android.com.gitrepostriesApp.constant.AppConstant.MobileData;
import static app.android.com.gitrepostriesApp.constant.AppConstant.WifiData;

public class MainActivity extends AppCompatActivity implements RepoActivityListener, ContributorSelectedListener {

    @BindView(R.id.container)
    FrameLayout mContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GitRepoApplication.getInstance();
        isConnected();
        if(savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.container, new TopGitRepositories(this)).commit();
    }

    // pass context to Calligraphy
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {
        getSupportFragmentManager().popBackStack();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
    }
    /**
     * initialization fragment for Repo Contributors
     */
    @Override
    public void onRepoActivity(RepositoryModel repo) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ContributorRepoFragment.KEY_ARGUMENT, repo);

        ContributorRepoFragment contributorRepoFragment = new ContributorRepoFragment(this);
        contributorRepoFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("contributorRepoFragment")
                .replace(R.id.container, contributorRepoFragment)
                .commit();
    }

    /**
     * initialization fragment for Contributors Details
     */
    @Override
    public void onContributorActivity(ContributorModel repo) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ContributorRepoFragment.KEY_ARGUMENT, repo);

        ContributorDetailFragment contributorDetailFragment = new ContributorDetailFragment(this);
        contributorDetailFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("contributorDetailFragment")
                .replace(R.id.container, contributorDetailFragment)
                .commit();
    }


    public void isConnected(){
        ConnectionLiveData connectionLiveData = new ConnectionLiveData(getApplicationContext());
        connectionLiveData.observe(this, new Observer<ConnectionModel>() {
            @Override
            public void onChanged(@Nullable ConnectionModel connection) {
                /* every time connection state changes, we'll be notified and can perform action accordingly */
                if (connection.getIsConnected()) {
                    switch (connection.getType()) {
                        case WifiData:
                            Toast.makeText(MainActivity.this, String.format("Wifi turned ON"), Toast.LENGTH_SHORT).show();
                            break;
                        case MobileData:
                            Toast.makeText(MainActivity.this, String.format("Mobile data turned ON"), Toast.LENGTH_SHORT).show();
                            break;
                    }
                } else {
                    Toast.makeText(MainActivity.this, String.format("Connection turned OFF"), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}