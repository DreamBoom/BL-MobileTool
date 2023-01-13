plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Build.compileSdk)
    defaultConfig {
        minSdkVersion(Build.minSdk)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // Support
    api(Deps.support_coreKtx)
    api(Deps.support_appCompat)
    api(Deps.support_material)
    api(Deps.support_constraintLayout)
    api(Deps.support_preference)

    // Kotlin
    api(Deps.kotlin_stdlib)
    api(Deps.kotlin_coroutines)

    // 注入
    api(Deps.daggerHiltAndroid)
    api(Deps.hiltCommon)
    api(Deps.hiltViewModel)
    api(Deps.hiltWorker)
    kapt(Deps.daggerHiltCompiler)
    kapt(Deps.hiltCompiler)

    // netWork
    api(Deps.network_retrofit)
    api(Deps.network_retrofitMoshi)
    api(Deps.okhttp)
    api(Deps.okhttpLogInterceptor)

    // Json
    api(Deps.moshi)
    api(Deps.moshi_adapters)
    kapt(Deps.moshi_compiler)

    // Navigation
    api(Deps.navigation)
    api(Deps.navigation_ui)

    // Log
    api(Deps.timber)

    // Lifecycle
    api(Deps.androidLifecycleKtx)
    api(Deps.androidViewModelKtx)

    api(Deps.mmkv_runtime)

    // loading
    api(Deps.loading)

    // glide
    api(Deps.glide)
    kapt(Deps.glide_compiler)

    // paging
    api(Deps.paging)

    // Work
    api(Deps.runtimeKtx)
}