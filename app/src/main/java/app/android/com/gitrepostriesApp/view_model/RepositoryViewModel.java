package app.android.com.gitrepostriesApp.view_model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import app.android.com.gitrepostriesApp.model.ContributorModel;
import app.android.com.gitrepostriesApp.model.RepositoryModel;
import app.android.com.gitrepostriesApp.repository.GitRepository;

import static app.android.com.gitrepostriesApp.constant.AppConstant.PAGE_SIZE;
import static app.android.com.gitrepostriesApp.constant.AppConstant.TOKEN_KEY;


public class RepositoryViewModel extends AndroidViewModel {

    public GitRepository gitRepository;
    private LiveData<List<RepositoryModel>> articleResponseLiveData;
    private LiveData<List<ContributorModel>> contributorResponseLiveData;
    private LiveData<List<RepositoryModel>> contributorDetailResponseLiveData;

    public RepositoryViewModel(@NonNull Application application) {
        super(application);
    }

    public void repositories(){
        gitRepository = new GitRepository();
        this.articleResponseLiveData = gitRepository.getRepositories();
    }

    public void contributors(String name){
        gitRepository = new GitRepository();
        this.contributorResponseLiveData = gitRepository.getContributors(name, PAGE_SIZE, TOKEN_KEY);

    }

    public void contributorsDetails(String full_name){
        gitRepository = new GitRepository();
        this.contributorDetailResponseLiveData = gitRepository.getContributorDetails(full_name);

    }

    public LiveData<List<RepositoryModel>> getArticleResponseLiveData() {
        return articleResponseLiveData;
    }

    public LiveData<List<ContributorModel>> getContributorResponseLiveData() {
        return contributorResponseLiveData;
    }

    public LiveData<List<RepositoryModel>> getContributorDetailResponseLiveData() {
        return contributorDetailResponseLiveData;
    }


}
