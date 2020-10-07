package app.android.com.gitrepostriesApp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.android.com.gitrepostriesApp.R;
import app.android.com.gitrepostriesApp.adapter.TopGitRepositoryAdapter;
import app.android.com.gitrepostriesApp.listeners.RepoActivityListener;
import app.android.com.gitrepostriesApp.model.RepositoryModel;
import app.android.com.gitrepostriesApp.view_model.RepositoryViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TopGitRepositories extends Fragment {


    @BindView(R.id.progress_circular_repository)
    ProgressBar mProgressbar;

    @BindView(R.id.my_recycler_view)
    RecyclerView my_recycler_view;


    private LinearLayoutManager layoutManager;
    private TopGitRepositoryAdapter adapter;
    private ArrayList<RepositoryModel> articleArrayList;
    RepositoryViewModel articleViewModel;
    private ArrayList<RepositoryModel> newList;
    private View view;
    RepoActivityListener repoActivityListener;

    public TopGitRepositories(RepoActivityListener repoActivityListener){
        this.repoActivityListener = repoActivityListener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.top_git_repository_fragment_layout,container,false);
        ButterKnife.bind(this,view);

        initialization();

        getTopRepostries();
        return view;
    }

    /**
     * initialization of views and others
     *
     * @param @null
     */
    private void initialization() {
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        my_recycler_view.setLayoutManager(layoutManager);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        my_recycler_view.setHasFixedSize(true);
        articleArrayList= new ArrayList<>();
        // adapter
        adapter = new TopGitRepositoryAdapter(getActivity(),repoActivityListener, articleArrayList);
        my_recycler_view.setAdapter(adapter);

        // View Model
        articleViewModel = ViewModelProviders.of(this).get(RepositoryViewModel.class);
        articleViewModel.repositories();
    }

    /**
     * get repo data from github api
     *
     * @param @null
     */
    private void getTopRepostries() {
        articleViewModel.getArticleResponseLiveData().observe(this, articleResponse -> {
            if (articleResponse != null) {
                mProgressbar.setVisibility(View.GONE);
                List<RepositoryModel> articles = articleResponse;
                // logic to show only 20 Top repository of Github on recyclerview
                if (articles.size()>20) {
                    newList = new ArrayList<>(articles.subList(0, 20));
                    articleArrayList.addAll(newList);
                }else {
                    articleArrayList.addAll(articles);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}
