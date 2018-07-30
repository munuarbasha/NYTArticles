package com.nytarticles.assessment.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.nytarticles.assessment.model.Response;
import com.nytarticles.assessment.R;
import com.nytarticles.assessment.adapter.ArticleListAdapter;
import com.nytarticles.assessment.viewpresenter.ArticlePresenter;
import com.nytarticles.assessment.viewpresenter.ArticleViewInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ArticleListActivity extends AppCompatActivity implements ArticleViewInterface {
    @BindView(R.id.articleListView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private ArticlePresenter articlePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        articlePresenter = new ArticlePresenter(ArticleListActivity.this);
        initializeViews();
        getMostPopularArticles();

    }

    private void getMostPopularArticles() {
        progressBar.setVisibility(View.VISIBLE);
        articlePresenter.getPopularList();
    }

    private void initializeViews() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_more) {
            // handle more option click here
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void displayArticles(Response response) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        if (null != response) {
            ArticleListAdapter articleListAdapter = new ArticleListAdapter(response.getResults());
            recyclerView.setAdapter(articleListAdapter);
        }
    }

    @Override
    public void displayError(String errorMessage) {
        progressBar.setVisibility(View.GONE);
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.error))
                .setMessage(errorMessage)
                .setNegativeButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Timber.d("Dialog Clicked");
                    }
                }).show();
    }
}
