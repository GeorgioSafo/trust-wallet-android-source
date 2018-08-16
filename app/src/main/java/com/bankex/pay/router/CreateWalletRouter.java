package com.bankex.pay.router;

import android.content.Context;
import android.content.Intent;

import com.bankex.pay.ui.CreateWalletActivity;
import com.bankex.pay.ui.WalletCreatedActivity;

/**
 * @author Denis Anisimov.
 */
public class CreateWalletRouter {

    public void open(Context context) {
        Intent intent = new Intent(context, CreateWalletActivity.class);

        context.startActivity(intent);
    }
}
