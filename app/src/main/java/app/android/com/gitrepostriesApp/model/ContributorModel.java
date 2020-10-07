package app.android.com.gitrepostriesApp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContributorModel implements Parcelable {

    @SerializedName("login")
    @Expose
    private String name;
    @SerializedName("avatar_url")
    @Expose
    private String UrlToImage;

    protected ContributorModel(Parcel in) {
        name = in.readString();
        UrlToImage = in.readString();
    }

    public static final Creator<ContributorModel> CREATOR = new Creator<ContributorModel>() {
        @Override
        public ContributorModel createFromParcel(Parcel in) {
            return new ContributorModel(in);
        }

        @Override
        public ContributorModel[] newArray(int size) {
            return new ContributorModel[size];
        }
    };

    public String getUrlToImage() {
        return UrlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        UrlToImage = urlToImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(UrlToImage);
    }
}
