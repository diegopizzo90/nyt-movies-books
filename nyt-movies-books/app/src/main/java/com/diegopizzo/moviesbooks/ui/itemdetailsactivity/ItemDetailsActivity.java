package com.diegopizzo.moviesbooks.ui.itemdetailsactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.business.network.model.movies.ResultDetails;
import com.diegopizzo.moviesbooks.config.MoviesBooksApplication;
import com.diegopizzo.moviesbooks.config.mvp.AbstractMvpActivity;
import com.diegopizzo.moviesbooks.ui.mainactivity.moviesreviewsfragment.MoviesReviewsAdapter;

import butterknife.BindView;

/**
 * Created by diegopizzo on 27/11/2017.
 */

public class ItemDetailsActivity extends AbstractMvpActivity<ItemDetailsActivityContract.Presenter>
        implements ItemDetailsActivityContract.View {

    @BindView(R.id.itemImageView)
    ImageView itemImageView;
    @BindView(R.id.itemTitleTextView)
    TextView itemTitleTextView;
    @BindView(R.id.itemAuthorTextView)
    TextView itemAuthorTextView;
    @BindView(R.id.itemDescriptionTextView)
    TextView itemDescriptionTextView;
    @BindView(R.id.itemTitleDescriptionTextView)
    TextView itemTitleDescriptionTextView;
    @BindView(R.id.button)
    Button button;


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        passDataFromSelectedItemToPresenter();
    }

    @Override
    protected void inject() {
        DaggerItemDetailsActivityComponent.builder()
                .applicationComponent(((MoviesBooksApplication) getApplication()).getApplicationComponent())
                .itemDetailsActivityModule(new ItemDetailsActivityModule(this)).build().inject(this);
    }

    @Override
    public void setDataOfMovieReview(final ResultDetails resultDetails) {
        itemTitleTextView.setText(resultDetails.getDisplayTitle());
        itemAuthorTextView.setText(resultDetails.getByline());
        itemDescriptionTextView.setText(resultDetails.getSummaryShort());
        itemTitleDescriptionTextView.setText(resultDetails.getHeadline());
        button.setText(R.string.read_more);
        if (resultDetails.getMultimedia() != null) {
            Glide.with(this).load(resultDetails.getMultimedia().getSrc()).into(itemImageView);
        }
        button.setOnClickListener(v -> {
            if (resultDetails.getLink() != null) {
                final String url = resultDetails.getLink().getUrl();
                final Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    private void passDataFromSelectedItemToPresenter() {
        final Intent intent = getIntent();
        if (intent != null) {
            final String titleMovies = intent.getStringExtra(MoviesReviewsAdapter.MOVIE_TITLE_BUNDLE);
            if (!TextUtils.isEmpty(titleMovies)) {
                presenter.getSelectedMovieDetails(titleMovies);
            } else {

            }
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.item_details_layout;
    }

    @Override
    protected View getRootLayoutView() {
        return null;
    }
}
