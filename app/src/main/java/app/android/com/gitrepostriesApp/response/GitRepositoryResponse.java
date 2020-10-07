package app.android.com.gitrepostriesApp.response;

import java.util.List;

import app.android.com.gitrepostriesApp.model.RepositoryModel;

public class GitRepositoryResponse {
    /*@SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private String full_name;
    @SerializedName("owner")
    @Expose*/
    private List<RepositoryModel> articles = null;

    public List<RepositoryModel> getArticles() {
        return articles;
    }

    public void setArticles(List<RepositoryModel> articles) {
        this.articles = articles;
    }
}
