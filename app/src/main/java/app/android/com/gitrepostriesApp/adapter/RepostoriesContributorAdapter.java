package app.android.com.gitrepostriesApp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import app.android.com.gitrepostriesApp.R;
import app.android.com.gitrepostriesApp.listeners.ContributorSelectedListener;
import app.android.com.gitrepostriesApp.listeners.RepoActivityListener;
import app.android.com.gitrepostriesApp.model.ContributorModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RepostoriesContributorAdapter extends RecyclerView.Adapter<RepostoriesContributorAdapter.ViewHolder> {

         private Context context;
        ArrayList<ContributorModel> articleArrayList;
        private boolean isFromContributorRepo;
    private ContributorSelectedListener contributorSelectedListener;

public RepostoriesContributorAdapter(Context context,ContributorSelectedListener mListener, ArrayList<ContributorModel> articleArrayList,boolean flag) {
        this.context = context;
        this.articleArrayList = articleArrayList;
        this.isFromContributorRepo= flag;
        this.contributorSelectedListener= mListener;
        }

@NonNull
@Override
public RepostoriesContributorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repostories_contributor_layout,viewGroup,false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull RepostoriesContributorAdapter.ViewHolder viewHolder, int i) {

        Glide.with(context)
        .load(articleArrayList.get(i).getUrlToImage())
        .into(viewHolder.imgViewCover);

        viewHolder.mContributorName.setText(articleArrayList.get(i).getName());

        viewHolder.imgViewCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contributorSelectedListener.onContributorActivity(articleArrayList.get(i));
            }
        });
        }


@Override
public int getItemCount() {
        return articleArrayList.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder {
     private ImageView imgViewCover;
     private TextView mContributorName;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        imgViewCover=(ImageView) itemView.findViewById(R.id.imgViewCover);
        mContributorName=(TextView) itemView.findViewById(R.id.tvName);
    }
}
}
