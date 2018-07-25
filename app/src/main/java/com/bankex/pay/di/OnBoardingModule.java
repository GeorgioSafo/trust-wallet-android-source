package com.bankex.pay.di;

import android.content.Context;

import com.bankex.pay.interact.FetchWalletsInteract;
import com.bankex.pay.repository.PreferenceRepositoryType;
import com.bankex.pay.repository.SharedPreferenceRepository;
import com.bankex.pay.repository.WalletRepositoryType;
import com.bankex.pay.viewmodel.SplashViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class OnBoardingModule {

    @Provides
    SplashViewModelFactory provideSplashViewModelFactory(FetchWalletsInteract fetchWalletsInteract) {
        return new SplashViewModelFactory(fetchWalletsInteract);
    }

    @Provides
    FetchWalletsInteract provideFetchWalletInteract(WalletRepositoryType walletRepository) {
        return new FetchWalletsInteract(walletRepository);
    }
}
