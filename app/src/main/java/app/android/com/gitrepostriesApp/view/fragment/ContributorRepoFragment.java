package app.android.com.gitrepostriesApp.view.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import app.android.com.gitrepostriesApp.R;
import app.android.com.gitrepostriesApp.adapter.RepostoriesContributorAdapter;
import app.android.com.gitrepostriesApp.listeners.ContributorSelectedListener;
import app.android.com.gitrepostriesApp.listeners.RepoActivityListener;
import app.android.com.gitrepostriesApp.model.ContributorModel;
import app.android.com.gitrepostriesApp.model.RepositoryModel;
import app.android.com.gitrepostriesApp.view_model.RepositoryViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ContributorRepoFragment extends Fragment {

        @BindView(R.id.progress_circular_contributors)
         ProgressBar mProgressbar;

        @BindView(R.id.imgViewCover)
         ImageView mUserRepoImageview;

        @BindView(R.id.tvName)
         TextView mName;

        @BindView(R.id.tv_full_name)
         TextView mFullname;

        @BindView(R.id.tv_description)
         TextView  mDescription;

        @BindView(R.id.my_recycler_view)
         RecyclerView mRecyclerView;

        View view;
        private GridLayoutManager layoutManager;
        private RepostoriesContributorAdapter adapter;
        RepositoryViewModel mContributorViewModel;
        private ArrayList<ContributorModel> contributorArrayList;
        RepositoryModel mDataModel;
        public static final String KEY_ARGUMENT = "repo_data";
        ContributorSelectedListener mContributorSelectedListener;

    public ContributorRepoFragment (ContributorSelectedListener contributorSelectedListener) {
         this.mContributorSelectedListener=contributorSelectedListener;
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
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            view=inflater.inflate(R.layout.contributor_layout,container,false);
            ButterKnife.bind(this,view);
            setView();
            return view;
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

             getRepositoryContributor();
        }

    private void setView() {

        // use a linear layout manager
        layoutManager = new GridLayoutManager(getActivity(),3);
        mRecyclerView.setLayoutManager(layoutManager);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        //making the object of the list
        contributorArrayList= new ArrayList<>();
        //setting the Contributor Image and details
        Glide.with(getActivity())
                .load(mDataModel.getOwnerData().getUrlToImage())
                .into(mUserRepoImageview);
        mName.setText(mDataModel.getName());
        mFullname.setText(mDataModel.getFull_name());
        mDescription.setText(mDataModel.getDescription());
        // setting contributors adapter
        adapter = new RepostoriesContributorAdapter(getActivity(),mContributorSelectedListener, contributorArrayList,true);
        mRecyclerView.setAdapter(adapter);

        // View Model
        mContributorViewModel = ViewModelProviders.of(this).get(RepositoryViewModel.class);
        mContributorViewModel.contributors(mDataModel.getFull_name());
    }

    private void getRepositoryContributor() {
        mContributorViewModel.getContributorResponseLiveData().observe(this, articleResponse -> {
            if (articleResponse != null) {

                mProgressbar.setVisibility(View.GONE);
                List<ContributorModel> articles = articleResponse;
                contributorArrayList.addAll(articles);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
