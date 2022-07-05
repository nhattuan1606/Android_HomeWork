package com.example.asynctaskloader;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.app.LoaderManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Loader implements LoaderManager.LoaderCallbacks<String> {
//    private EditText editText = null;
    private final TextView textTitle, textAuthor;
    private final Context context;

    Loader(Context context, TextView textTitle, TextView textAuthor) {
        this.context = context;
        this.textTitle = textTitle;
        this.textAuthor = textAuthor;
    }

    @NonNull
    @Override
    public androidx.loader.content.Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryString = "";

        if (args != null) {
            queryString = args.getString("queryString");
        }

        return new BookLoader(context, queryString);
    }

    @Override
    public void onLoadFinished(@NonNull androidx.loader.content.Loader<String> loader, String data) {
        try {
            // Convert the response into a JSON object.
            JSONObject jsonObject = new JSONObject(data);
            // Get the JSONArray of book items.
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            // Initialize iterator and results fields.
            int i = 0;
            String title = null;
            String authors = null;

            // Look for results in the items array, exiting when both the
            // title and author are found or when all items have been checked.
            while (i < itemsArray.length() &&
                    (authors == null && title == null)) {
                // Get the current item information.
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                // Try to get the author and title from the current item,
                // catch if either field is empty and move on.
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Move to the next item.
                i++;
            }

            // If both are found, display the result.
            if (title != null && authors != null) {
                textTitle.setText(title);
                textAuthor.setText(authors);
                //mBookInput.setText("");
            } else {
                // If none are found, update the UI to show failed results.
                textTitle.setText(R.string.no_results);
                textAuthor.setText("");
            }

        } catch (Exception e) {
            // If onPostExecute does not receive a proper JSON string,
            // update the UI to show failed results.
            textTitle.setText(R.string.no_results);
            textAuthor.setText("");
            e.printStackTrace();
        }

    }

    @Override
    public void onLoaderReset(@NonNull androidx.loader.content.Loader<String> loader) {
        // Do nothing.  Required by interface.
    }
}
