package com.bankex.pay.widget;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bankex.pay.R;

import io.bloco.faker.Faker;


public class AttentionWalletView extends FrameLayout implements View.OnClickListener {
    public static final int WORD_COUNT = 12;
    private OnNextClickListener mOnNextClickListener;
    private OnCopyPhraseClickListener mOnCopyPhraseClickListener;
    private TextView mTvfaker;

    public AttentionWalletView(Context context) {
        this(context, R.layout.layout_dialog_add_account);
    }

    private AttentionWalletView(Context context, @LayoutRes int layoutId) {
        super(context);

        init(layoutId);
    }

    private void init(@LayoutRes int layoutId) {
        LayoutInflater.from(getContext()).inflate(layoutId, this, true);
        findViewById(R.id.copyPhrase).setOnClickListener(this);
        findViewById(R.id.next).setOnClickListener(this);
        Faker faker = new Faker();
        String sentence = faker.lorem.sentence(WORD_COUNT);
        mTvfaker = findViewById(R.id.faker);
        mTvfaker.setText(sentence);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.copyPhrase: {
                if (mOnCopyPhraseClickListener != null) {
                    mOnCopyPhraseClickListener.onCopyPhrase(mTvfaker.getText().toString());
                }
            }
            break;
            case R.id.next: {
                if (mOnNextClickListener != null) {
                    mOnNextClickListener.onNext(view);
                }
            }
            break;
        }
    }

    public void setOnNextClickListener(OnNextClickListener onNextClickListener) {
        this.mOnNextClickListener = onNextClickListener;
    }

    public void setOnCopyPhraseClickListener(OnCopyPhraseClickListener onCopyPhraseClickListener) {
        this.mOnCopyPhraseClickListener = onCopyPhraseClickListener;
    }

    public interface OnNextClickListener {
        void onNext(View view);
    }

    public interface OnCopyPhraseClickListener {
        void onCopyPhrase(String phrase);
    }
}
