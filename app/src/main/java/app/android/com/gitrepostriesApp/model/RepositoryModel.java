package app.android.com.gitrepostriesApp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RepositoryModel implements Parcelable {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private String full_name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("owner")
    @Expose
    private Owner ownerData= null;


    protected RepositoryModel(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        full_name = in.readString();
        description = in.readString();
        ownerData = in.readParcelable(Owner.class.getClassLoader());
    }

    public static final Creator<RepositoryModel> CREATOR = new Creator<RepositoryModel>() {
        @Override
        public RepositoryModel createFromParcel(Parcel in) {
            return new RepositoryModel(in);
        }

        @Override
        public RepositoryModel[] newArray(int size) {
            return new RepositoryModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Owner getOwnerData() {
        return ownerData;
    }

    public void setOwnerData(Owner ownerData) {
        this.ownerData = ownerData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(name);
        dest.writeString(full_name);
        dest.writeString(description);
        dest.writeParcelable(ownerData, flags);
    }
}
