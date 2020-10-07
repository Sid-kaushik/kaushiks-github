package app.android.com.gitrepostriesApp.retrofit;

import java.util.List;

import app.android.com.gitrepostriesApp.model.ContributorModel;
import app.android.com.gitrepostriesApp.model.RepositoryModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("repositories")
    Call<List<RepositoryModel>> getRepositoriesArticles();

    @GET("repos/{repo-name}/contributors")
    Call<List<ContributorModel>> getContributorsArticle(@Path(value = "repo-name",encoded = true) String name, @Query("page") int page_no,
                                                        @Query("access_token") String token);

    @GET("users/{username}/repos")
    Call<List<RepositoryModel>> getContributorsInfo(@Path(value = "username", encoded = true) String repo_name);
}