
package com.example.flixster.models;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated("org.parceler.ParcelAnnotationProcessor")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class movie$$Parcelable
    implements Parcelable, ParcelWrapper<com.example.flixster.models.movie>
{

    private com.example.flixster.models.movie movie$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<movie$$Parcelable>CREATOR = new Creator<movie$$Parcelable>() {


        @Override
        public movie$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new movie$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public movie$$Parcelable[] newArray(int size) {
            return new movie$$Parcelable[size] ;
        }

    }
    ;

    public movie$$Parcelable(com.example.flixster.models.movie movie$$2) {
        movie$$0 = movie$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(movie$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.example.flixster.models.movie movie$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(movie$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(movie$$1));
            parcel$$1 .writeString(movie$$1 .backdrop_path);
            parcel$$1 .writeString(movie$$1 .overView);
            parcel$$1 .writeDouble(movie$$1 .rating);
            parcel$$1 .writeInt(movie$$1 .movieId);
            parcel$$1 .writeString(movie$$1 .title);
            parcel$$1 .writeString(movie$$1 .posterPath);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.example.flixster.models.movie getParcel() {
        return movie$$0;
    }

    public static com.example.flixster.models.movie read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.example.flixster.models.movie movie$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            movie$$4 = new com.example.flixster.models.movie();
            identityMap$$1 .put(reservation$$0, movie$$4);
            movie$$4 .backdrop_path = parcel$$3 .readString();
            movie$$4 .overView = parcel$$3 .readString();
            movie$$4 .rating = parcel$$3 .readDouble();
            movie$$4 .movieId = parcel$$3 .readInt();
            movie$$4 .title = parcel$$3 .readString();
            movie$$4 .posterPath = parcel$$3 .readString();
            com.example.flixster.models.movie movie$$3 = movie$$4;
            identityMap$$1 .put(identity$$1, movie$$3);
            return movie$$3;
        }
    }

}
