package app.android.com.gitrepostriesApp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import app.android.com.gitrepostriesApp.R;
import app.android.com.gitrepostriesApp.listeners.RepoActivityListener;
import app.android.com.gitrepostriesApp.model.RepositoryModel;

public class TopGitRepositoryAdapter extends RecyclerView.Adapter<TopGitRepositoryAdapter.ViewHolder> {

    private Context context;
    ArrayList<RepositoryModel> articleArrayList;
    private RepoActivityListener repoActivityListener;

    public TopGitRepositoryAdapter(Context context,RepoActivityListener mListener, ArrayList<RepositoryModel> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
        this.repoActivityListener= mListener;
    }

    @NonNull
    @Override
    public TopGitRepositoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.top_git_repository_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopGitRepositoryAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvTitle.setText(articleArrayList.get(i).getName());
        viewHolder.tvRepo.setText(articleArrayList.get(i).getFull_name());
        Glide.with(context)
                .load(articleArrayList.get(i).getOwnerData().getUrlToImage())
                .into(viewHolder.imgViewCover);

        viewHolder.mConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    repoActivityListener.onRepoActivity(articleArrayList.get(i));

            }
        });
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  ImageView imgViewCover;
        private  TextView tvTitle;
        private  TextView tvRepo;
        private ConstraintLayout mConstraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgViewCover=(ImageView) itemView.findViewById(R.id.imgViewCover);
            tvTitle=(TextView) itemView.findViewById(R.id.tvTitle);
            tvRepo=(TextView) itemView.findViewById(R.id.tvAuthorAndPublishedAt);
            mConstraintLayout= (ConstraintLayout)itemView.findViewById(R.id.constraint_layout);
        }
    }
}
