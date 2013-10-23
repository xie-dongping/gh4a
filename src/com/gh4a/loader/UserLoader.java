package com.gh4a.loader;

import java.io.IOException;

import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.UserService;

import android.content.Context;

import com.gh4a.Gh4Application;

public class UserLoader extends BaseLoader<User> {

    private String mLogin;
    
    public UserLoader(Context context, String login) {
        super(context);
        this.mLogin = login;
    }
    
    @Override
    public User doLoadInBackground() throws IOException {
        Gh4Application app = (Gh4Application) getContext().getApplicationContext();
        GitHubClient client = new GitHubClient();
        client.setOAuth2Token(app.getAuthToken());
        UserService userService = new UserService(client);
        return userService.getUser(mLogin);
    }
}
