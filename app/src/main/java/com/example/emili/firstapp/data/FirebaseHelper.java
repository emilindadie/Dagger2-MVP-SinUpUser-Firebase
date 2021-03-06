package com.example.emili.firstapp.data;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import javax.inject.Singleton;

/**
 * Created by emili on 21/10/2017.
 */

@Singleton
public class FirebaseHelper {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseStorage firebaseStorage;
    private StorageReference profilPictures;
    private StorageReference messagePictures;

    public FirebaseHelper(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        profilPictures = firebaseStorage.getReference().child("profil_pictures");
        messagePictures = firebaseStorage.getReference().child("message_pictures");
    }

    public FirebaseAuth getFirebaseAuth(){
        return firebaseAuth;
    }

    public DatabaseReference getUserDataReference(FirebaseUser firebaseUser){
        if(firebaseUser != null){
            return  databaseReference.child("users").child(firebaseUser.getUid());
        }
        return null;
    }


    public DatabaseReference getUrlMessageDataReference(){
            return  databaseReference.child("url_messages");
    }

    //get profil picture references
    public StorageReference getProfilPicturesReference(){
        return profilPictures;
    }

    public StorageReference getMessagePicturesReference(){
        return messagePictures;
    }

    public DatabaseReference getChatMessageDataReference(){
        return databaseReference.child("chat");
    }
}
