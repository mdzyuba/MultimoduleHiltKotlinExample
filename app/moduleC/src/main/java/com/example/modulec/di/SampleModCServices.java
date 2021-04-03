package com.example.modulec.di;

import com.example.modulec.services.Service001;
import com.example.modulec.services.Service001Impl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class SampleModCServices {
  @Binds
  public abstract Service001 bindService001(Service001Impl s);
}
