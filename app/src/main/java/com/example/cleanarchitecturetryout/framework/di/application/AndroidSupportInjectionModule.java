package com.example.cleanarchitecturetryout.framework.di.application;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.internal.Beta;

@Beta
@Module(includes = AndroidInjectionModule.class)
public abstract class AndroidSupportInjectionModule {
    private AndroidSupportInjectionModule() {}
}
