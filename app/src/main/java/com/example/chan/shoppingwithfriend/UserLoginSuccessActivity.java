package com.example.chan.shoppingwithfriend;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class UserLoginSuccessActivity extends ActionBarActivity {
    public final static String USER_NAME = "com.example.chan.shoppingwithfriend.USERNAME";
    // Default username set to unknown
    String username = "unknown";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        getMenuInflater().inflate(R.menu.friend, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_friends:
                displayFriend();
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Called when the user clicks the logout button
     */
    /**
     * logout
     * @param view logout
     */
    public void logout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the friend's username from the intent
        Intent intent = getIntent();
        username = intent.getStringExtra(LoginActivity.USER_NAME);

        setContentView(R.layout.activity_user_login_suceess);
        TextView usernametextElement = (TextView) findViewById(R.id.usernameView);
        usernametextElement.setText(username); //leave this line to assign a specific text
    }

    /**
     * Extra: user's username
     * Start FriendActivity
     */
    public void displayFriend() {
        Intent intent = new Intent(this, FriendActivity.class);
        //username = "dummy";
        intent.putExtra(USER_NAME, username);
        startActivity(intent);
    }
}
