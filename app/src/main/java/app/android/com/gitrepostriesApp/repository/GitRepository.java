package app.android.com.gitrepostriesApp.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import app.android.com.gitrepostriesApp.model.ContributorModel;
import app.android.com.gitrepostriesApp.model.RepositoryModel;
import app.android.com.gitrepostriesApp.retrofit.ApiRequest;
import app.android.com.gitrepostriesApp.retrofit.RetrofitRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitRepository {
    private static final String TAG = GitRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public GitRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData< List<RepositoryModel>> getRepositories() {
        final MutableLiveData< List<RepositoryModel>> data = new MutableLiveData<>();
        apiRequest.getRepositoriesArticles()
                .enqueue(new Callback<List<RepositoryModel>>() {


                    @Override
                    public void onResponse(Call<List<RepositoryModel>> call, Response<List<RepositoryModel>> response) {
                        Log.d(TAG, "onResponse response:: " + response);



                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.d(TAG, "articles size:: " + response.body().size());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<RepositoryModel>> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }

    public LiveData< List<ContributorModel>> getContributors(String repo_name,Integer page_size,String token) {
        final MutableLiveData< List<ContributorModel>> data = new MutableLiveData<>();
        apiRequest.getContributorsArticle(repo_name,page_size,token)
                .enqueue(new Callback<List<ContributorModel>>() {


                    @Override
                    public void onResponse(Call<List<ContributorModel>> call, Response<List<ContributorModel>> response) {
                        Log.d(TAG, "onResponse response:: " + response);



                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.d(TAG, "articles size:: " + response.body().size());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ContributorModel>> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }

    public LiveData< List<RepositoryModel>> getContributorDetails(String username) {
        final MutableLiveData< List<RepositoryModel>> data = new MutableLiveData<>();
        apiRequest.getContributorsInfo(username)
                .enqueue(new Callback<List<RepositoryModel>>() {


                    @Override
                    public void onResponse(Call<List<RepositoryModel>> call, Response<List<RepositoryModel>> response) {
                        Log.d(TAG, "onResponse response:: " + response);



                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.d(TAG, "articles size:: " + response.body().size());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<RepositoryModel>> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
