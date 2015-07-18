package com.github;

import retrofit.Retrofit;
import retrofit.Retrofit.*;

import auto.json.AutoJson;

import rx.Observable;
import android.support.annotation.Nullable;

@Retrofit("https://api.github.com")
public abstract class GitHub {
    @GET("/repos/{owner}/{repo}/contributors")
    public abstract Observable<Contributor> contributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

    @GET("https://api2.github.com/repos/{owner}/{repo}/contributors")
    public abstract Observable<Contributor> contributors2(
            @Path("owner") String owner,
            @Path("repo") String repo);

    @GET("{owner}")
    public abstract Observable<Contributor> contributorsDynamic( @Path("owner") String owner);

    public static GitHub create() {
        return new Retrofit_GitHub();
    }
}
