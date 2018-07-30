package com.nytarticles.assessment.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.nytarticles.assessment.R;
import com.nytarticles.assessment.util.Constant;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlesDetailsActivity extends AppCompatActivity {
    @BindView(R.id.ivArticleImage)
    ImageView ivArticleImage;
    @BindView(R.id.tvCaption)
    TextView tvCaption;
    @BindView(R.id.tvArticleDetails)
    TextView tvArticleDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            tvCaption.setText(bundle.getString(Constant.IMAGE_CAPTION));
            tvArticleDetails.setText(bundle.getString(Constant.ARTICLE_DETAILS));
            String imageUrl = bundle.getString(Constant.IMAGE_URL);
            if (null != imageUrl) {
                Picasso.get().load(imageUrl).placeholder(R.drawable.ic_launcher_background).into(ivArticleImage);
            }
        }
    }
}
