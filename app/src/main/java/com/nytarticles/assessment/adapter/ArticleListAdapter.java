package com.nytarticles.assessment.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nytarticles.assessment.R;
import com.nytarticles.assessment.model.Result;
import com.nytarticles.assessment.util.Constant;
import com.nytarticles.assessment.view.ArticlesDetailsActivity;
import com.nytarticles.assessment.viewutils.CircleTransformation;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.MyViewHolder> {

    private List<Result> responseResult;

    public ArticleListAdapter(List<Result> responseResult) {
        this.responseResult = responseResult;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Result result = responseResult.get(position);
        holder.tvArticleHeadLine.setText(result.getTitle());
        holder.tvArticleByLine.setText(result.getByline());
        holder.tvArticleSource.setText(result.getSource());
        holder.tvArticleDate.setText(result.getPublishedDate());
        String imageUrl = result.getMedia().get(0).getMediaMetadata().get(1).getUrl();
        if (null != imageUrl) {
            Picasso.get().load(imageUrl)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .transform(new CircleTransformation())
                    .into(holder.ivArticleImage);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ArticlesDetailsActivity.class);
                intent.putExtra(Constant.IMAGE_URL,result.getMedia().get(0).getMediaMetadata().get(6).getUrl());
                intent.putExtra(Constant.IMAGE_CAPTION,result.getMedia().get(0).getCaption());
                intent.putExtra(Constant.ARTICLE_DETAILS,result.getAbstract());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return responseResult.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.thumbnailView) ImageView ivArticleImage;
        @BindView(R.id.articlesHeadLine) TextView tvArticleHeadLine;
        @BindView(R.id.articleByLine) TextView tvArticleByLine;
        @BindView(R.id.articleSource) TextView tvArticleSource;
        @BindView(R.id.articleDate) TextView tvArticleDate;
        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
