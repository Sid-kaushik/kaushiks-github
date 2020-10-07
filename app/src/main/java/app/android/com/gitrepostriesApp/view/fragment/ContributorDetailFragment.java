package app.android.com.gitrepostriesApp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import app.android.com.gitrepostriesApp.R;
import app.android.com.gitrepostriesApp.adapter.TopGitRepositoryAdapter;
import app.android.com.gitrepostriesApp.listeners.ContributorSelectedListener;
import app.android.com.gitrepostriesApp.listeners.RepoActivityListener;
import app.android.com.gitrepostriesApp.model.ContributorModel;
import app.android.com.gitrepostriesApp.model.RepositoryModel;
import app.android.com.gitrepostriesApp.view_model.RepositoryViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ContributorDetailFragment extends Fragment {

    @BindView(R.id.progress_circular_contributors)
    ProgressBar mProgressbar;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.imgViewCover_contributor)
    ImageView mContributorImage;

    @BindView(R.id.tvName)
    TextView mName;


    private View view;
    private ContributorModel mDataModel;
    public static final String KEY_ARGUMENT = "repo_data";
    private LinearLayoutManager layoutManager;
    private ArrayList<RepositoryModel> mContributorList;
    private RepositoryViewModel contributorDetailViewModel;
    private TopGitRepositoryAdapter adapter;
    RepoActivityListener mRepoActivityListener;


    public ContributorDetailFragment ( RepoActivityListener repoActivityListener) {
        this.mRepoActivityListener=repoActivityListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null) {
            mDataModel = getArguments().getParcelable(KEY_ARGUMENT);
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.contributor_details_layout,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        setView();
        getContributorDetails();
    }

    private void setView() {

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        mContributorList= new ArrayList<>();

        Glide.with(getActivity())
                .load(mDataModel.getUrlToImage())
                .into(mContributorImage);
        mName.setText(mDataModel.getName());
        // adapter
       adapter = new TopGitRepositoryAdapter(getActivity(),mRepoActivityListener, mContributorList);
        mRecyclerView.setAdapter(adapter);

        // View Model
        contributorDetailViewModel = ViewModelProviders.of(this).get(RepositoryViewModel.class);
        contributorDetailViewModel.contributorsDetails(mDataModel.getName());
    }

    private void getContributorDetails() {
        contributorDetailViewModel.getContributorDetailResponseLiveData().observe(this, articleResponse -> {
            if (articleResponse != null) {

                mProgressbar.setVisibility(View.GONE);
                List<RepositoryModel> articles = articleResponse;
                mContributorList.addAll(articles);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
